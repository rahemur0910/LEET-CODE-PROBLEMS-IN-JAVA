import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public static List<String> letterCombinations(String digits) 
    {
        List<String> combinations = new ArrayList<>();

        if(digits == null || digits.length() == 0)
        {
            return combinations;
        }

        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        backtack(combinations, digitToLetters, digits, "", 0);
        
        return combinations;
    }

    private static void backtack(List<String> combinations, Map<Character,String> digitToLetters,String digits, String current, int index)
    {
        if(index == digits.length())
        {
            combinations.add(current);
            return;
        }

        char digit =digits.charAt(index);
        String letters = digitToLetters.get(digit);
        for (char letter : letters.toCharArray())
        {
            backtack(combinations, digitToLetters, digits, current+letter, index+1);
        } 
    }
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string of digits (2-9): ");
        String digits = scanner.nextLine();
        scanner.close();

        List<String> result = letterCombinations(digits);
        System.out.println("Letter Combinations: " + result);
    }
}