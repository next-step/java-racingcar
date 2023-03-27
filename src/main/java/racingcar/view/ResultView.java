package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    public static void printRace(List<Car> cars, String winner){
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println("최종우승자: " + winner);
    }
}
