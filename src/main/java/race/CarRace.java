package race;

import java.util.ArrayList;

public class CarRace {

    private int gameCount;

    private String[] carNames;

    public CarRace() {
        this.carNames = setCarNames();
        this.gameCount = setGameCount();
    }

    //for test
    public CarRace(String[] carNames, int gameCount) {
        this.carNames = carNames;
        this.gameCount = gameCount;
    }

    public static void main(String[] args) {
        CarRace carRace = new CarRace();
        carRace.playGame();
    }

    protected String[] setCarNames() {
        return InputView.carRegisterInputOutput();
    }

    protected int setGameCount() {
        return InputView.gameCountInputOutput();
    }

    protected void playGame() {
        Cars cars = Cars.createCars(carNames, new ArrayList<Car>());
        for (int i = 0; i < gameCount; i++) {
            ResultView.printResult(
                    cars.moveCars(new RandomNumCondition())
            );
        }
    }

}
