package racingCar.view;

import racingCar.domain.Car;
import racingCar.domain.RacingResult;

import java.util.List;

public class OutputView {

    public static void printCars(List<Car> racingCars) {
        racingCars.stream().forEach(car -> System.out.println(getResult(car)));
        System.out.println();
    }
    private static String getResult(Car car) {
        String result = car.getName() + " : ";
        for(int i = 0; i < car.getPosition().getPosition(); i++) {
            result += "-";
        }
        return result;
    }
    public static String printWinnerCar(RacingResult result) {
        String winners = "";
        for(Car car : result.getWinningCars()) {
            winners += car.getName() +", ";
        }
        winners = winners.replaceAll(", $", "");
        return winners +
                "가 최종 우승했습니다.";
    }
}
