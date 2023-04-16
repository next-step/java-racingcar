package study;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String GUIDE_FOR_BEFORE_GAME_START = "실행결과=";
    private static final String MOVE_COUNT_STRING = "-";


    public static void printBeforeGameStart() {
        System.out.println(GUIDE_FOR_BEFORE_GAME_START);
    }

    public static void printName(String name) {
        System.out.print(name);
    }


    public static void printResultEachRound(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            System.out.print(MOVE_COUNT_STRING);
        }
        System.out.println();
    }

    public static void lineChangeEachRoundFinish() {
        System.out.println();
    }

    public static void printName(List<String> allMaxMoveCountName) {
        String joinedUserName = String.join(", ", allMaxMoveCountName);
        System.out.println(joinedUserName + "가 최종 우승했습니다.");
    }

}
