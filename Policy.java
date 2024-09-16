public class Policy 
{
    
    // Fields for the policy details and policyholder information
    private int policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String smokingStatus;
    private double policyholderHeight; // in inches
    private double policyholderWeight; // in pounds
    
    // Constants for policy pricing
    private static final double BASE_FEE = 600.0;
    private static final double AGE_FEE_THRESHOLD = 50;
    private static final double AGE_FEE = 75.0;
    private static final double SMOKER_FEE = 100.0;
    private static final double BMI_FEE_THRESHOLD = 35;
    private static final double BMI_FEE_MULTIPLIER = 20.0;

    // No-arg constructor: Initializes fields to default values
    public Policy() 
    {
        // Calls the parameterized constructor with default values
        this(0, "Unknown", "Unknown", "Unknown", 0, "non-smoker", 0.0, 0.0);
    }

    // Parameterized constructor: Initializes all fields
    public Policy(int policyNumber, String providerName, String firstName, String lastName, 
                  int age, String smokingStatus, double height, double weight) 
    {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyholderFirstName = firstName;
        this.policyholderLastName = lastName;
        this.policyholderAge = age;
        this.smokingStatus = smokingStatus;
        this.policyholderHeight = height;
        this.policyholderWeight = weight;
    }

    // Getters and Setters for each field
    public int getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(int policyNumber) { this.policyNumber = policyNumber; }

    public String getProviderName() { return providerName; }
    public void setProviderName(String providerName) { this.providerName = providerName; }

    public String getPolicyholderFirstName() { return policyholderFirstName; }
    public void setPolicyholderFirstName(String firstName) { this.policyholderFirstName = firstName; }

    public String getPolicyholderLastName() { return policyholderLastName; }
    public void setPolicyholderLastName(String lastName) { this.policyholderLastName = lastName; }

    public int getPolicyholderAge() { return policyholderAge; }
    public void setPolicyholderAge(int age) { this.policyholderAge = age; }

    public String getSmokingStatus() { return smokingStatus; }
    public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }

    public double getPolicyholderHeight() { return policyholderHeight; }
    public void setPolicyholderHeight(double height) { this.policyholderHeight = height; }

    public double getPolicyholderWeight() { return policyholderWeight; }
    public void setPolicyholderWeight(double weight) { this.policyholderWeight = weight; }

    // Method to calculate BMI
    public double calculateBMI() 
    {
        // Avoid division by zero in case height is zero
        return policyholderHeight == 0 ? 0 : (policyholderWeight * 703) / (policyholderHeight * policyholderHeight);
    }

    // Method to calculate the total policy price based on criteria
    public double calculatePolicyPrice() 
    {
        double price = BASE_FEE;

        // Add an extra $75 if the policyholder is over 50
        if (policyholderAge > AGE_FEE_THRESHOLD) price += AGE_FEE;
        
        // Add an extra $100 if the policyholder is a smoker
        if ("smoker".equalsIgnoreCase(smokingStatus)) price += SMOKER_FEE;

        // Add an additional fee if the BMI is greater than 35
        double bmi = calculateBMI();
        if (bmi > BMI_FEE_THRESHOLD) price += (bmi - BMI_FEE_THRESHOLD) * BMI_FEE_MULTIPLIER;

        return price;
    }
}
