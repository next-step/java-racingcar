package util;

import java.util.List;

public class NumberUtil {

    /**
     * 리스트에 담긴 숫자 중 어떤 값이 최대 값인지 찾는 함수
     */
    public static int getMaxNumberOfList(List<Integer> numList) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < numList.size(); i++) {
            maxValue = Math.max(maxValue, numList.get(i));
        }
        return maxValue;
    }

}
