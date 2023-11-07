package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {
    private static final StringBuilder stringBuilder = new StringBuilder();

    private ResultView() {
    }

    public static void printPosition(String name, int position) {
        stringBuilder.setLength(0);
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        System.out.println(name.trim() + " : " + stringBuilder.toString());
    }

    public static void printWinner(String input) {
        System.out.println(input + "가 최종 우승했습니다.");
    }
}