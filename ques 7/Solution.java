import java.util.Scanner;

class Solution {
    public int reverse(int x) {
        int reversed = 0;

        while(x != 0)
        {
            int digits = x %10;
            if(reversed > Integer.MAX_VALUE/10 || (reversed == Integer.MAX_VALUE / 10 && digits>7))
            {
                return 0;
            }

            if(reversed < Integer.MIN_VALUE/10 || (reversed == Integer.MIN_VALUE / 10 && digits< -8))
            {
                return 0;
            }
            reversed = reversed *10 +  digits;
            x /= 10;
        }
        return reversed;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a signed 32-bit integer: ");
        int x = scanner.nextInt();
        
        Solution solution = new Solution();
        int reversedInteger = solution.reverse(x);
        
        System.out.println("Reversed integer: " + reversedInteger);
        
        scanner.close();
    }
}