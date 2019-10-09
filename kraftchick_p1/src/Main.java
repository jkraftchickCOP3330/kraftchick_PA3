import java.security.SecureRandom;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		SecureRandom random = new SecureRandom();
		Scanner scan = new Scanner(System.in);

		int num1, num2, product, userInput;
		boolean correct = false;


		num1 = random.nextInt(10);
		num2 = random.nextInt(10);
		product = num1 * num2;
		userInput = -1;

		while (!correct)
		{
			System.out.print("How much is " + num1 + " times " + num2 + "? ");
			userInput = scan.nextInt();

			if (userInput == product)
			{
				Correct();
				correct = true;
				break;
			}
			else
			{
				Wrong();
			}
		}
	}

    private static void Correct()
    {
        SecureRandom random = new SecureRandom();
        switch (random.nextInt(4))
        {
            case 0:
                System.out.println("Very good!");
                break;
            case 1:
                System.out.println("Excellent!");
                break;
            case 2:
                System.out.println("Nice work!");
                break;
            case 3:
                System.out.println("Keep up the good work!");
                break;
        }
    }

    private static void Wrong()
    {
        SecureRandom random = new SecureRandom();
        switch (random.nextInt(4))
        {
            case 0:
                System.out.println("No. Please try again.");
                break;
            case 1:
                System.out.println("Wrong. Try once more.");
                break;
            case 2:
                System.out.println("Don’t give up!");
                break;
            case 3:
                System.out.println("No. Keep trying.");
                break;
        }
    }
}
