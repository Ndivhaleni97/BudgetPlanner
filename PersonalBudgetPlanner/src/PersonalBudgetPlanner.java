import java.util.Arrays;
import java.util.Scanner;

public class PersonalBudgetPlanner {

   
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        
    Scanner scanner;
    scanner = new Scanner(System.in);
     
     // User inputs
    System.out.println("Enter your gross monthly income(R): ");
    scanner.nextDouble();

    System.out.println("Enter estimated monthly tax deducted(R): ");
    scanner.nextDouble();
         
    double[] expenditures = new double[5];
    String[] expenseNames = {"Groceries", "Water and Lights", "Travel Costs", "Cell Phone and Telephone", "Other Expenses"};

     for (int i = 0; i < expenditures.length; i++) {
     System.out.println("Enter estimated monthly expenditures for " + expenseNames[i] + "(R): ");
     expenditures[i] = scanner.nextDouble();
           
     }
     double TotalExpenditures = 0.0;
     for(double expense : expenditures){
     TotalExpenditures += expense;
     }
     
    System.out.println("\nTotal estimated monthly expenditures: (R)" + TotalExpenditures);
     
     // Sort and display expenses in descending order
     Arrays.sort(expenditures); 

    // Sort the filled part of the array
    System.out.println("\nexpenditures in descending order:");
        boolean continueProgram = false;
    for (int i = expenditures.length - 1; i >= 0; i--) {
    System.out.printf("R%.2f%n", expenditures[i]);
     
    System.out.println("---------------------------------------");
    System.out.println("Choose an option: Would you like to   1. Rent    "+ "   2. Buy Property     3 Buy A Vehicle");
    int choice = scanner.nextInt();
        
        
    switch (choice) {
    case 1 -> {
    System.out.print("Enter monthly rental amount: (R) ");
    double rentalAmount = scanner.nextDouble();
    new Expense(rentalAmount) {
    @Override
    public double getAmount() {
    return rentalAmount;
        }
                    
            @Override
            public String getDescription() {
            return "Monthly Rent";
                    }
                };
            }
            case 2 -> {
                System.out.println("Enter purchase price of the property: (R) ");
                double purchasePrice = scanner.nextDouble();
                System.out.println("Enter total deposit: ");
                double deposit = scanner.nextDouble();
                System.out.println("Enter interest rate (percentage): ");
                double interestRate = scanner.nextDouble();
                System.out.println("Enter number of months to repay (240 to 360): ");
                int months = scanner.nextInt();
                if (months < 240 || months > 360) {
                    System.out.println("Invalid number of months. Please enter a value between 240 and 360.");
                    return;
                }  
                HomeLoan expenses = new HomeLoan(purchasePrice, deposit, interestRate, months);
                
                // Calculate the monthly payment
                double monthlyPayment;
                monthlyPayment = expenses.calculateMonthlyPayment();
                
                // Display results
                System.out.printf("Loan Amount: R%.2f%n", expenses.getLoanAmount());
                System.out.printf("Monthly Payment: R%.2f%n", monthlyPayment);
                System.out.printf("Interest Rate: %.2f%%%n", interestRate);
                
                double monthlyIncome;
                monthlyIncome = 0;
              if (monthlyPayment > 0.75 * monthlyIncome) {
              System.out.println("Warning: Your monthly payment exceeds 75% of your income.");
                    
                }
              
            }
            case 3 ->{
                // Vehicle Loan 
                System.out.println("Enter purchase price of the vehicle: (R) ");
                double purchasePrice = scanner.nextDouble();
                System.out.println("Enter total deposit: ");
                double deposit = scanner.nextDouble();
                System.out.println("Enter interest rate (percentage): ");
                double interestRate = scanner.nextDouble();
                System.out.println("Enter number of months to repay (12 to 60): ");
                int months = scanner.nextInt();

                if (months < 12 || months > 60) {
                    System.out.println("Invalid number of months. Please enter a value between 12 and 60.");
                    System.out.println("Warning: Your monthly payment exceeds 75% of your income.");
                    return;
       }
               // the VehicleLoan object
                VehicleLoan vehicleLoan = new VehicleLoan(purchasePrice, deposit, interestRate, months);
                
                // Calculate the monthly payment
                double monthlyPayment = vehicleLoan.calculateMonthlyPayment();

                // Display results
                System.out.printf("Loan Amount: R%.2f%n", vehicleLoan.getLoanAmount());
                System.out.printf("Monthly Payment: R%.2f%n", monthlyPayment);
                System.out.printf("Interest Rate: %.2f%%%n", interestRate);
            }
            default -> {
                System.out.println("Invalid choice.");
            }
        }
        System.out.println("Enter Your Monthly TotalIncome: (R)");
        double totalIncome = scanner.nextDouble();
        
        //Calculate available money
        double availableMoney = totalIncome - TotalExpenditures;
        
         //Display results
        System.out.println("Total estimated monthly expenditures: R" + TotalExpenditures);
        
        System.out.println("Total monthly income: R" + totalIncome);
        
        System.out.println("Available money after all deductions and expenses: R" + availableMoney);
       
        System.out.println("SpendWise");
    
    
        System.out.println("Do you want to continue? (yes/no): ");
        String userResponse = scanner.next().trim().toLowerCase();
        continueProgram = userResponse.equals("yes");
    }
    while (continueProgram);
    System.out.println("Thank You for using our App visit Again");
   }
}


              
    



