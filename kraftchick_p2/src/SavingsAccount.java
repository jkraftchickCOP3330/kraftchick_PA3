public class SavingsAccount
{
    private static double annualInterestRate;
    private double savingsBalance = 0;

    public void calculateMonthlyInterest()
    {
        savingsBalance += savingsBalance * (annualInterestRate / 12);
    }

    public static void modifyInterestRate(double newInterestRate)
    {
        annualInterestRate = newInterestRate;
    }

    public double getSavingsBalance()
    {
        return savingsBalance;
    }

    public static double getAnnualInterestRate()
	{
		return annualInterestRate;
	}

    SavingsAccount(double savingsBalance)
    {
        this.savingsBalance = savingsBalance;
    }
}
