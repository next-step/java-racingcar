package racingcar.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Vehicle;

public class ResultView {

    private final String DISPLAY_STRING = "-";
    private final List<Vehicle> vehicles;

    public ResultView(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
        System.out.println("실행 결과");
    }

    public void printResult() {
        for (Vehicle vehicle : vehicles) {
            System.out.println(String.format("%s : %s", vehicle.getName(), DISPLAY_STRING.repeat(vehicle.getPosition() + 1)));
        }
        System.out.println();
    }

    public void printWinners() {
        int maxMovePosition = getMaxPosition();
        System.out.println(String.format("%s가 최종 우승했습니다.", getWinnerNames(maxMovePosition)));
    }

    private int getMaxPosition() {
        int maxMove = 0;
        for (Vehicle vehicle : vehicles) {
            maxMove = vehicle.max(maxMove);
        }

        return maxMove;
    }

    private String getWinnerNames(int maxMovePosition) {
        List<String> winners = vehicles.stream()
            .filter(vehicle -> vehicle.isMatch(maxMovePosition))
            .map(Vehicle::getName)
            .collect(Collectors.toList());

        return String.join(", ", winners);
    }
}
