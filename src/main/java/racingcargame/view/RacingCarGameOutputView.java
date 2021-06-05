package racingcargame.view;

import racingcargame.model.RacingCar;
import racingcargame.model.RacingCars;

public class RacingCarGameOutputView {
    private static final String STEP = "-";

    public void outputRound(RacingCars cars) {
        for (RacingCar car : cars.getCars()) {
            System.out.println(car.getName() + " : " + stackUpSteps(car.getStep()));
        }
        System.out.println();
    }

    private String stackUpSteps(int step) {
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < step; i++) {
            bar.append(STEP);
        }
        return bar.toString();
    }

    public void outputWinners(String winners) {
        System.out.println("최종 우승자: " + winners);
    }
}
