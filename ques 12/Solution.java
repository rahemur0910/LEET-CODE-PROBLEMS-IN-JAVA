import java.util.Scanner;
class Solution {
    public static String intToRoman(int num) {
        int[] values = 
        {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };

        String[] sysmbols =
        {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };

        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman.append(sysmbols[i]);
                num -= values[i];
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();
        scanner.close();
        
        if (num <= 0 || num > 3999) {
            System.out.println("Input should be between 1 and 3999.");
            return;
        }
        
        String romanNumeral = intToRoman(num);
        System.out.println("Roman numeral: " + romanNumeral);
    }
}
