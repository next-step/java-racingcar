package basicgame;


import java.util.List;

import basicgame.strategy.ActiveStrategy;
import basicgame.strategy.RandomActive;
import util.RandomUtil;
import util.StringUtil;

public class BasicGame {

    public final static String INPUT_ERROR_MESSAGE = "0이나 음수값은 입력하실 수 없습니다.";
    public final static int ZERO = 0;
    private final static String PROCESS_INDICATOR = "-";

    private final static int MAX_RANDOM = 10;

    public ActiveStrategy activeStrategy;
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

        basicGame.startGame(carString, tryCount, new RandomActive());
    }

    public void startGame(String carString, int tryCount, ActiveStrategy activeStrategy) {
        triedCount = new CarTryCounter(ZERO);
        this.activeStrategy = activeStrategy;

        var CarNameList = splitName(carString);
        if (CarNameList.length == 0 || StringUtil.isBlank(CarNameList[0]) || tryCount <= 0) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }

        cars.initCar(CarNameList);
        printCar(tryCount);
        printWinner(cars.getWinners());
    }

    public String[] splitName(String carNames){
        return carNames.split(",");
    }

    private void printCar(int tryCount) {
        ResultView.printResultTitle();
        ResultView.printResultList(cars.getCars(), PROCESS_INDICATOR);

        for (int i = 0; i < tryCount; i++) {
            cars.activeCar(activeStrategy);
            ResultView.printResultList(cars.getCars(), PROCESS_INDICATOR);
            triedCount.autoIncrement();
        }
    }

    private void printWinner(List<String> carList) {
        ResultView.printWinnerList(carList);
    }
}
