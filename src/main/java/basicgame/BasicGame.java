package basicgame;


public class BasicGame {

    public final static String INPUT_ERROR_MESSAGE = "0이나 음수값은 입력하실 수 없습니다.";
    public final static int ZERO = 0;
    private final static String PROCESS_INDICATOR = "-";

    public Cars cars;
    public CarTryCounter triedCount;



    public BasicGame(Cars cars) {
        this.cars = cars;
    }

    public static void main(String args[]) {

        InputView.printCarInput();
        var carCount = InputView.countInput();

        InputView.printTryInput();
        var tryCount = InputView.countInput();

        Cars cars = new Cars();
        BasicGame basicGame = new BasicGame(cars);

        basicGame.startGame(carCount, tryCount);
    }

    public void startGame(int carCount, int tryCount) {
        triedCount = new CarTryCounter(ZERO);
        if (carCount <= 0 || tryCount <= 0) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }

        cars.initCar(carCount);
        printCar(tryCount);
    }

    private void printCar(int tryCount) {
        ResultView.printResultTitle();
        for (int i = 0; i < tryCount; i++) {
            cars.activeCar();
            ResultView.printResultList(cars.getCars(), PROCESS_INDICATOR);
            triedCount.autoIncrement();
        }
    }
}
