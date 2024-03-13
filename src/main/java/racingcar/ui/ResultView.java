package racingcar.ui;

import java.util.List;

import racingcar.Vehicle;

public class ResultView {

    private final String DISPLAY_STRING = "-";
    private List<Vehicle> vehicles;

    public ResultView(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
        System.out.println("실행 결과");
    }

    public void printResult() {
        for (Vehicle vehicle : vehicles) {
            System.out.println(String.format("%s : %s", vehicle.getName(), DISPLAY_STRING.repeat(vehicle.getMoveCount())));
        }
        System.out.println();
    }
}
