package problems.lengthOfLongestSubarrayWithAtMostKFrequency;

import java.util.HashMap;
import java.util.Map;

class Solution {
    /*
    Attempt 1:
    missed this case:
    [2,2,3] k = 1, expected 2, got 1
    This is because I should drop the first 2 and start counting from the second 2
     */
    public int maxSubarrayLength1(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                int count = map.get(num);
                if (count < k) {
                    map.put(num, map.get(num) + 1);
                } else {
                    break;
                }
            } else {
                map.put(num, 1);
            }
            max++;

        }
        return max;
    }

    /*
    Attempt 2:
    Solution is good, but Time Limit Exceeded
     */
    public int maxSubarrayLength2(int[] nums, int k) {
        int biggest = 0;
        for(int i = 0; i < nums.length; i++) {
            Map<Integer,Integer> map = new HashMap<>();
            int max = 0;
            for (int j = i; j < nums.length; j++) {
                if (map.containsKey(nums[j])) {
                    int count = map.get(nums[j]);
                    if (count < k) {
                        map.put(nums[j], map.get(nums[j]) + 1);
                    } else {
                        break;
                    }
                } else {
                    map.put(nums[j], 1);
                }
                max++;
            }
            if (max > biggest) {
                biggest = max;
            }
        }
        return biggest;
    }

    /*
    Attempt 3:
    Trying to solve it in 1 loop, using window sliding
     */
    public static int maxSubarrayLength(int[] nums, int k) {
        int biggest = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            biggest = Math.max(biggest, right - left + 1);
        }

        return biggest;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3, 1, 2};
        int k = 2;
        System.out.println(maxSubarrayLength(nums, k)); // Output: 6
    }
}
