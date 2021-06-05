package racingcargame.view;

import racingcargame.model.RacingCar;
import racingcargame.model.RacingCars;

public class RacingCarGameOutputView {
    private static final String BAR = "-";

    public void outputRound(RacingCars cars) {
        for (RacingCar car : cars.getCars()) {
            System.out.println(car.getName() + " : " + stackUpBars(car.getStep()));
        }
        System.out.println();
    }

    private String stackUpBars(int step) {
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < step; i++) {
            bar.append(BAR);
        }
        return bar.toString();
    }

    public void outputWinners(String winners) {
        System.out.println("최종 우승자: " + winners);
    }
}
