package com.learn.linni.algo.questions;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.LinkedList;

/**
 * 求滑动窗口中最大值
 *
 * @author : linjun.li@quvideo.com
 * @date : 2019-06-03 09:02
 */

public class SlidingWindowMaxValue {

    private static LinkedList<Integer> maxValue(int[] nums, int windowSize) {
        LinkedList<Integer> result = new LinkedList<>();
        if (ArrayUtils.isEmpty(nums) || windowSize < 1) {
            return result;
        }

        LinkedList<Integer> windowElementIndex = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i >= windowSize && windowElementIndex.getFirst() <= i - windowSize) {
                windowElementIndex.removeFirst();
            }

            int num = nums[i];
            while (CollectionUtils.isNotEmpty(windowElementIndex) && num >= nums[windowElementIndex.getFirst()]) {
                windowElementIndex.removeFirst();
            }

            windowElementIndex.addLast(i);
            if (windowSize - i <= 1) {
                result.add(nums[windowElementIndex.getFirst()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,6,1,76,89,9,34,54,23};
        LinkedList<Integer> integers = maxValue(nums, 3);
        System.out.println(JSON.toJSONString(integers));
    }
}
