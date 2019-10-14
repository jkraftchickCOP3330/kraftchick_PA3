import java.security.SecureRandom;
import java.util.Scanner;

public class Main
{
    private static SecureRandom random = new SecureRandom();
    private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args)
	{
		int problemLevel = 1;
		int problemType;
		while (problemLevel != 0)
		{
			problemLevel = problemLevel();
			if (problemLevel == 0)
			{
				break;
			}
			problemType = problemType();

			double score = 0;
			for (int i = 0; i < 10; i++)
			{
				score += (AskQuestion(problemLevel, problemType) ? 1 : 0);
			}
			score /= 10;

			System.out.printf("Your accuracy was %.2f%%%n", score);
			System.out.println((score < .75) ?
					"Please ask your teacher for extra help." :
					"Congratulations, you are ready to go to the next level!");
			System.out.println("Restarting");
		}

	}

	private static boolean AskQuestion(int level, int type)
	{
        int num1 = random.nextInt((int)Math.pow(10, level));
        int num2 = random.nextInt((int)Math.pow(10, level));
        double result = -1;
        double userInput = -1;

        if (type == 5)
		{
			type = random.nextInt(3) + 1;
		}

        if (type == 1)
		{
			result = num1 + num2;
			System.out.print("How much is " + num1 + " plus " + num2 + "? ");
		}
        else if (type == 2)
		{
			result = num1 - num2;
			System.out.print("How much is " + num1 + " minus " + num2 + "? ");
		}
		else if (type == 3)
		{
			result = num1 * num2;
			System.out.print("How much is " + num1 + " times " + num2 + "? ");
		}
		else if (type == 4)
		{
			result = (double)num1 / (double)num2;
			System.out.print("How much is " + num1 + " divide " + num2 + "? (2 decimal precision) ");
		}

		userInput = scan.nextDouble();

		return ((equals(userInput, result)) ? Correct() : Wrong());
    }

    // Returns true if a and b are within the threshold of being equal
    private static boolean equals(double a, double b)
	{
		return Math.abs(a - b) < 0.01; // 0.01 is threshold value
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

    private static boolean levelValid(int level)
	{
		return (level >= 0 && level <= 4);
	}

	private static boolean typeValid(int problem)
	{
		return (problem >= 1 && problem <= 5);
	}

	private  static int problemLevel()
	{
		int level;
		System.out.print("Please select a level (1-4, 0 to quit): ");
		do
		{
			level = scan.nextInt();
			if (!levelValid(level))
			{
				System.out.print("Please pick a valid level (1-4, 0 to quit): ");
			}
		}
		while (!levelValid(level));

		return level;
	}

	private static int problemType()
	{
		int type = 0;
		System.out.print("Please pick your problem type (1 add, 2 sub, 3 mult, 4 div, 5 rand): ");
		do
		{
			type = scan.nextInt();
			if (!typeValid(type))
			{
				System.out.print("Please pick a valid problem type (1-5): ");
			}
		}
		while (!typeValid(type));

		return type;
	}
}