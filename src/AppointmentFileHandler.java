
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class AppointmentFileHandler
{
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

    static void readRecords(AppointmentList list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static void saveRecords(int noOfRooms, AppointmentList list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
