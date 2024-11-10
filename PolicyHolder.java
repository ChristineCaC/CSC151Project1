// The PolicyHolder class represents a person associated with an insurance policy.
public class PolicyHolder {
    private String firstName; 
    private String lastName;  
    private int age;          
    private String smokingStatus; 
    private double height;    
    private double weight;    

    // Default constructor that initializes all fields to default values.
    public PolicyHolder() {
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "";
        height = 0;
        weight = 0;
    }

    /**
      Constructor that initializes a PolicyHolder with specified values.
      
      @param fName The policyholder's first name.
      @param lName The policyholder's last name.
      @param a The policyholder's age.
      @param sStatus The policyholder's smoking status (smoker/non-smoker).
      @param h The policyholder's height in inches.
      @param w The policyholder's weight in pounds.
    */
     public PolicyHolder(String fName, String lName, int a, String sStatus, double h, double w) {
         firstName = fName;
         lastName = lName;
         age = a;
         smokingStatus = sStatus;
         height = h;
         weight = w;
    }

    // Setters with @param tags
    public void setFirstName(String fName) { firstName = fName; }
    public void setLastName(String lName) { lastName = lName; }
    public void setAge(int a) { age = a; }
    public void setSmokingStatus(String sStatus) { smokingStatus = sStatus; }
    public void setHeight(double h) { height = h; }
    public void setWeight(double w) { weight = w; }

    // Getters with @return tags
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getSmokingStatus() { return smokingStatus; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }

    /**
      Calculates and returns the policyholder's BMI.
      
      @return The calculated BMI based on the policyholder's height and weight.
    */
     public double getBMI() {
         final double CONVFACTOR = 703; // Conversion factor for BMI calculation.
         return (weight * CONVFACTOR) / (height * height);
     }

    /**
      Returns a string representation of the PolicyHolder object.
  
      @return A string with the policyholder's first name, last name, age, smoking status, height, and weight.
    */
     @Override
     public String toString() {
         return "PolicyHolder [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + 
                ", smokingStatus=" + smokingStatus + ", height=" + height + " inches, weight=" + weight + " lbs]";
     }
}
