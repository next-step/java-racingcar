package step3.presentation;

import java.util.List;
import java.util.stream.IntStream;
import step3.domain.Car;

public class OutputView {

        private static final String PATH_SIGN = "-";
        private static final String NEW_LINE = "\n";

        private OutputView() {
        }

        public static void printPositionForAllCarsInCurrentRound(List<Car> cars) {
                cars.forEach(car-> printCurrentPosition(car.getCurrentPosition()));
                printNewLine();
        }

        private static void printCurrentPosition(int currentPosition){
                IntStream.range(0, currentPosition).forEach(i -> System.out.print(PATH_SIGN));
                printNewLine();
        }

        private static void printNewLine(){
                System.out.print(NEW_LINE);
        }

}
