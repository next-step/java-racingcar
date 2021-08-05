package study.racingcar.view;

import study.racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void racingResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + convertPositionToHyphen(car.getPosition()));
        }
        System.out.println();
    }


    public static void racingWinnerResult(List<Car> racingWinners) {
        String winnerNames = racingWinners.stream()
                .map(Car::getName).collect(Collectors.joining(","));

        System.out.println(winnerNames + "가 최종 우승했습니다");
    }

    public static String convertPositionToHyphen(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
