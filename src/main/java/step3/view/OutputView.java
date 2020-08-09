package step3.view;

import step3.model.SetScore;

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

    public static void showResultOfGame(List<SetScore> scoreBoard) {
        System.out.println(BANNER_STRING);
        // For문으로 구성된 내용을 Stream으로 모두 변경 진행
        for (SetScore setScore : scoreBoard) {
            showDistanceOfEachGameSet(setScore);
            System.out.println();
        }
    }

    private static void showDistanceOfEachGameSet(SetScore scoreBoard) {
        for (int loop1 = 0; loop1 < scoreBoard.getNumberOfParticipants(); loop1++) {
            System.out.println(getDashDistance(scoreBoard.getScoreOfCar(loop1)));
        }
    }
}
