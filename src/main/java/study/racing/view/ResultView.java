package study.racing.view;

import study.racing.domain.Car;
import study.racing.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    private static final String WINNER_SEPARATOR = ", ";
    private static final String MARK = "-";

    public static void printStartGame() {
        System.out.println("실행 결과");
    }

    public static void printGameRound(Car car) {
        System.out.print(car.getName() + " : ");
        printPosition(car.getPosition());
    }

    private static void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(MARK);
        }
        printEmptyLine();
    }

    public static void printWinners(Cars cars) {
        System.out.println(joinWinnerNames(cars.topRankCars()).concat("가 최종 우승했습니다."));
    }

    private static String joinWinnerNames(List<Car> winners) {
        List<String> names = new ArrayList<>();

        for (Car winner : winners) {
            names.add(winner.getName());
        }

        return String.join(WINNER_SEPARATOR, names);
    }

    public static void printEmptyLine(){
        System.out.println();
    }
}
