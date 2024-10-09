package racingcar.refactoring.view;

import racingcar.refactoring.utils.StringUtils;

import java.util.List;

public class ResultView {

    private ResultView() {
    }

    public static void showResultDescription() {
        System.out.println("\n실행 결과");
    }

    public static void nextLine() {
        System.out.println();
    }

    public static void showCarNameAndResult(String name, Integer position) {
        System.out.println(name + " : " + StringUtils.repeatCharacter('-', position));
    }

    public static void printWinnersName(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
