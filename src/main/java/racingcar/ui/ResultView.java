package racingcar.ui;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Vehicle;

public class ResultView {

    private final String DISPLAY_STRING = "-";
    private List<Vehicle> vehicles;

    public ResultView(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
        System.out.println("실행 결과");
    }

    public void printResult() {
        for (Vehicle vehicle : vehicles) {
            System.out.println(String.format("%s : %s", vehicle.getName(), DISPLAY_STRING.repeat(vehicle.getMoveCount() + 1)));
        }
        System.out.println();
    }

    public void printWinners() {
        int maxMoveScore = getMaxMoveScore();
        System.out.println(String.format("%s가 최종 우승했습니다.", getWinnerNames(maxMoveScore)));
    }

    private int getMaxMoveScore() {
        int maxMove = 0;
        for (Vehicle vehicle : vehicles) {
            maxMove = compareMaxMoveScore(maxMove, vehicle.getMoveCount());
        }

        return maxMove;
    }

    private int compareMaxMoveScore(int maxMove, int vehicleMove) {
        if (maxMove < vehicleMove) {
            return vehicleMove;
        }
        return maxMove;
    }

    private String getWinnerNames(int maxMoveScore) {
        List<String> winners = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            addWinnerList(maxMoveScore, vehicle, winners);
        }
        return String.join(", ", winners);
    }

    private void addWinnerList(int maxMoveScore, Vehicle vehicle, List<String> winner) {
        if (maxMoveScore == vehicle.getMoveCount()) {
            winner.add(vehicle.getName());
        }
    }

}
