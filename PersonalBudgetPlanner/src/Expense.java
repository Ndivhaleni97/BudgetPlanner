public abstract class Expense {

protected double amount;

public Expense(double amount){
this.amount = amount;
}
    public double getAmount(){
    return amount;
}
    public abstract String getDescription();
    
}
