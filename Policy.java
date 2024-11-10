// The Policy class models an insurance policy for one person, which includes a policyholder.
public class Policy {
    private String policyNumber; 
    private String providerName; 
    private PolicyHolder policyHolder; 

    // Static field to track the number of Policy objects created
    private static int numberOfPolicies = 0;

    // Default constructor that initializes all fields to default values.
    public Policy() {
        policyNumber = "";
        providerName = "";
        policyHolder = new PolicyHolder(); // Initializes the PolicyHolder object.
        
        // Increment the static field every time a Policy object is created
        numberOfPolicies++;
    }

    /**
      Constructor that initializes a Policy with specified values.
      
      @param pNumber The policy number.
      @param pName The provider name.
      @param holder The policyholder associated with the policy.
    */
     public Policy(String pNumber, String pName, PolicyHolder holder) {
         policyNumber = pNumber;
         providerName = pName;
         policyHolder = holder;
        
         // Increment the static field every time a Policy object is created
         numberOfPolicies++;
     }

    // Setters with @param tags
    public void setPolicyNumber(String pNumber) { policyNumber = pNumber; }
    public void setProviderName(String pName) { providerName = pName; }
    public void setPolicyHolder(PolicyHolder holder) { policyHolder = holder; }

    // Getters with @return tags
    public String getPolicyNumber() { return policyNumber; }
    public String getProviderName() { return providerName; }
    public PolicyHolder getPolicyHolder() { return policyHolder; }

    // Getter for the number of Policy objects created
    public static int getNumberOfPolicies() {
        return numberOfPolicies;
    }

    /**
      Calculates and returns the price of the policy based on the policyholder's information.
      
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
         if (policyHolder.getAge() > AGE_THRESHOLD) price += ADDITIONAL_FEE_AGE;
         if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker")) price += ADDITIONAL_FEE_SMOKING;
         if (policyHolder.getBMI() > BMI_THRESHOLD) price += ((policyHolder.getBMI() - BMI_THRESHOLD) * ADDITIONAL_FEE_PER_BMI);

         return price;
     }

    /**
      Returns a string representation of the Policy object.
      
      @return A string with the policy number, provider name, and the policyholder's information.
    */
     @Override
     public String toString() {
         return "Policy [policyNumber=" + policyNumber + ", providerName=" + providerName + ", policyHolder=" + policyHolder.toString() + "]";
     }
}
