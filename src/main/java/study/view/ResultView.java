package study.view;

import study.domain.RacingCar;

import java.util.List;

public class ResultView {
    private static final String GUIDE_FOR_BEFORE_GAME_START = "실행결과=";
    private static final String MOVE_COUNT_STRING = "-";


    public static void printBeforeGameStart() {
        System.out.println(GUIDE_FOR_BEFORE_GAME_START);
    }

    public static void printResultEachRound(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            printName(racingCar.getName());
            printAfterName();
            printResultEachRound(racingCar.getMoveCount());
        }
        lineChangeEachRoundFinish();
    }

    public static void printName(String name) {
        System.out.print(name);
    }

    private static void printAfterName() {
        System.out.print(" : ");
    }

    private static void printResultEachRound(int moveCount) {
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
