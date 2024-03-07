import java.util.Scanner;
class Solution {
    public static int myAtoi(String s) {
        s = s.trim();

        if(s.isEmpty())
        {
            return 0;
        }

        int sign = 1;
        int i = 0;
        int result = 0;
        int len = s.length();

        if (s.charAt(0) == '-' || s.charAt(0) == '+'){
            sign = s.charAt(0) == '-' ? -1 : 1;
            i++;
        }

        while(i<len && Character.isDigit(s.charAt(i)))
        {
            int digit = s.charAt(i)-'0';

            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && digit > 7))
            {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result *10+digit;
            i++;
        }
        return sign * result;
    }

    public  static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string:");
        String input = scanner.nextLine();
        scanner.close();

        int result = myAtoi(input);
        System.out.println("Converted integer:" + result);
    }
}