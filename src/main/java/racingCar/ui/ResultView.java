package racingCar.ui;

import racingCar.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String CAR_PATH =  "-";
    private static final String SEPARATOR =  ",";

    public void printCarRace(List<Car> raceCar) {
        for (Car car : raceCar) {
            car.move();
            System.out.println(printRace(car));
        }
        System.out.println();
    }

    private String printRace(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName());
        sb.append(" ");
        sb.append(":");
        int moveCount = car.getMoveCount();

        for (int i = 0; i < moveCount; i++) {
            sb.append(CAR_PATH);
        }

        return sb.toString();
    }

    public void printWinners(List<Car> winnerCars) {
        String winner = winnerCars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(SEPARATOR));

        System.out.println(winner + "가 최종 우승했습니다.");
    }
}

