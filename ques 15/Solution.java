import java.util.*;

class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length<3)
        {
            return result;
        }
        Arrays.sort(nums);

        for(int i = 0; i  < nums.length -2 ;i++)
        {
            if(i>0 && nums[i] == nums  [i-1])
            {
                continue;
            }
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) 
            {
                int sum = nums[left] + nums[right];
                if(sum == target)
                {
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) 
                    {
                        left ++;    
                    }
                    while (left<right && nums[right] == nums[right -1]) 
                    {
                        right --;
                    }
                    left++;
                    right--;
                }
                else  if(sum < target) 
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        List<List<Integer>> triplets = threeSum(nums);
        System.out.println("Triplets: " + triplets);

        scanner.close();
    }
}