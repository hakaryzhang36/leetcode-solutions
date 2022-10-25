package com.hakaryzhang.solution;

import java.lang.reflect.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] nums = {7, 2, 4};
        System.out.println(new Solution().maxSlidingWindow(nums, 2));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        // New method
        Deque<Integer> q = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int L = 0, R = 0; R < nums.length;) {
            System.out.println(R);
            // remove first
            if (q.size() != 0 && q.peekFirst() < L) {
                q.removeLast();
            }
            // add last
            while (q.size() != 0 && nums[q.peekLast()] < nums[R]) {
                q.removeLast();
            }
            q.addLast(R);
            // update L R
            if (R - L + 1 < k) {
                R++;
                continue;
            }
            else {
                // write res
                res[L] = nums[q.peekFirst()];
                L++;
                R++;
            }
        }
        return res;
    }
}


