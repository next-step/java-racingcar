package basicgame;


import util.StringUtil;

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
        var carString = InputView.stringInput();

        InputView.printTryInput();
        var tryCount = InputView.intInput();

        Cars cars = new Cars();
        BasicGame basicGame = new BasicGame(cars);

        basicGame.startGame(carString, tryCount);
    }

    public void startGame(String carString, int tryCount) {
        triedCount = new CarTryCounter(ZERO);

        var CarNameList = splitName(carString);
        if (CarNameList.length == 0 || StringUtil.isBlank(CarNameList[0]) || tryCount <= 0) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }

        cars.initCar(CarNameList);
        printCar(tryCount);
    }

    public String[] splitName(String carNames){
        return carNames.split(",");
    }

    private void printCar(int tryCount) {
        ResultView.printResultTitle();
        ResultView.printResultList(cars.getCars(), PROCESS_INDICATOR);
        for (int i = 0; i < tryCount; i++) {
            cars.activeCar();
            ResultView.printResultList(cars.getCars(), PROCESS_INDICATOR);
            triedCount.autoIncrement();
        }
    }
}
