package racingcar.presentation;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

        private static final String PATH_SIGN = "-";
        private static final String NEW_LINE = "\n";

        private OutputView() {
        }

        public static void printPositionForAllCarsInCurrentRound(List<Car> cars) {
                cars.forEach(car-> printCurrentPosition(car.getCurrentPosition()));
                printNewLine();
        }

        private static void printCurrentPosition(int currentPosition) {
                PATH_SIGN.repeat(currentPosition);
                printNewLine();
        }

        private static void printNewLine(){
                System.out.print(NEW_LINE);
        }

}
