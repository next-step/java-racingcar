package racingcar.view;

import racingcar.car.Position;

public class ResultView {

    private final static StringBuilder carStatusString = new StringBuilder();

    public static void printResultTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printCarPositionStatus(Position position) {
        carStatusString.setLength(0);

        for (int i = 0; i < position.getPosition(); i++) {
            carStatusString.append("-");
        }

        System.out.println(carStatusString);
    }
}
