package study.racing.view;

import study.racing.domain.CarName;
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
        System.out.print(car.getName().value() + " : ");
        printPosition(car.getPosition().value());
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

    private static String joinWinnerNames(List<Car> winnerCars) {
        List<CarName> names = new ArrayList<>();

        for (Car car : winnerCars) {
            names.add(car.getName());
        }

        return String.join(WINNER_SEPARATOR, names.stream().map(CarName::value).toList());
    }

    public static void printEmptyLine(){
        System.out.println();
    }
}
