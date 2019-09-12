import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Scanner;

class Main
{
    public static void main(String[] args) throws IOException
    {
        new PasswordBreaker();
    }
}

class PasswordBreaker
{
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";

    PasswordBreaker() throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Long> times = new ArrayList<>();
        long totalTime = 0;
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "1234567890";
        String symbols = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

        System.out.print("Enter password - only lowercase\t");
        String password = scanner.nextLine();

        System.out.println("Is password case sensitive? - y/n\t");
        String response = scanner.nextLine();

        List<String> passwords = Files.readAllLines(Paths.get("xato-net-10-million-passwords-1000000.txt"));
        for (String p : passwords)
        {
            if (p.equals(password))
            {
                System.out.print("\nYour password is basic and boring and insecure . . .\n        Just like you.\n\n");
                System.exit(1);
            }
        }
        if (response.equals("y"))
        { alphabet = alphabet + upperAlphabet; }
        else
        { password = password.toLowerCase(); }

        for (int i = 0; i < 10; i++)
        {
            if (password.contains(Integer.toString(i)))
            {
                alphabet = alphabet + digits;
                break;
            }
        }

        for (int i = 0; i < 32; i++)
        {
            if (password.contains(symbols.substring(i, i+1)))
            {
                alphabet = alphabet + symbols;
                break;
            }
        }

        System.out.println(alphabet);

        for (int i = 0; i < 10; i++)
        {
            long started = new Date().getTime();
            checkPassword(password);
            long finished = new Date().getTime();
            times.add(finished - started);
            System.out.println("It took " + times.get(times.size() - 1) + " milliseconds to find your password");
        }
        for (int i = 0; i < 10; i++)
        {
            totalTime += times.get(i);
        }
        System.out.println("It took " + totalTime + " milliseconds to break your password 10 times.");
        System.out.println("Average time was " + totalTime / 10 + " milliseconds.");
    }

    private void checkPassword(String p)
    {
        while (true)
        {
            String guess = generateRandomPassword(p.length());
            if (guess.equals(p))
            {
                break;
            }
        }
    }

    private char generateRandomChar()
    {
        int r = new Random().nextInt(alphabet.length());
        return alphabet.charAt(r);
    }

    private String generateRandomPassword(int l)
    {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < l; i++)
        {
            b.append(generateRandomChar());
        }
        return b.toString();
    }
}
