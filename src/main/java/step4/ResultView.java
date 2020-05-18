package step4;

import static step4.Constants.*;

import java.util.ArrayList;

public class ResultView {

    public void printResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public void printCurrentResult(RacingGame racingGame) {
        ArrayList<Car> cars = racingGame.getCars();
        for (Car car : cars) {
            System.out.printf("%s : %s\n", car.getName(), makeCarPosition(car.getPosition()));
        }
        System.out.println();
    }

    public String makeCarPosition(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; ++i) {
            stringBuilder.append(POSITION_MARKER);
        }
        return stringBuilder.toString();
    }

    public void printWinners(RacingGame racingGame) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String winner : racingGame.getWinners()) {
            if (stringBuilder.length() >= 1) {
                stringBuilder.append(COMMA);
            }
            stringBuilder.append(winner);
        }
        System.out.printf("%s가 최종 우승했습니다.\n", stringBuilder.toString());
    }
}
