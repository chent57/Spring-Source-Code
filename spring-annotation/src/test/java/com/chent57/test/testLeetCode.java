package com.chent57.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testLeetCode {

    int[] nums = {1,2,3};

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> track = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, track);
        return ans;
    }

    private void backtrack(int[] nums, int start, List<Integer> track) {
        System.out.println("++++++++ enter backtrack +++++++");

        ans.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            System.out.println("++++++++ enter for loop +++++++");
//            if (i > start && nums[i] == nums[i-1]) {
//                continue;
//            }
            track.add(nums[i]);
            System.out.println("++++ 1 ++++ track:" + track);
            System.out.println("backtrack:" + (i+1));
            System.out.println();
            backtrack(nums, i + 1, track);

            System.out.println("---- 2 ---- track:" + track);
            System.out.println("track.remove: " + (track.size() - 1));
            System.out.println();
            track.remove(track.size() - 1);
        }
    }
    @Test
    public void test() {
        subsetsWithDup(nums);
    }
}
