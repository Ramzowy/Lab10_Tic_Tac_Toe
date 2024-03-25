import java.util.Scanner;

public class SafeInput {
     Scanner in = new Scanner(System.in);
    public static String getNonZeroLenString(Scanner in, String prompt)
    {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = in.nextLine();
        }while(retString.length() == 0);

        return retString;

    }

    public static int getInt(Scanner in, String prompt)
    {
        int retInt;
        while (true)
        {
         System.out.print("\n" + prompt + ":");
            if (in.hasNextInt())
            {
                retInt = in.nextInt();
                in.nextLine();
                break;
            }
            else
            {
                System.out.println("Please enter a valid input!!");
                in.nextLine();
            }
        }
        return retInt;
    }

    public static double getDouble(Scanner in, String prompt)
    {
        double retDouble;
        while (true)
        {
            System.out.print("\n" + prompt + ":");
            if (in.hasNextDouble())
            {
                retDouble = in.nextDouble();
                in.nextLine();
                break;
            } else
            {
                System.out.println("Please enter a valid input!!");
                in.nextLine();
            }
        }
        return retDouble;
    }

    public static int getRangedInt(Scanner in, String prompt, int min, int max )
    {
        int y;
        y = max;
        int x;
        x = min;
        int retInt;

       while (true)
       {
           System.out.print(prompt);
           if (in.hasNextInt())
           {
               retInt = in.nextInt();
               if (retInt >= x && retInt <= y)
               {
                   in.nextLine();
                   break;
               } else
               {
                   System.out.println("Please make sure your integer is within range!!");
                   in.nextLine();
               }
       }
            else
            {
              System.out.println("Please enter a valid input!");
              in.nextLine();
            }
        }

        return retInt;

    }

    public static double getRangedDouble(Scanner in, String prompt, double min, double max )
    {
        double y;
        y = max;
        double x;
        x = min;
        double retDouble;

        while (true)
        {
            System.out.print(prompt);
            if (in.hasNextDouble())
            {
                retDouble = in.nextDouble();
                if (retDouble >= x && retDouble <= y)
                {
                    in.nextLine();
                    break;
                } else
                {
                    System.out.println("Please make sure your double is within range!!");
                    in.nextLine();
                }
            }
            else
            {
                System.out.println("Please enter a valid input!");
                in.nextLine();
            }
        }

        return retDouble;
    }

    public static boolean getYNConfirm(Scanner in, String prompt)
    {
        String str ="";
        boolean done = false;
        while (true)
        {
           System.out.print(prompt);
             str = in.nextLine();
            if (str.equalsIgnoreCase("Y") || str.equalsIgnoreCase("Yes"))
            {
                done = true;
                break;
            }
            else if (str.equalsIgnoreCase("N") || str.equalsIgnoreCase("No"))
            {
                break;
            }
            else
            {
                System.out.println("Please enter a valid input!!");
            }
        }
        return done;
    }

    public static String getRegExString(Scanner scanner, String regexPattern, String prompt)
    {
        String input;
        while (true)
        {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.matches(regexPattern))
            {
                return input;
            }
            else
            {
                System.out.println("Invalid input. Please follow the specified pattern.");
            }
        }
    }





    public static void main (String[] args){



    }
}
