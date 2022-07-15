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

/**Menu driven interface for the implementation of the project
 *CN5004 Coursework
 * @author Akachukwu Victor Anierobi 
 * Student ID:U1930172
 */
public class Mainmenu {

    
    public static void main(String[] args) {
        // TODO code application logic here
        
        char choice;
        int size;
        AppointmentList List;
        PatientList patients = new PatientList(5);
        
        
        //get size of the list
        System.out.println("SIZE OF THE LIST? ");
        size=EasyScanner.nextInt();
        List = new AppointmentList(size);
        
        //Mainmenu
        do
        {
            System.out.println("[1] ENTER 1 IF YOU ARE A PATIENT ");
            System.out.println("[2] Enter 2 IF YOU ARE A DOCTOR  ");
            System.out.println("[3] SAVE & EXIT");
            System.out.println();
            System.out.print("ENTER A CHOICE[1-6]: ");
            
            //get choice
            choice=EasyScanner.nextChar();
            System.out.println();
            
            //process choice
            switch(choice)
            {
                case '1': option1(List); 
                                  break;
                case '2': option2(patients); 
                                  break;
                case '3': System.out.println("TESTING COMPLETED");
                default: System.out.println("PLEASE CHOOSE A NUMBER FROM 1-3 ONLY");
            }
        }
        while (choice !='3');  
    }
    //PATIENT MENU
    static void option1(AppointmentList List)
    {
        char choice;
        int size;
        
        //get size of the list
        System.out.println("SIZE OF THE LIST? ");
        size=EasyScanner.nextInt();
        List = new AppointmentList(size); //declare object to test 
        
        //second menu
        do
        {
            //display options
            System.out.println();
            System.out.println("[1] ENTER 1 TO VIEW THE DOCTORS ");
            System.out.println("[2] ENTER 2 TO VIEW THE CLINIC INFORMATIONS ");
            System.out.println("[3] ENTER 3 TO BOOK AN APPOINTMENT");
            System.out.println("[4] ENTER 4 TO VIEW AN APPOINTMENT");
            System.out.println("[5] ENTER 5 TO CANCEL AN APPOINTMENT");
            System.out.println("[6] SAVE & EXIT");
            System.out.println();
            System.out.print("ENTER A CHOICE[1-6]: ");
            
            //GET CHOICE
            choice=EasyScanner.nextChar();
            System.out.println();
            
            //PROCESS CHOICE
            switch(choice)
            {
                case '1': option3(List); 
                                  break;
                case '2': option4(List); 
                                  break;
                case '3': option5(List); 
                                  break;
                case '4': option6(List); 
                                  break;
                case '5': option7(List); 
                                  break;
                case '6': option8(List); 
                                  break;
                default: System.out.println("PLEASE CHOOSE A NUMBER FROM 1-6 ONLY");  
            }
        }
        while(choice !='6');   
    }
    
    //VIEW DOCTORS
    static void option3(AppointmentList ListIn)
    {
        System.out.println("DR JACK SMITH     9AM-5PM  MONDAY-FRIDAY MOBILE N. 07399826543");
        System.out.println("DR AMANDA LARKIN  8AM-5PM  MONDAY-FRIDAY MOBILE N. 07449586321");
        System.out.println("DR AMANDEEP SINGH 8AM-5PM  MONDAY-FRIDAY MOBILE N. 07433646542");
        System.out.println("DR VINCENT OKELE  10AM-6PM MONDAY-FRIDAY M0BILE N. 07396877745");
        System.out.println(ListIn);  //call to string method of Appointment
    }
    
    //VIEW CLINIC DETAILS
    static void option4(AppointmentList ListIn)
    {
        System.out.println("THE SURGERY WORKS ON SERVIVE FROM MONDAY TO FRIDAY");
        System.out.println("THE DOCTORS ARE AVAILABLE ONLY THROUGH THE ONLINE BOOKING SYSTEM ");
        System.out.println("OUR ADDRESS IS UNIVERSITY WAY, LONDON, E16 2RG ");
        System.out.println(ListIn);
    }
    
    //BOOK APPOINTMENT
    static void option5(AppointmentList ListIn)
    {
        //prompt to choose the time and day for appointment
        System.out.print("ENTER TIME: ");
        double time = EasyScanner.nextDouble();
        System.out.print("ENTER DAY FROM MONDAY TO FRIDAY: ");
        String day = EasyScanner.nextString();
        System.out.print("ENTER DOCTOR SURNAME: ");
        String doctor = EasyScanner.nextString();
        
        //create a new appointment object from input
        Appointment a = new Appointment(time,day,doctor);
        
        //attempt to add a new appointment
        boolean ok = ListIn.addAppointment(a);
        if(!ok)
        {
            System.out.println("ERROR: THE LIST IS FULL ");
        }
    }
    
    //DISPLAY
    static void option6(AppointmentList ListIn)
    {
        System.out.println("ITEMS ENTERED");
        System.out.println(ListIn); //call toString method of Patient
    }
    
    //CANCEL APPOINTMENT
    static void option7(AppointmentList ListIn)
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
         static void option8(AppointmentList ListIn)
        {
            // use try-with-resources to ensure file is closed safely
		try(
				/* create a FileWriter object, AppointmentFile, that handles the low-level details of writing 
              the list to a file which we have called "Cars.txt" */
			    FileWriter AppointmentFile = new FileWriter("Appointments.txt");
			    /* now create a PrintWriter object to wrap around AppointmentFile; this allows us to user 
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
                
                 System.out.println("TESTING COMPLETED");
	}
        
    
    //DOCTOR MENU
    static void option2(PatientList List)
    {
         char choice;
        int size;
        
        // get size of the list 
        System.out.println("SIZE OF THE LIST? ");
        size=EasyScanner.nextInt();
         
        
        // THIRD MENU
        do
        {
            // display options
            System.out.println();
            System.out.println("[1] ENTER 1 TO ADD A PATIENT");
            System.out.println("[2] ENTER 2 TO DISPLAY PATIENTS");
            System.out.println("[3] ENTER 3 TO CHECK IF LIST IS FULL");
            System.out.println("[4] ENTER 4 TO VIEW PATIENT");
            System.out.println("[5] ENTER 5 TO VIEW TOTAL NUMBER OF PATIENTS");
            System.out.println("[6] SAVE & EXIT");
            System.out.println();
            System.out.print("ENTER A CHOICE[1-6]");
            //get choice
            choice=EasyScanner.nextChar();
            System.out.println();
            //process choice
            switch(choice)
            {
                case '1':  option9(List); 
                           break;
                case '2': option10(List); 
                           break;
                case '3': option11(List); 
                           break;
                case '4': option12(List); 
                           break;
                case '5': option13(List);
                           break;
                case '6': option14(List);
                           break;
                default: System.out.println("PLEASE CHOOSE A NUMBER FROM 1-6 ONLY");
            }
        }
        while(choice != '6');    
    }
    
    //ADD
    static void option9(PatientList ListIn)
    {
        //prompt for patient details
        System.out.print("ENTER NAME: ");
        String name = EasyScanner.nextString();
        System.out.print("ENTER SURNAME: ");
        String surname = EasyScanner.nextString();
        System.out.print("ENTER AGE: ");
        int age = EasyScanner.nextInt();
        System.out.print("ENTER DIAGNOSIS: ");
        String diagnosis = EasyScanner.nextString();
        System.out.print("ENTER TREATMENT: ");
        String treatment = EasyScanner.nextString();
        //create a new Patient object from input 
        Patient p = new Patient(name,surname,age,diagnosis,treatment);
        //attempt to add new patient to the list 
        boolean ok = ListIn.addPatient(p); //value of false sent back if unable to add patient
        if(!ok)  //check if item was not added 
        {
            System.out.println("ERROR: LIST IS FULL");
        }
    }
    
    //DISPLAY
    static void option10(PatientList ListIn)
    {
        System.out.println("ITEMS ENTERED");
        System.out.println(ListIn); //call toString method of Patient
    }
    
    //IS FULL
    static void option11(PatientList ListIn)
    {
        if(ListIn.isFull())
        {
            System.out.println("LIST IS FULL");
        }
        else
        {
            System.out.println("LIST IS NOT FULL");
        }
    }
    
    //VIEW PATIENT
    static void option12(PatientList ListIn)
    {
        //prompt to view a patient in the list 
        System.out.print("ENTER PATIENT NUMBER IN THE INDEX TO RETRIEVE: ");
        int num = EasyScanner.nextInt();
        //retrieve patient object from list
        Patient p = ListIn.getPatient(num);
        if (p != null)  //check if patient retrieved 
        {
            System.out.println(p);
        }
        else
        {
            System.out.println("INVALID PATIENT NUMBER");  //invalid position error
        }
    }
    
    // GET TOTAL
    static void option13(PatientList ListIn)
    {
        System.out.print("TOTAL NUMBER OF PATIENT ENTERED IS ");
        System.out.println(ListIn.getTotal());
    }
    
    static void option14(PatientList ListIn)
        {
            // use try-with-resources to ensure file is closed safely
		try(
				/* create a FileWriter object, PatientFile, that handles the low-level details of writing 
              the list to a file which we have called "Patient.txt" */
			    FileWriter PatientFile = new FileWriter("Patient.txt");
			    /* now create a PrintWriter object to wrap around PatientFile; this allows us to user 
              high-level functions such as println */
			    PrintWriter PatientWriter = new PrintWriter(PatientFile);
		   )
		{	
			// write each element of the list to the file 
                        ArrayList<Patient> theList = ListIn.getList();
			for(Patient item : theList)
			{
			   PatientWriter.println(item.getname());
			   PatientWriter.println(item.getsurname());
                           PatientWriter.println(item.getAge());
                           PatientWriter.println(item.getDiagnosis());
			   PatientWriter.println(item.getTreatment()); // println can accept a double, and write it as a string
		   }
		}
		// handle the exception thrown by the FileWriter methods
		catch(IOException e)
		{
			System.out.println("There was a problem writing the file");
		} 
         System.out.println("TESTING COMPLETED");
	}
    static void readList(List<Patient> patientListIn)
    {
         boolean endOfFile = false;
         Patient tempPatient;
         
         // use try-with-resources to ensure file is closed safely
         try( 
               // create a FileInputStream object, carFile
               FileInputStream patientFile = new FileInputStream("Vehicles.bin");
               // create an ObjectInputStream object to wrap around carFile
               ObjectInputStream carStream = new ObjectInputStream(patientFile);
            )
         {
           
            // read the first (whole) object with the readObject method
            tempPatient =  (Patient) carStream.readObject();
            while(endOfFile != true)
            {
                try
                 {
                     patientListIn.add(tempPatient);
                    // read the next (whole) object 
                    tempPatient = (Patient) carStream.readObject();
                }

                /* use the fact that readObject throws an EOFException to
                   check whether the end of the file has been reached */
                catch(EOFException  e)
                {
                    endOfFile = true;
                }
            }
           
         }

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

    }

}

        
    

