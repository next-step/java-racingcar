package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cycles;
import racingcar.domain.RacingCycle;
import racingcar.domain.RacingGame;

import java.util.List;

import static racingcar.domain.UserInput.DELIMITER;

public class ResultView {

    private Cycles cycles;

    private static final String LOCATION_EXPRESSION_STRING = "-";

    public ResultView(Cycles cycles) {
        this.cycles = cycles;
    }

    public void printRace() {
        for (RacingCycle cars : cycles.getCycles()) {
            printCycle(cars);
        }
    }

    public void printWinner() {

        List<String> winners = cycles.findWinners();
        System.out.println(String.format("%s가 최종 우승하였습니다.", String.join(DELIMITER, winners)));
    }


    private void printCycle(RacingCycle cycle) {
        for (Car car : cycle.getCycle()) {
            System.out.println(drawLocation(car.getName(), car.getLocation()));
        }

        System.out.println();
    }

    private String drawLocation(String name, int location) {
        StringBuilder locationBuilder = new StringBuilder();
        locationBuilder.append(name)
                .append(" : ");
        for (int i = 0; i < location; i++) {
            locationBuilder.append(LOCATION_EXPRESSION_STRING);
        }
        return locationBuilder.toString();
    }

}
