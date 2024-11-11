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

                // Creating a PolicyHolder object with the read data
                PolicyHolder policyHolder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);
                
                // Creating and adding the Policy object to the list
                Policy policy = new Policy(policyNumber, providerName, policyHolder);
                policies.add(policy);
            }
            inputFile.close();

            // Counters for smokers and non-smokers
            int smokerCount = 0, nonSmokerCount = 0;

            // Displaying the details of each policy in the required format
            for (Policy p : policies) {
                System.out.println("Policy Number: " + p.getPolicyNumber());
                System.out.println("Provider Name: " + p.getProviderName());
                System.out.println("Policyholder's First Name: " + p.getPolicyHolder().getFirstName());
                System.out.println("Policyholder's Last Name: " + p.getPolicyHolder().getLastName());
                System.out.println("Policyholder's Age: " + p.getPolicyHolder().getAge());
                System.out.println("Policyholder's Smoking Status (Y/N): " + p.getPolicyHolder().getSmokingStatus());
                System.out.printf("Policyholder's Height: %.1f inches\n", p.getPolicyHolder().getHeight());
                System.out.printf("Policyholder's Weight: %.1f pounds\n", p.getPolicyHolder().getWeight());
                System.out.printf("Policyholder's BMI: %.2f\n", p.getPolicyHolder().getBMI());
                System.out.printf("Policy Price: $%.2f\n", p.getPrice());
                System.out.println();
                
                // Counting smokers and non-smokers
                if (p.getPolicyHolder().getSmokingStatus().equalsIgnoreCase("smoker")) {
                    smokerCount++;
                } else {
                    nonSmokerCount++;
                }
            }

            // Displaying the total count of policies created
            System.out.println("There were " + policies.size() + " Policy objects created.");
            // Display the counts of smokers and non-smokers
            System.out.println("The number of policies with a smoker is: " + smokerCount);
            System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);

        } catch (IOException ex) {
            // Handling any errors related to file input
            System.out.println("Error reading the file: " + ex.getMessage());
        }
    }
}
