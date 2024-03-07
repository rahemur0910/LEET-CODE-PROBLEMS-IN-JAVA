import java.util.Scanner;
class Solution {
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for(int j =1; j<=n;j++)
        {
            if(p.charAt(j-1) == '*')
            {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*')
                {
                    dp[i][j] = dp[i][j-2] || (p.charAt(j-2) == '.'|| p.charAt(j-2) == s.charAt(i-1)) && dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the input string s: ");
        String s = scanner.nextLine();

        System.out.print("Enter the pattern string p: ");
        String p = scanner.nextLine();

        scanner.close();

        System.out.println("Matching result: " + isMatch(s, p));
    }
}   