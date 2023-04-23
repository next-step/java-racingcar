package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;


public class ResultView {
    private static final String DASH = "-";
    private static String NAME_POSITION_FORMAT = "%s : %s";
    private static String WINNERS_FORMAT = "%s가 최종 우승했습니다.";

    public static void printResult(Cars cars) {
        for (Car car : cars.getCar()) {
            System.out.println(DASH.repeat(car.getPosition()));
        }
        System.out.println("################################################################");
    }

    public static void printResultWithName(Cars cars) {
        for (Car car : cars.getCar()) {
            printCarPosition(car);
        }
        System.out.println("################################################################");
    }

    private static void printCarPosition(Car car) {
        System.out.println(
            String.format(
                NAME_POSITION_FORMAT,
                car.getName(),
                DASH.repeat(car.getPosition())
            )
        );
    }

    public static void printWinner(Cars cars){
        System.out.println(
                String.format(
                        WINNERS_FORMAT,cars.getWinners()
                )
        );
    }
}
