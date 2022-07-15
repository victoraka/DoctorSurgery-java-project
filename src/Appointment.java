/**Class used to book appointment from clients 
 *CN5004 Coursework
 * @author Victor
 */
public class Appointment 
{
    private double time;
    private String date;
    private String doctor;
    private PatientList patient;
    public static final int MAX =12;
    
    /**constructor initialise the booking service and the date for the appointment
     * and set the patient details in the empty list
     * @param timeIn: time of the booking
     * @param dateIn: date of the booking
     * @param doctorIn: doctor preferred for the appointment 
     */
  public Appointment(double timeIn, String dateIn, String doctorIn )
  {
      time=timeIn;
      date=dateIn;
      doctor=doctorIn;
  }

    Appointment(String nameEntered, int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
  /**Records a patient for the appointment
   * 
   * @param patientIn: 
   */
  public void makeAppointment(Patient patientIn)
  {
      patient.addPatient(patientIn);   //method to call the patientList    
  }
  
  /** method to read the time of the appointment
   *@returns the time 
   */
  public double getTime()
  {
      return time;
  }
  
   /** method to read the date of the appointment
   *@returns the date 
   */
  public String getDate()
  {
      return date;
  }
  
   /** method to read the doctor chosen for the appointment
   *@returns the doctor surname 
   */
  public String getDoctor()
  {
      return doctor;
  }
  @Override
    public String toString()
    {
        return "("+ time +":"+ date +":"+ doctor +")";
    }

    String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}
