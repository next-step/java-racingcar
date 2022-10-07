package step3;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Race {

    public static void start(ArrayList<Car> cars) {
        for(Car car: cars) {
            int speed = Engine.getSpeed();
            car.move(speed);
        }
    }

    public static String getWinners(ArrayList<Car> cars) {
        int winnersScore = getWinnersScore(cars);
        return cars.stream()
                .filter(car -> car.getDistance() == winnersScore)
                .map(winnerCar -> winnerCar.name)
                .collect(Collectors.joining(" ,"));
    }

    public static int getWinnersScore(ArrayList<Car> cars) {
        int max = -1;
        for(Car car: cars) {
            max = Math.max(max,car.getDistance());
        }
        return max;
    }


    private static void setWinner() {

    }

}
