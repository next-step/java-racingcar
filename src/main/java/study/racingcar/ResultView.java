package study.racingcar;

import java.util.List;

public class ResultView {

    private static final String MOVE_MARK = "-";
    private static final String NAME_CLONE = " : ";
    public static void resultGame(Car car) {
        printCarName(car.getName());

        for (int i = 0; i < car.currentPosition(); i++) {
            System.out.print(MOVE_MARK);
        }

        emptyLine();
    }

    public static void emptyLine() {
        System.out.println();
    }

    public static void startGame() {
        System.out.println("실행 결과");
    }

    private static void printCarName(String name) {
        System.out.print(name + NAME_CLONE);
    }

    public static void winner(List<String> winner) {
        System.out.println(String.join(", ", winner) + "가 최종 우승했습니다.");
    }
}
