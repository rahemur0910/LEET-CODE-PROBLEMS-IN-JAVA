import java.util.Scanner;
class Solution {
    public static int maxArea(int[] height) {
        int maxArea  = 0, left = 0, right = height.length - 1;

        while(left < right)
        {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if(height[left] < height[right])
            {
                left++;
            }
            else
            {
                right --;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertical lines: ");
        int n = scanner.nextInt();

        int[] height = new int[n];
        System.out.println("Enter the heights of the vertical lines:");
        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }

        scanner.close();

        int maxWater = maxArea(height);
        System.out.println("Maximum amount of water the container can store: " + maxWater);
    }
}