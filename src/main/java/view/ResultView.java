package view;

import domain.Car;
import domain.Cars;

public class ResultView {

    private final static String BLANK = "";
    private final static String RESULT_MESSAGE = "실행 결과";
    private final static String DISTANCE_BLOCK = "-";
    private final static String COLONS = " : ";
    private final static String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private final static String WINNER_DELIMITER = ", ";

    public static void drawResultView() {
        System.out.println(RESULT_MESSAGE);
        System.out.println(BLANK);
    }

    public static void drawDistanceBlockWithName(Cars cars) {
        for (int i = 0; i < cars.countCars(); i++) {
            drawConsole(cars.getEachCar(i));
        }
        System.out.println(BLANK);
    }

    public static void drawConsole(Car car) {

        String currentCarDistanceWithName = car.getCarName() + COLONS;
        for (int i = 0; i < car.getCarCurrentDistance(); i++) {
            currentCarDistanceWithName += DISTANCE_BLOCK;
        }
        System.out.println(currentCarDistanceWithName);
    }

    public static void drawFirstPlace(Cars cars) {
        String winners = String.join(WINNER_DELIMITER, cars.getWinnerNames());
        System.out.println(winners + WINNER_MESSAGE);
    }
}
