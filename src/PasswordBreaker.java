import java.util.*;
import java.util.Scanner;

class PasswordBreaker
{
    public static void main ( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        //enter a password
        // write method that brute force checks for match
        // time how long it takes
        //
        // different methods - lowercase only, lowercase+uppercase, all ASCII

        System.out.print("Enter 4 character password - only lowercase\t");
        String password = scanner.nextLine();

        long started = new Date().getTime();
        checkPassword(password);
        long finished = new Date().getTime();
        long time = started-finished;
        System.out.println("It took " + time + " milliseconds to find your password");


    }

    public static void checkPassword(String p)
    {

    }

    public static char generateRandomChar()
    {
        return 'c';
    }

    public static String generateRandomPassword(int l)
    {
        return "c";
    }


}
