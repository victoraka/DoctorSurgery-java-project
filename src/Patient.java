/** Class use to store Patient details handled by the Doctor
 *CN5004 Coursework
 * @author Akachukwu Victor Anierobi 
 */
public class Patient 
{
    /** Declaring the attributes
    */
    private String name;
    private String surname;
    private int Age;
    private String diagnosis;
    private String treatment;
    
    /**the constructor initialise the parameters 
     * @param nameIn: name of the patient 
     * @param surnameIn: surname of the patient
     * @param AgeIn: age of the patient
     * @param numberIn: phone number of the patient 
    */
  
    public Patient(String nameIn, String surnameIn, int AgeIn, String diagnosisIn, String treatmentIn){
        
        name=nameIn;
        surname=surnameIn;
        Age=AgeIn;
        diagnosis=diagnosisIn;
        treatment=treatmentIn;
        
    }
    
    /** method to read the name of the patient
     * @return returns the name 
    */
    public String getname()
    {
        return name;
    }
     /** method to read the surname of the patient
      * @return returns the surname
    */
    public String getsurname(){
        
        return surname;
    }
     /** method to read the age of the patient
      * @return returns the age
    */
    public int getAge(){
        
        return Age;
    }
     /** method to read the number of the patient
      * @return returns the number
    */
    public String getDiagnosis(){
        
        return diagnosis;
    }
     /** method to read the refNumber of the patient
      * @return returns the refNumber
    */
    public String getTreatment(){
        
        return treatment;
    }
    
    @Override
    public String toString()
    {
        return "("+ name +":"+ surname +":"+ Age +":"+  diagnosis +":"+ treatment +")";
    }

}