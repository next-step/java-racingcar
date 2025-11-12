package racinggame.ui;

import static racinggame.ui.InputView.inputInt;
import static racinggame.ui.ResultView.printCarCountQuestion;
import static racinggame.ui.ResultView.printCarPosition;
import static racinggame.ui.ResultView.printTryCountQuestion;

import java.util.List;
import racinggame.car.Car;

// ui 의 기능의 추상화단계를 높히기 위한 클래스
public class MC {

    public static int askCarCountToUser() {
        printCarCountQuestion();

        return inputInt();
    }

    public static int askTryCountToUser() {
        printTryCountQuestion();

        return inputInt();
    }

    public static void printGameStates(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(
                    car.getPositionMark()
            );
        }
    }

}
