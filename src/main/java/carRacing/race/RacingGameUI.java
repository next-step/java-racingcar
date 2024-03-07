package carRacing.race;

import carRacing.car.Cars;

public interface RacingGameUI {
    void printWinners(String winners);
    void printTrack(Cars cars, int trialCount);
}
