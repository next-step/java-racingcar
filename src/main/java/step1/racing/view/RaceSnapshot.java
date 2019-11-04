package step1.racing.view;

import step1.racing.RacingCars;
import step1.racing.data.RacingCar;

public class RaceSnapshot {
    private static final String CAR_INDICATOR = "-";

    private final RacingCars racingCars;

    public RaceSnapshot(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (RacingCar racingCar : racingCars.getRacingCars()) {
            sb.append(racingCar.getName() + " : " + getConcatenatedChar(racingCar.getPosition())).append("\n");
        }

        return sb.toString();
    }

    private static String getConcatenatedChar(int num) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num ; i ++) {
            sb.append(CAR_INDICATOR);
        }

        return sb.toString();
    }
}
