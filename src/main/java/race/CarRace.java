package race;

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
        return InputView.carCountInputOutput();
    }

    protected int setGameCount() {
        return InputView.gameCountInputOutput();
    }

    protected void playGame() {
        Cars carList = Cars.createCarList(carCount);
        for (int i = 0; i < gameCount; i++) {
            ResultView.printResult(
                    carList.moveCars(carList, new RandomNumCondition())
            );
        }
    }

}
