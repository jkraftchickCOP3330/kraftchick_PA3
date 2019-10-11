import java.security.SecureRandom;
import java.util.Scanner;

public class Main
{
    private static SecureRandom random = new SecureRandom();
    private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args)
	{
		boolean running = true;
		while (running)
		{
			double score = 0;
			for (int i = 0; i < 10; i++)
			{
				score += (AskQuestion() ? 1 : 0);
			}
			score /= 10;

			System.out.println((score < .75) ?
					"Please ask your teacher for extra help." :
					"Congratulations, you are ready to go to the next level!");
			System.out.println("Restarting");
		}

	}

	private static boolean AskQuestion()
    {
        int num1 = random.nextInt(10);
        int num2 = random.nextInt(10);
        int result = num1 * num2;
        double userInput = -1;

		System.out.print("How much is " + num1 + " times " + num2 + "? ");
		userInput = scan.nextInt();

		return ((userInput == result) ? Correct() : Wrong());
    }

    private static boolean Correct()
    {
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

        return true;
    }

    private static boolean Wrong()
    {
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

        return false;
    }
}
