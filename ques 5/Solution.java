import java.util.Scanner;

class Solution {
    public String longestPalindrome(String s) 
    {
        if(s == null || s.length() ==  0)
        {
            return "";
        }
         int n = s.length();
         boolean[][] dp = new boolean[n][n];
         int start = 0 , maxLength = 1;
         for(int i=0 ;i<n; i++)
         {
             dp[i][i] = true; // a single char is palindrome
         }
         
         for(int i=0 ;i<n-1; i++ )
         {
            if(s.charAt(i)==s.charAt(i+1))
            {
                dp[i][i + 1]=true;
                start = i;
                maxLength = 2;
            }
         }

         for(int length=3; length<=n; length++ )
         {
            for(int i=0;i<=n-length;i++)
            {
                int j = i + length -1;
                if(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1])
                {
                    dp[i][j] = true ; 
                    start = i;
                    maxLength = length;
                }
            }
         }
         return s.substring(start, start+maxLength);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Enter the string");
        String input = scanner.nextLine().trim();

        Solution solution = new Solution();
        String longestPalindrome = solution.longestPalindrome(input);
        //System.out.println("The Longest Palindromic Substring is : " + longestPalindrome);
        System.out.println(longestPalindrome);
        scanner.close();
    }
}