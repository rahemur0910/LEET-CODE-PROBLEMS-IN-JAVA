import java.util.Scanner;

class Solution {
    public static boolean isPalindrome(int x) {
        if(x<0||(x%10==0 &&x!=0)){ 
            return false; 
        }

        int reversed = 0;
        while(x>reversed)
        {
            reversed = reversed * 10 + (x % 10);
            x /= 10;
        }
        return x==reversed || x == reversed / 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer:");
        int num = scanner.nextInt();
        scanner.close();

        System.out.println(num+"is a palindrome" + isPalindrome(num));
    }
}