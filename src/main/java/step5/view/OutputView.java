package step5.view;

import step5.model.Car;
import step5.model.Participants;

import java.util.*;
import java.util.stream.Collectors;

public class OutputView {
    public static final String BANNER_STRING = "실행 결과";
    public static final String DASH_STRING = "-";
    public static final String WINNER_COMMENT = "가 최종 우승했습니다.";

    public static String getDashDistance(int value) {
        // 현재 이 String을 Thread Safe로 할 의미가 없으므로, StringBuilder로 수정
        StringBuilder dashString = new StringBuilder();
        // Java 11에서는 DASH_STRING.REPEAT(value)로 치환 가능
        return dashString.append(String.join("", Collections.nCopies(value, DASH_STRING))).toString();
    }

    public static void showBanner() {
        System.out.println(BANNER_STRING);
    }

    public static void showResultOfGame(Participants players) {
        showDistanceOfEachGameSet(players.getMemberOfParticipants(), players.getScoreOfParticipants());

    }

    public static void printWinnersFromParticipants(List<String> winnerMembers) {
        System.out.printf("%s" + WINNER_COMMENT + "%n",
                winnerMembers.stream()
                        .filter(Objects::nonNull)
                        .collect(Collectors.joining(", "))
        );
    }

    private static void showDistanceOfEachGameSet(List<String> members, List<Integer> trials) {
        for (int loop = 0; loop < members.size(); loop++) {
            System.out.println(members.get(loop) + ": " + getDashDistance(trials.get(loop)));
        }
    }
}
