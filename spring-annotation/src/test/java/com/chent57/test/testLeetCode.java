package com.chent57.test;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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
    public void test_computeIfAbsent() {
        Map<String, String> map = new HashMap<>();
        //map.put("test", "test");
        String res = map.computeIfAbsent("test", x -> "value");
        System.out.println(res);
        System.out.println(map.toString());


        map.computeIfAbsent("test", x -> "value1");
        System.out.println(map.toString());
    }



    public static void main(String[] s) {
        Map<String, Boolean> whoLetDogsOut = new ConcurrentHashMap<>();
        whoLetDogsOut.computeIfAbsent("snoop", k -> f(k));
        whoLetDogsOut.computeIfAbsent("snoop", k -> f(k));
    }
    static boolean f(String s) {
        System.out.println("creating a value for \""+s+'"');
        return s.isEmpty();
    }


    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    @Test
    public void test_Tree() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = null;
        node2.right = node5;
        node3.left = null;
        node3.right = null;


        Stack<TreeNode> stack = new Stack<>();


    }
}
