package game.view.output;

import game.domain.car.Car;
import game.domain.car.RacingGameCarList;

public class RacingGameOutput {

    private final static String RESULT_GUIDE = "실행 결과";
    private final static String LOCATION_CHARACTER = "-";
    private final static String LOCATION_GUIDE = " : ";
    private final static String WINNER_SEPARATOR = ", ";
    private final static String WINNER_GUIDE = "가 최종 우승했습니다.";

    public static void printCarsStatus(RacingGameCarList racingGameCarList) {
        for (Car car : racingGameCarList.cars()) {
            printCarLocation(car);
        }
    }

    private static void printCarLocation(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(car.carName().getCarName()).append(LOCATION_GUIDE);
        for (int i = 0; i < car.location().getLocation(); i++) {
            stringBuilder.append(LOCATION_CHARACTER);
        }
        System.out.println(stringBuilder);
    }

    public static void startGame() {
        System.out.println(RESULT_GUIDE);
    }

    public static void finishRound() {
        System.out.println();
    }

    public static void endGame(RacingGameCarList racingGameCarList) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < racingGameCarList.cars().size() - 1; i++) {
            result.append(racingGameCarList.cars().get(i).carName()).append(WINNER_SEPARATOR);
        }
        result.append(racingGameCarList.getLast().carName());
        result.append(WINNER_GUIDE);
        System.out.println(result);
    }
}
