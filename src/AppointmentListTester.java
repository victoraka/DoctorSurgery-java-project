
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Victor
 */
public class AppointmentListTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        char choice;
        int size;
        AppointmentList List; //declare Appointment object to test
 	
        //get size of the list
        System.out.println("SIZE OF THE LIST? ");
        size=EasyScanner.nextInt();
        List = new AppointmentList(size); //declare object to test 
        readList(List);
        
        //menu
        do
        {
            //display options
            System.out.println();
            System.out.println("[1] VIEW DOCTORS ");
            System.out.println("[2] VIEW CLINIC INFORMATIONS ");
            System.out.println("[3] BOOK APPOINTMENT");
            System.out.println("[4] VIEW APPOINTMENT");
            System.out.println("[5] CANCEL APPOINTMENT");
            System.out.println("[6] SAVE AND EXIT");
            
            //GET CHOICE
            choice=EasyScanner.nextChar();
            System.out.println();
            //process choice
            switch(choice)
            {
                case '1': option1(List); break;
                case '2': option2(List); break;
                case '3': option3(List); break;
                case '4': option4(List); break;
                case '5': option5(List); break;
                case '6': option6(List); break;
                default: System.out.println("1-6 only");  
            }
        }
        while(choice !='6');   
    }
    //VIEW DOCTORS
    static void option1(AppointmentList ListIn)
    {
        System.out.println("DR JACK SMITH     9AM-5PM  MONDAY-FRIDAY MOBILE N. 07399826543");
        System.out.println("DR AMANDA LARKIN  8AM-5PM  MONDAY-FRIDAY MOBILE N. 07449586321");
        System.out.println("DR AMANDEEP SINGH 8AM-5PM  MONDAY-FRIDAY MOBILE N. 07433646542");
        System.out.println("DR VINCENT OKELE  10AM-6PM MONDAY-FRIDAY M0BILE N. 07396877745");
        System.out.println(ListIn);  //call to string method of Appointment
    }
    //VIEW CLINIC DETAILS
    static void option2(AppointmentList ListIn)
    {
        System.out.println("THE SURGERY WORKS ON SERVIVE FROM MONDAY TO FRIDAY");
        System.out.println("THE DOCTORS ARE AVAILABLE ONLY THROUGH THE ONLINE BOOKING SYSTEM ");
        System.out.println(ListIn);
    }
    //BOOK APPOINTMENT
    static void option3(AppointmentList ListIn)
    {
        //prompt to choose the time and day for appointment
        System.out.print("ENTER TIME: ");
        double time = EasyScanner.nextDouble();
        System.out.print("ENTER DAY FROM MONDAY TO FRIDAY: ");
        String date = EasyScanner.nextString();
        System.out.print("ENTER DOCTOR SURNAME: ");
        String doctor = EasyScanner.nextString();
        
        //create a new appointment object from input
        Appointment a = new Appointment(time,date,doctor);
        
        //attempt to add a new appointment
        boolean ok = ListIn.addAppointment(a);
        if(!ok)
        {
            System.out.println("ERROR: THE LIST IS FULL ");
        }
    }
    
    //DISPLAY
    static void option4(AppointmentList ListIn)
    {
        System.out.println("ITEMS ENTERED");
        System.out.println(ListIn); //call toString method of Patient
    }
    
    //CANCEL APPOINTMENT
    static void option5(AppointmentList ListIn)
    {
        System.out.println("ENTER THE TIME OF THE APPOINTMENT FOR CANCELATION ");
        double time = EasyScanner.nextDouble();
        
        //delete item if it exists
        boolean found = ListIn.removeAppointment(time);
        if(found)
        {
            System.out.println("APPOINTMENT DELETED! ");
        }
        else
        {
            System.out.println("NO SUCH APPOINTMENT FOUNDED! ");
        }
        
        
    }
    
    static void option6(AppointmentList ListIn)
        {
            // use try-with-resources to ensure file is closed safely
		try(
				/* create a FileWriter object, carFile, that handles the low-level details of writing 
              the list to a file which we have called "Cars.txt" */
			    FileWriter AppointmentFile = new FileWriter("Appointments.txt");
			    /* now create a PrintWriter object to wrap around carFile; this allows us to user 
              high-level functions such as println */
			    PrintWriter AppointmentWriter = new PrintWriter(AppointmentFile);
		   )
		{	
			// write each element of the list to the file 
                        ArrayList<Appointment> theList = ListIn.getList();
			for(Appointment item : theList)
			{
			   AppointmentWriter.println(item.getTime());
			   AppointmentWriter.println(item.getDate());
			   AppointmentWriter.println(item.getDoctor()); // println can accept a double, and write it as a string
		   }
		}
		// handle the exception thrown by the FileWriter methods
		catch(IOException e)
		{
			System.out.println("There was a problem writing the file");
		} 
         
	}
	
	// method for reading the file
	
    static void readList(AppointmentList List)
    {
      /*   boolean endOfFile = false;
         Appointment tempAppointment;
         
         // use try-with-resources to ensure file is closed safely
         try( 
               // create a FileInputStream object, carFile
               FileInputStream carFile = new FileInputStream("Vehicles.bin");
               // create an ObjectInputStream object to wrap around carFile
               ObjectInputStream carStream = new ObjectInputStream(carFile);
            )
         {
           
            // read the first (whole) object with the readObject method
            tempAppointment =  (Appointment) carStream.readObject();
            while(endOfFile != true)
            {
                try
                 {
                    AppointmentListIn.add(tempAppointment);
                    // read the next (whole) object 
                    tempAppointment = (Appointment) AppointmentStream.readObject();
                }

                /* use the fact that readObject throws an EOFException to
                   check whether the end of the file has been reached */
              /*  catch(EOFException  e)
                {
                    endOfFile = true;
                }
            }*/
           
         }
/*
         catch(FileNotFoundException e)
         {
            System.out.println("\nNo file was read");
         }

         catch(ClassNotFoundException e) // thrown by readObject
         {
            System.out.println("\nTrying to read an object of an unknown class");
         }

         catch(StreamCorruptedException e) // thrown by the constructor
         {
            System.out.println("\nUnreadable file format");
         }

         catch(IOException e)
         {
            System.out.println("There was a problem reading the file");
         }
	
    } */
}
