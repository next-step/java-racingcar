package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {

    public static void start(List<Car> cars) {
        for(Car car: cars) {
            car.move();
        }
    }

    public static String getWinners(List<Car> cars) {
        int winnersScore = getWinnersScore(cars);
        return cars.stream()
                .filter(car -> car.getDistance() == winnersScore)
                .map(winnerCar -> winnerCar.name)
                .collect(Collectors.joining(" ,"));
    }

    public static int getWinnersScore(List<Car> cars) {
        int max = -1;
        for(Car car: cars) {
            max = Math.max(max,car.getDistance());
        }
        return max;
    }


}
