package view;

import domain.racingcar.RacingCars;

public interface Result {
    void view();

    void raceResult(RacingCars racingCars, int numOfRaces);

    default String createCarDistanceBar(int distance) {
        StringBuilder stringBuilder = new StringBuilder();

        while (distance > 0) {
            stringBuilder.append("-");
            distance--;
        }

        return stringBuilder.toString();
    }
}
