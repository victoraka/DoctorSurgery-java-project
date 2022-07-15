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

/**   
 *
 * @author Victor
 */
public class PatientListTester 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        char choice;
        int size;
        PatientList List; //declare Patient object to test
        
        // get size of the list 
        System.out.println("SIZE OF THE LIST? ");
        size=EasyScanner.nextInt();
        List = new PatientList(size); //declare object to test 
        
        
        // menu
        do
        {
            // display options
            System.out.println();
            System.out.println("[1] ADD PATIENT");
            System.out.println("[2] DISPLAY PATIENTS");
            System.out.println("[3] LIST IS FULL");
            System.out.println("[4] VIEW PATIENT");
            System.out.println("[5] VIEW TOTAL PATIENTS");
            System.out.println("[6] QUIT");
            System.out.println();
            System.out.print("Enter a choice[1-6]");
            //get choice
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
        while(choice != '6');    
    }
    //ADD
    static void option1(PatientList ListIn)
    {
        //prompt for patient details
        System.out.print("Enter Name: ");
        String name = EasyScanner.nextString();
        System.out.print("Enter Surname: ");
        String surname = EasyScanner.nextString();
        System.out.print("Enter Age: ");
        int age = EasyScanner.nextInt();
        System.out.print("Enter Diagnosis: ");
        String diagnosis = EasyScanner.nextString();
        System.out.print("Enter Treatment: ");
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
    static void option2(PatientList ListIn)
    {
        System.out.println("ITEMS ENTERED");
        System.out.println(ListIn); //call toString method of Patient
    }
    //IS FULL
    static void option3(PatientList ListIn)
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
    static void option4(PatientList ListIn)
    {
        //prompt to view a patient in the list 
        System.out.print("Enter patient number to retrieve: ");
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
    static void option5(PatientList ListIn)
    {
        System.out.print("TOTAL NUMBER OF PATIENT ENTERED IS ");
        System.out.println(ListIn.getTotal());
    }
    
   
    
     static void option6(PatientList ListIn)
        {
            // use try-with-resources to ensure file is closed safely
		try(
				/* create a FileWriter object, carFile, that handles the low-level details of writing 
              the list to a file which we have called "Cars.txt" */
			    FileWriter PatientFile = new FileWriter("Patient.txt");
			    /* now create a PrintWriter object to wrap around carFile; this allows us to user 
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
}
