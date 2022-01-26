package racingcar.domain;

import racingcar.controller.GameLauncher;
import racingcar.view.RacingCarOutput;

public class RacingCar {

    private static final int THRESHOLD = 4;
    private static final int NAME_MAX_SIZE = 5;
    private String name = "";
    private int position = 0;

    public RacingCar() {

    }

    public RacingCar(String name) {
        isValidLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(int randomNumber) {
        int randomNum = randomNumber;
        if (THRESHOLD <= randomNum) {
            position++;
        }
    }

    private void isValidLength(String name) {
        try {
            isCorrectNameSize(name);
        } catch (IllegalArgumentException e) {
            System.out.println(RacingCarOutput.ERROR_MESSAGE + e.getMessage());
            GameLauncher gameLauncher = new GameLauncher();
            gameLauncher.inputAll();
        }
    }

    public void isCorrectNameSize(String name) {
        if (NAME_MAX_SIZE < name.length()) {
            throw new IllegalArgumentException(RacingCarOutput.ERROR_CAR_NAME_LENGTH_MAX_FIVE);
        }
    }

    @Override
    public String toString() {
        return name + " : " + position;
    }
}
