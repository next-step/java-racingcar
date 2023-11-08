package racingcar.presentation;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

        private static final String PATH_SIGN = "-";
        private static final String BETWEEN_NAME_AND_PATH_SIGN = " : ";
        private static final String NEW_LINE = "\n";
        private static final String COMMA = ",";
        private static final String RESULT_VIEW_TITLE = "실행결과";

        private ResultView() {
        }

        public static void printResultViewTitle(){
                System.out.println(NEW_LINE + RESULT_VIEW_TITLE);
        }

        public static void printPositionForAllCarsInCurrentRound(List<Car> cars) {
                cars.forEach(ResultView::printCurrentPosition);
                printNewLine();
        }

        public static void printWinner(List<Car> cars){
                String winnersInOneLine = cars.stream().map(Car::getName).collect(Collectors.joining(COMMA));
                System.out.println(winnersInOneLine + "가 최종 우승했습니다.");
        }

        private static void printCurrentPosition(Car car) {
                printName(car.getName());
                System.out.print(PATH_SIGN.repeat(car.getCurrentPosition()));
                printNewLine();
        }

        private static void printName(String name){
                System.out.print(name + BETWEEN_NAME_AND_PATH_SIGN);
        }

        private static void printNewLine(){
                System.out.print(NEW_LINE);
        }

}
