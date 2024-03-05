import java.util.Scanner;

class Solution 
{
    public String convert(String s, int numRows) 
    {
        if (numRows == 1) 
        {
            return s; // If the number of rows is one then just return
        }
        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) 
        {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        boolean goingDown = false; // This variable helps in determining whether we are

        for (char c : s.toCharArray()) 
        {
            rows[row].append(c);
            if (row == 0 || row == numRows - 1) 
            {
                goingDown = !goingDown;
            }
            row += goingDown ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder rowStr : rows)
        {
            result.append(rowStr);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter The String: ");
        String s = scanner.nextLine();
        System.out.print("Number Of Rows: ");
        int numRows = scanner.nextInt();

        Solution solution = new Solution();
        String result = solution.convert(s, numRows);
        System.out.println("\nResult:\n" + result);
        scanner.close();
    }
}