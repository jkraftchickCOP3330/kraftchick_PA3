public class Application
{
    public static void main(String[] args)
    {
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        SavingsAccount.modifyInterestRate(0.04);

        System.out.printf("Initial amount%n");
        System.out.printf("Saver 1 %8.2f - Saver 2 %8.2f%n%n", saver1.getSavingsBalance(), saver2.getSavingsBalance());

        for (int i = 0; i < 12; i++)
        {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();

            System.out.printf("Month %d%n", i+1);
            System.out.printf("Saver 1 %8.2f - Saver 2 %8.2f%n%n", saver1.getSavingsBalance(), saver2.getSavingsBalance());
        }

        SavingsAccount.modifyInterestRate(0.05);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.printf("Month 13 - increased interest rate%n", SavingsAccount.getAnnualInterestRate());
        System.out.printf("Saver 1 %8.2f - Saver 2 %8.2f%n%n", saver1.getSavingsBalance(), saver2.getSavingsBalance());
    }
}