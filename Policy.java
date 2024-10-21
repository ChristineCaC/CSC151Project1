
// The Policy class models an insurance policy for one person.
 
public class Policy {
    private String policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    
// Default constructor that initializes all fields to default values.
     
    public Policy() {
        policyNumber = "";
        providerName = "";
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "";
        height = 0;
        weight = 0;
    }

    /**
      Constructor that initializes a Policy with specified values.
      
      @param pNumber The policy number.
      @param pName The provider name.
      @param fName The policyholder's first name.
      @param lName The policyholder's last name.
      @param a The policyholder's age.
      @param sStatus The policyholder's smoking status (smoker/non-smoker).
      @param h The policyholder's height in inches.
      @param w The policyholder's weight in pounds.
     */
    public Policy(String pNumber, String pName, String fName, String lName, int a, String sStatus, double h, double w) {
        policyNumber = pNumber;
        providerName = pName;
        firstName = fName;
        lastName = lName;
        age = a;
        smokingStatus = sStatus;
        height = h;
        weight = w;
    }

    // Setters with @param tag
    public void setPolicyNumber(String pNumber) { policyNumber = pNumber; }
    public void setProviderName(String pName) { providerName = pName; }
    public void setFirstName(String fName) { firstName = fName; }
    public void setLastName(String lName) { lastName = lName; }
    public void setAge(int a) { age = a; }
    public void setSmokingStatus(String sStatus) { smokingStatus = sStatus; }
    public void setHeight(double h) { height = h; }
    public void setWeight(double w) { weight = w; }

    // Getters with @return tag
    public String getPolicyNumber() { return policyNumber; }
    public String getProviderName() { return providerName; }
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
        final double CONVFACTOR = 703;
        return (weight * CONVFACTOR) / (height * height);
    }

    /**
      Calculates and returns the price of the policy.
      
      @return The calculated price of the policy.
     */
    public double getPrice() {
        final double BASE_PRICE = 600;
        final double ADDITIONAL_FEE_AGE = 75;
        final double ADDITIONAL_FEE_SMOKING = 100;
        final double ADDITIONAL_FEE_PER_BMI = 20;
        final int AGE_THRESHOLD = 50;
        final int BMI_THRESHOLD = 35;

        double price = BASE_PRICE;
        if (age > AGE_THRESHOLD) price += ADDITIONAL_FEE_AGE;
        if (smokingStatus.equalsIgnoreCase("smoker")) price += ADDITIONAL_FEE_SMOKING;
        if (getBMI() > BMI_THRESHOLD) price += ((getBMI() - BMI_THRESHOLD) * ADDITIONAL_FEE_PER_BMI);

        return price;
    }
}
