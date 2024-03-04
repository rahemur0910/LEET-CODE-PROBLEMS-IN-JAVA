import java.util.Scanner;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // Ensure nums1 is the smaller array
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            int tmp = m;
            m = n;
            n = tmp;
        }

        int minIndex = 0;
        int maxIndex = m;
        int halfLength = (m + n + 1) / 2;

        while (minIndex <= maxIndex) {
            int i = (minIndex + maxIndex) / 2;
            int j = halfLength - i;

            if (i < maxIndex && nums2[j - 1] > nums1[i]) {
                // i is too small, increase i
                minIndex = i + 1;
            } else if (i > minIndex && nums1[i - 1] > nums2[j]) {
                // i is too big, decrease i
                maxIndex = i - 1;
            } else {
                // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        //System.out.println("Enter the sorted elements of nums1 separated by spaces:");
        String[] nums1Str = scanner.nextLine().split(" ");
        int[] nums1 = new int[nums1Str.length];
        for (int i = 0; i < nums1Str.length; i++) {
            nums1[i] = Integer.parseInt(nums1Str[i]);
        }

        //System.out.println("Enter the sorted elements of nums2 separated by spaces:");
        String[] nums2Str = scanner.nextLine().split(" ");
        int[] nums2 = new int[nums2Str.length];
        for (int i = 0; i < nums2Str.length; i++) {
            nums2[i] = Integer.parseInt(nums2Str[i]);
        }

        double median = solution.findMedianSortedArrays(nums1, nums2);
        //System.out.println("Median of the two sorted arrays: " + median);
        System.out.println(median);

        scanner.close();
    }
}