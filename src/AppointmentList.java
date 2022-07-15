import java.util.ArrayList;
import java.io.Serializable;

/**Collection of class to hold a list of appointment object 
 *CN5004 Coursework
 * @author Victor
 */
public class AppointmentList 
{
    private ArrayList<Appointment> aList;
    public final int MAX;
    
    /**Constructor initialise the empty patient list and set the maximum list six
     * @return maxIn: The maximum number of the appointment in the list
     */
    public AppointmentList(int maxIn)
    {
        aList = new ArrayList<>();
        MAX = maxIn;   
    }
    
    /**Add a new appointment to the list 
     * @param aIn: the appointment to add
     * @return returns true if appointment was added successfully or false otherwise
     */
    public boolean addAppointment(Appointment aIn)
    {
        if(!isFull())
        {
            aList.add(aIn);
            return true;
        }
        else
        {
            return false;
        } 
    }
    
    /** Remove the appointment in the given time 
     * @param timeIn: the time of the appointment that has to be cancelled
     * @return Returns true is the appointment has been successfully removed or false otherwise
     */
    public boolean removeAppointment(double timeIn)
        {
            Appointment findA = search(timeIn); //call the search method
            if(findA != null) //check if the appointment is at the given position 
            {
                aList.remove(findA);
                        return true;
            }
            else
            {
                return false; 
            }
        }
    
    /**Searches for the appointment in a given time
     * @return returns current appointments
     */
    public Appointment search(double timeIn)
    {
        for(Appointment currentAppointment: aList)
        {
            //find appointment with a given time
            if(currentAppointment.getTime()==timeIn)
            {
                return currentAppointment;
            }    
        }
        return null; // no appointment found at the given time 
    }
    
    /** Read the appointment at a given position in the list
     * :return returns the position of a patient according to the index
     */
    public Appointment getAppointment(int positionIn)
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
          return aList.get(positionIn -1);
      }
  
    }
    
    /**Check is if the list is full or not
     * @return returns if is empty 
     */
    public boolean isEmpty()
    {
        return aList.isEmpty();
    }
    
    /**Check if the list is full
     *@return returns the total number of the appointment in the list 
     */
    public boolean isFull()
    {
        return aList.size()==MAX;
    }
    
    /**Get the total number of appointments
     * @return returns total number of patients in the list
     */
    public int getTotal()
    {
        return aList.size();  
    }
    
    @Override
    public String toString()
    {
        return aList.toString();
    }


  public ArrayList<Appointment> getList()
  {
      return aList;
  }
    
  
    
}


