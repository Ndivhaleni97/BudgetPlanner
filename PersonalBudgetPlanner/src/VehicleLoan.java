public class VehicleLoan extends Expense {
    
    protected double LoanAmount;
    protected double interestRate; // Monthly interest rate
    protected double purchasePrice;
    protected double deposit;
    protected int months;

    public  VehicleLoan(double purchasePrice,double deposit,double interestRate,int months) {
    super(calculateMonthlyPayment(purchasePrice, deposit, interestRate, months));
        this.purchasePrice = purchasePrice;
        this.deposit = deposit;
        this.interestRate = interestRate / 100 / 12;
        this.months = months;
        this.LoanAmount = purchasePrice - deposit;
    }
        protected static  double calculateMonthlyPayment(double purchasePrice, double deposit, double interestRate, int months) {
        double loanAmount = purchasePrice - deposit;
        double monthlyRate = (interestRate/ 100) / 12;
        return (loanAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
    }
        @Override
        public String getDescription() {
        return "VehicleLoan Monthly Repayment";
    }

    public double calculateMonthlyPayment() {
    if(LoanAmount<= 0) return 0;
    return (LoanAmount * interestRate) / (1 - Math.pow(1 + interestRate, -months));
    
    }
      // Getter to return the loan amount
      public double getLoanAmount() {
      return LoanAmount;
    }
    // Getter to return the interest rate as a percentage 
    public double getInterestRate() {
    return interestRate * 12 * 100;
    }
    // Method to calculate the loan term in years
    public int getLoanTermInYears() {
    return months / 12;
    }
}
