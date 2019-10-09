import java.security.SecureRandom;
import java.util.Scanner;

public class Main {

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
                System.out.println("Correct!");
                correct = true;
                break;
            }
            else
            {
                System.out.println("No. Please try again.");
            }
        }
    }
}
