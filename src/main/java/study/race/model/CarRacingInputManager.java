package study.race.model;

import study.race.view.ReceiveInputValue;

public class CarRacingInputManager {

    private final int LENGTH_LIMIT = 5;
    private final int IS_EXCEED = 1;
    private final int NOT_EXCEED = 0;
    private String[] carNames;
    private ReceiveInputValue receiveInputValue;
    private RaceInfo raceInfo;

    public CarRacingInputManager() {
        this.receiveInputValue = new ReceiveInputValue();
        this.raceInfo = new RaceInfo();
        this.getCarNames();
        this.getRoundOfTrack();
    }

    private void getCarNames() {
        String[] names;
        do {
            String namesOfCar = receiveInputValue.receiveInputValueForCarNames();
            names = namesOfCar.split(",");
        } while (hasOverLengthForCarNames(names));
        this.raceInfo.setCarNames(names);
    }

    private boolean hasOverLengthForCarNames(String[] names) {
        return countNumberOfNamesForOverLength(names) > 0;
    }

    private int countNumberOfNamesForOverLength(String[] names) {
        int exceedCount = 0;
        for (String name: names) {
            exceedCount += isExceeded(name);
        }
        return exceedCount;
    }

    private int isExceeded(String name) {
        if (name.length() > LENGTH_LIMIT) {
            System.out.println("The length of the car name '" + name + "' exceeds 5.");
            return IS_EXCEED;
        }
        return NOT_EXCEED;
    }

    private void getRoundOfTrack() {
        this.raceInfo.setRoundOfTrack(receiveInputValue.receiveInputValueForRound());
    }

    public RaceInfo getRaceInfo() {
        return this.raceInfo;
    }

}
