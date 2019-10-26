package racingcar;

import java.util.List;

public class ResultView {

    private List<RacingCycle> cycles;

    public ResultView(List<RacingCycle> cycles) {
        this.cycles = cycles;
    }

    public void print() {
        for (RacingCycle cars : cycles) {
            printCycle(cars);
        }
    }

    private void printCycle(RacingCycle cycle) {
        for (Car car : cycle.get()) {
            System.out.println(drawLocation(car.getLocation()));
        }

        System.out.println();
    }

    private String drawLocation(int location) {
        StringBuilder locationBuilder = new StringBuilder();
        for (int i = 0; i < location; i++) {
            locationBuilder.append("-");
        }
        return locationBuilder.toString();
    }
}
