package race;

import java.util.ArrayList;

public class CarRace {

    private int carCount;

    private int gameCount;

    public CarRace() {
        this.carCount = setCarCount();
        this.gameCount = setGameCount();
    }

    //for test
    public CarRace(int carCount, int gameCount) {
        this.carCount = carCount;
        this.gameCount = gameCount;
    }

    public static void main(String[] args) {
        CarRace carRace = new CarRace();
        carRace.playGame();
    }

    protected int setCarCount() {
        return InputView.carRegisterInputOutput();
    }

    protected int setGameCount() {
        return InputView.gameCountInputOutput();
    }

    protected void playGame() {
        Cars cars = Cars.createCars(new ArrayList<Car>());
        for (int i = 0; i < gameCount; i++) {
            ResultView.printResult(
                    cars.moveCars(cars, new RandomNumCondition())
            );
        }
    }

}
