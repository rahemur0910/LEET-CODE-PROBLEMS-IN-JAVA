import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> romanValues = new HashMap<>();
        romanValues.put('I',1);
        romanValues.put('V',5);
        romanValues.put('X',10);
        romanValues.put('L',50);
        romanValues.put('C',100);
        romanValues.put('D',500);
        romanValues.put('M',1000);

        int total = 0;
        int prevValue = 0 ;

        for(int i = 0; i < s.length();i++)
        {
            char c = s.charAt(i);
            int value = romanValues.get(c);

            if (value > prevValue) 
            {
                total += value - 2 * prevValue;
            }
            else 
            {
                total += value;
            }
            prevValue = value;
        }
        return total;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a Roman numeral: ");
        String romanNumeral = scanner.nextLine();
        
        scanner.close();
        
        int result = solution.romanToInt(romanNumeral);
        System.out.println("Integer equivalent: " + result);
    }
}