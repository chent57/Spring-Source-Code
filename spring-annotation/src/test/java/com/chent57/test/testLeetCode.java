package com.chent57.test;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    @Test
    public void test_greedy() {
        String S = "ababcbacadefegdehijhklij";

        for (int i = 0; i < S.length(); i++) {



        }

        // 1. 快指针往前走，记录已经遍历过的字符；如果遇到出现过的字符，慢指针指向出现字符的下一个字符
        // 2. 截取字符串，写入list中，
    }



    @Test
    public void test941() {
//        int[] A = {0,2,3,4,5,2,1,0};
        int[] A = {9,8,7,6,5,4,3,2,1,0};
        int len = A.length;
        int peak = 0;
        for (int i = 1; i < len - 1; ++i) {
            if (A[i] > A[i-1] && A[i] > A[i+1]) {
                peak = i;
            }
        }

        System.out.println(peak);
        for (int i = 0; i < peak; i++) {
            if (A[i] >= A[i+1]) {
                System.out.println(A[i] +  "  " + A[i+1]);
                System.out.println("false1");;
            }
        }

        for (int i = peak; i <len-1; i++) {
            if (A[i] <= A[i+1]) {
                System.out.println("false2");;
            }
        }

    }

    @Test
    public void test57() {

        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};


        int len = intervals.length;
        int[][] merge = new int[len+1][2];
        for (int i = 0; i < len; ++i) {
            merge[i] = intervals[i];
        }
        merge[len] = newInterval;

        for (int i = 0; i < len +1; i++) {
            System.out.println(merge[i]);
        }

    }

    @Test
    public void test127() {
        String s = "1234";
        String t = "123";
        // System.out.println(s.equals(t));
        // System.out.println(s.charAt(0));;
        t.length();
        Set<String> set = new HashSet<>();


        // List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        // List<String> wordList = Arrays.asList("hot","dog");
        List<String> wordList = Arrays.asList("hot","dot","tog","cog");
        //System.out.println(getList("hit", wordList));

        System.out.println(bfs("hit", "cog", wordList));



    }
    private List<String> getList(String word, List<String> wordList) {
        List<String> ret = new ArrayList<>();
        for (String s : wordList) {
            int gap = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) != word.charAt(i)) {
                    gap++;
                }
            }
            if (gap == 1) {
                ret.add(s);
            }
        }
        return ret;
    }

    private int bfs(String beginWord, String endWord, List<String> wordList) {
        int step = 1;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (q.size() != 0) {
            int sz = q.size();

            System.out.println("++++++++++");
            for (int i = 0; i < sz; ++i) {
                String cur = q.poll();
                System.out.println(cur);

                if (cur.equals(endWord)) {
                    return step;
                }
                List<String> adj = getList(cur, wordList);
                if (adj.size() == 0) {
                    return 0;
                }
                System.out.println(adj);
                for (String s : adj) {
                    if (!visited.contains(s)) {
                        q.offer(s);
                        visited.add(s);
                    }
                }
            }
            step++;
        }
        return step;
    }



    @Test
    public void test1356() {
        System.out.println(calcBinary1(123));



        int[] nums = {1024,512,256,128,64,32,16,8,4,2,1};
        Integer[] Nums = new Integer[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            Nums[i] = nums[i];
        }
        Arrays.sort(Nums, new iComparator());
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "  ");
        }




    }

    class iComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if (calcBinary1(o1) == calcBinary1(o2)) {
                return o1 - o2;
            } else {
                return calcBinary1(o1) - calcBinary1(o2);
            }
        }
    }

    private int calcBinary1(int num) {
        int count = 0;
        while(num != 0) {
            count++;
            num = num & (num-1);
        }

        return count;
    }



    @Test
    public void test327() {
        int[] nums = {-2147483647,0,-2147483647,2147483647};
        int len = nums.length;
        int upper = 3864, lower = -564;


        int ans = 0;

        for (int i = 0; i < len; i++) {
            long sum = nums[i];
            if (sum >= lower && sum <= upper) {
                ans++;
            }

            for (int j = i+1; j < len; j++) {
                sum += nums[j];
                if (sum >= lower && sum <= upper) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(nums[0] + nums[1]);

    }

    private int calcDistance(Integer[] point) {
        return (int) (Math.pow((point[0] - 0), 2) + Math.pow((point[1] - 0), 2));
    }

    class IComparator implements Comparator<Integer[]>{
        @Override
        public int compare(Integer[] o1, Integer[] o2) {
            return calcDistance(o1) - calcDistance(o2);
        }
    }

    @Test
    public void test973() {
        Integer[] point = new Integer[2];
        point[0] = 1;
        point[1] = 3;
        //System.out.println(calcDistance(point));


        int[][] points = {{3,3},{5,-1},{-2,4}};
        int len = points.length;
        Integer[][] p = new Integer[len][2];

        for (int i = 0; i < points.length; i++) {
            p[i][0] = points[i][0];
            p[i][1] = points[i][1];
        }

        for (Integer[] integers : p) {
            System.out.println(integers[0] + "," + integers[1]);
        }

        /*
        System.out.println(points[0][0] + "  " + points[0][1]);


        for (Integer[] integers : points) {
            System.out.println(integers[0] + "," + integers[1]);
        }

        Arrays.sort(points, new IComparator());

        System.out.println();

        for (Integer[] integers : points) {
            System.out.println(integers[0] + "," + integers[1]);
        }

        */
    }


    public void nextPermutation(int[] nums) {
        // 从后往前遍历，找到后面比前面大的那个位置
        int len = nums.length;

        if (len == 2) {
            if (nums[1] > nums[0]) {
                int temp = nums[0];
                nums[0] = nums[1];
                nums[1] = temp;
                return;
            } else {
                Arrays.sort(nums);
            }
        }

        int index = 0;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i-1;
                break;
            }
        }

        if (index == 0) {
            // 替换第一个数字
            Arrays.sort(nums, 1, len);
            int target = 0;
            for (int i = 1; i < len; i++) {
                if (nums[i] > nums[0]) {
                    target = i;
                    break;
                }
            }
            if (target == 0) {
                Arrays.sort(nums);
            } else {
                int temp = nums[0];
                nums[0] = nums[target];
                nums[target] = temp;
                Arrays.sort(nums, 1, len);
            }
        } else {
            // 交换两个值
            int temp = nums[index];
            nums[index] = nums[index+1];
            nums[index + 1] = temp;

            // 对index后面的数排序
            Arrays.sort(nums, index + 1, len);
        }
    }

    @Test
    public void test31() {
        int[] nums = {5, 4,7,5,3,2};
        nextPermutation(nums);
        System.out.println();
        for (int x : nums) {
            System.out.print(x);
            System.out.print("->");
        }
//
//        Arrays.sort(nums, 0, 3);
//
//        System.out.println();
//        for (int x : nums) {
//            System.out.print(x);
//            System.out.print("->");
//        }

    }


    @Test
    public void test1030() {


        List<List<Integer>> points = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                points.add(temp);
            }
        }
        System.out.println(points);

        int[][] intArray = points.stream().map(  u  ->  u.stream().mapToInt(i->i).toArray()  ).toArray(int[][]::new);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(intArray[i][j]);
            }
        }

    }

    @Test
    public void Test134() {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] - cost[i] > max) {
                max = gas[i] - cost[i];
                index = i;
            }
        }

        System.out.println(index);
        System.out.println(max);

        for (int j = 0; j < gas.length - 1; j++) {

        }


    }

    @Test
    public void test452() {
        int[][] points = {{-2147483646,-2147483645}, {2147483646,2147483647}};
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < points.length; i++) {
            System.out.println(points[i][0] + "," + points[i][1]);
        }

        int yMin = points[0][1];
        int count = 1;

        for (int i = 0; i < points.length; i++) {
            if (points[i][0] > yMin) {
                yMin = points[i][1];
                count++;
            }
        }

        System.out.println(count);

    }

    @Test
    public void test54() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        List<Integer> ans = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;

        int account = matrix.length * matrix[0].length;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) {
                break;
            }

            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if (right < left) {
                break;
            }

            for (int i = right; i >= left; i--) {
                ans.add(matrix[bottom][i]);
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                ans.add(matrix[i][left]);
            }
            left++;




        }
        System.out.println(ans.toString());
    }



    @Test
    public void test222() {
        //Integer.MAX_VALUE;
    }


    @Test
    public void test1370() {

        String s = "leetcode";
        char[] charArr = s.toCharArray();

        System.out.println('a' - 92);

        int[] nums = new int[26];

        for (int i = 0; i < s.length(); i++) {
            nums[charArr[i] - 97] ++;
        }


        StringBuffer ret = new StringBuffer();
        while (ret.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (nums[i] > 0) {
                    ret.append('a' + i);
                    nums[i]--;
                }
            }

            for (int i = 25; i >= 0; i--) {
                if (nums[i] > 0) {
                    ret.append('a' + i);
                    nums[i]--;
                }
            }
        }
    }


    @Test
    public void test08() {
        String s = "9223372036854775808";

        int ret = myAtoi(s);
        System.out.println(ret);
    }

    public int myAtoi(String s) {

        if (s.length() == 0) {
            return 0;
        }
        long ret = 0L;
        char[] charArray = s.toCharArray();

        // 正负号
        int symbol = 0;

        boolean nums = false;

        int i = 0;

        // 丢弃头部空格
        for (; i < s.length(); i++) {
            if (charArray[i] != ' ') {
                break;
            }
        }

        if (i == s.length()) {
            return 0;
        }

        // 第一个不是正负号和数字
        if (charArray[i] == '+' || charArray[i] == '-' || (charArray[i] - '0' >= 0 && charArray[i] - '0' <= 9)) {
            for (; i < s.length(); i++) {
                // 正负号
                if (charArray[i] == '+' || charArray[i] == '-') {
                    // 后面又出现正负号, 或者前面有数字后面又出现符号
                    if (symbol != 0 || nums == true) {
                        break;
                    }

                    if (charArray[i] == '+') {
                        symbol = 1;
                    } else {
                        symbol = 2;
                    }
                    continue;
                    // 是数字
                } else if (charArray[i] - '0' >= 0 && charArray[i] - '0' <= 9) {
                    nums = true;
                    ret = ret * 10 + (charArray[i] - '0');
                    if (ret > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    } else if (ret < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    break;
                }
            }
        } else {
            return 0;
        }

        // 取符号
        if (symbol == 2) {
            ret = 0 - ret;
        }

        // 溢出情况分析
        if (ret > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (ret < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)ret;
        }

    }


    @Test
    public void test43() {
        boolean carry = true;
        int sum = 15;

        char c = (char)('0' + (sum%10) + (carry == true ? 1 : 0));

        System.out.println(c);
    }

    @Test
    public void test164() {
        int[] nums = new int[10];

        Arrays.sort(nums);
    }

    @Test
    public void test767() throws InterruptedException {
        String S = "aaab";
        System.out.println("result:" + reorganizeString(S));

    }

    public String reorganizeString(String S) throws InterruptedException {
        int len = S.length();
        int[] nums = new int[26];
        char[] charArray = S.toCharArray();
        for (int i = 0; i < len; i++) {
            nums[charArray[i] - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        char lastChar = ' ';
        while (len !=0) {
            for (int i = 0; i < 26; i++) {
                if (nums[i] > 0) {
                    if (lastChar != ' ' && lastChar == (char)('a' + i)) {
                        return "";
                    }
                    sb.append((char)('a' + i));
                    nums[i]--;
                    len--;
                    lastChar = (char)('a' + i);
                }
            }
        }
        return sb.toString();
    }


    @Test
    public void test34() {
//        int[] nums = {5,7,7,8,8,10};
        int[] nums = {6,7,7,8,8,10};
        int target = 10;

        int len = nums.length;
        int start = Integer.MAX_VALUE, end = Integer.MAX_VALUE;
        if (len == 0) {
            start = -1;
            end = -1;
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] == target && start == Integer.MAX_VALUE) {
                start = i;
            }
            if (nums[i] == target) {
                end = i;
            }
        }

        if (start == Integer.MAX_VALUE) {
            start = -1;
            end = -1;
        }

        int[] res = {start, end};


        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }


    }









}
