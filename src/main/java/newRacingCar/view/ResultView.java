package newRacingCar.view;

import newRacingCar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String CAR_PATH =  "-";
    private static final String SEPARATOR =  ",";
    private static final String BLANK = " ";
    private static final String COLON = ":";

    public void printCarRace(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(printRace(car));
        }
        System.out.println();
    }

    private String printRace(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName());
        sb.append(BLANK);
        sb.append(COLON);
        int moveCount = car.getPosition().getPosition();

        for (int i = 0; i < moveCount; i++) {
            sb.append(CAR_PATH);
        }

        return sb.toString();
    }

    public void printWinners(List<Car> winnersCars) {
        String winner = winnersCars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(SEPARATOR));

        System.out.println(winner + "가 최종 우승했습니다.");
    }
}
