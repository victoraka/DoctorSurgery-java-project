import java.util.ArrayList;

/** Collection of class to hold a list of patient object
 *CN5004 Coursework
 * @author Victor
 */
public class PatientList 
{
    
   //attribiutes
   private ArrayList<Patient> pList;
   public final int MAX;

/**Constructor initialise the empty patient list and set the maximum list six 
 * @return maxIn: The maximum number of patients in the list
 */
   public PatientList(int maxIn)
   {
       
     pList = new ArrayList<>();
     MAX = maxIn;
   }   
 
 /**Check if the list is full
  * @return Returns the total number of patients currently in the list 
  */
  public  boolean isFull()
  {
      return pList.size()==MAX;
  }
  
  /**Gets the total number of patients 
   * @return returns the total number of patients currently in the list 
   */
  public int getTotal()
  {
      return pList.size();
  }
  
  /**Add new patient to the end of the list
  * @param pIn the patient to add
  * @return pIn: The patient to add
  */
  public boolean addPatient(Patient pIn)
  {
      if(!isFull())
      {
          pList.add(pIn);
          return true;
      }
      else
      {
          return false;
      }
  }
  
  /**Read the patient at the given position in the list
   * @param  positionIn: the logical position of the patient in the list 
   * @return returns the patient at the given logical position in the list or null if no patient found 
   */
  public Patient getPatient(int positionIn)
  {
      //check for valid logical position 
      if (positionIn <1 || positionIn > getTotal())
      {
          //no object found at given position 
          return null;
      } 
      else
      {
          //take one off logical position to get ArrayList position 
          return pList.get(positionIn -1);
      }
  
  }
  
  @Override
  public String toString()
  {
      return pList.toString();
  }
  
    public ArrayList<Patient> getList()
  {
      return pList;
  }
    
}



 