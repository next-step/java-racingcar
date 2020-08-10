package step3.view;

import java.util.Collections;
import java.util.List;

public class OutputView {
    public static final String BANNER_STRING = "실행 결과";
    public static final String DASH_STRING = "-";

    public static String getDashDistance(int value) {
        // 현재 이 String을 Thread Safe로 할 의미가 없으므로, StringBuilder로 수정
        StringBuilder dashString = new StringBuilder();
        // Java 11에서는 DASH_STRING.REPEAT(value)로 치환 가능
        return dashString.append(String.join("", Collections.nCopies(value, DASH_STRING))).toString();
    }

    public static void showResultOfGame(List<List<Integer>> scoreBoard) {
        System.out.println(BANNER_STRING);
        // For문으로 구성된 내용을 Stream으로 모두 변경 진행
        for (List<Integer> setScore : scoreBoard) {
            showDistanceOfEachGameSet(setScore);
            System.out.println();
        }
    }

    private static void showDistanceOfEachGameSet(List<Integer> scoreBoard) {
        for (Integer integer : scoreBoard) {
            System.out.println(getDashDistance(integer));
        }
    }
}
