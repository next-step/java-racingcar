package study.domain;


import java.util.Arrays;

public class Calculator {
    public int sum(Expression expression) {
        int[] nums = expression.extractOnlyNum();
        if(isContainNegativeNum(nums)) {
            throw new RuntimeException();
        }
        return Arrays.stream(nums)
                .sum();
    }
    private boolean isContainNegativeNum(int[] nums) {
        if(nums == null) {
            return false;
        }
        return Arrays.stream(nums)
                .anyMatch(num -> num < 0);
    }
}
