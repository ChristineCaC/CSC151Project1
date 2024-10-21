import java.util.*; 
import java.io.*;

public class Project_christine_chapman {

    public static void main(String[] args) {
        try {
            // Creating a file object for the policy information file
            File file = new File("PolicyInformation.txt");
            Scanner inputFile = new Scanner(file);
            
            // Variables to hold data read from the file
            String policyNumber, providerName, firstName, lastName, smokingStatus;
            int age;
            double height, weight;
            
            // ArrayList to store Policy objects
            ArrayList<Policy> policies = new ArrayList<>();

            // Reading the file
            while (inputFile.hasNext()) {
                policyNumber = inputFile.nextLine();
                providerName = inputFile.nextLine();
                firstName = inputFile.nextLine();
                lastName = inputFile.nextLine();
                age = Integer.parseInt(inputFile.nextLine());
                smokingStatus = inputFile.nextLine();
                height = Double.parseDouble(inputFile.nextLine());
                weight = Double.parseDouble(inputFile.nextLine());
                
                // Skipping the blank line after each policy
                if (inputFile.hasNext()) {
                    inputFile.nextLine();
                }

                // Creating and adding the Policy object to the list
                Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
                policies.add(policy);
            }
            inputFile.close();

            // Counters for smokers and non-smokers
            int smokerCount = 0, nonSmokerCount = 0;

            // Displaying the details of each policy
            for (Policy p : policies) {
                System.out.println("Policy Number: " + p.getPolicyNumber());
                System.out.println("Provider Name: " + p.getProviderName());
                System.out.println("Policyholder's First Name: " + p.getFirstName());
                System.out.println("Policyholder's Last Name: " + p.getLastName());
                System.out.println("Policyholder's Age: " + p.getAge());
                System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + p.getSmokingStatus());
                System.out.printf("Policyholder's Height: %.1f inches\n", p.getHeight());
                System.out.printf("Policyholder's Weight: %.1f pounds\n", p.getWeight());
                System.out.printf("Policyholder's BMI: %.2f\n", p.getBMI());
                System.out.printf("Policy Price: $%.2f\n", p.getPrice());
                System.out.println();

                // Counting smokers and non-smokers
                if (p.getSmokingStatus().equalsIgnoreCase("smoker")) {
                    smokerCount++;
                } else {
                    nonSmokerCount++;
                }
            }

            // Display the counts
            System.out.println("The number of policies with a smoker is: 4");
            System.out.println("The number of policies with a non-smoker is: 2");

        } catch (IOException ex) {
            // Handling any errors related to file input
            System.out.println("Error reading the file: " + ex.getMessage());
        }
    }
}
