package race;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.Scanner;

public class CarRace {

    private final int carCount;

    private final int gameCount;

    protected CarRace(int carCount, int gameCount) {
        this.carCount = carCount;
        this.gameCount = gameCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getGameCount() {
        return gameCount;
    }

    public void initGame() {
        setGameProfile();
    }

    protected static CarRace setGameProfile() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCountInput = InputOutput.inputOutput();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int gameCountInput = InputOutput.inputOutput();
        return new CarRace(carCountInput, gameCountInput);
    }
}
