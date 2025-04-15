package problems.twoSum;

import java.util.HashMap;
import java.util.stream.IntStream;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
 */
class Solution {

    /*
    Elegant stream solution, sadly slow :(
    1272 ms runtime
    45.34 MB memory
     */
    public int[] twoSumStream(int[] nums, int target) {

        return IntStream.range(0, nums.length)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, nums.length)
                        .filter(j -> nums[i] + nums[j] == target)
                        .mapToObj(j -> new int[]{i, j}))
                .findFirst()
                .orElse(null);
    }

    /*
    Pure imperative approach
    46 ms runtime
    44.54 MB memory
     */
    public int[] twoSumFirstAttempt(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /*
    Faster solution, this can go for now (it's 1:30 am)
    2 ms runtime
    44.98 MB memory
     */
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}