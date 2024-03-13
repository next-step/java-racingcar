package race;

import java.util.List;

public class Racing {

    private static int carCount;
    private static int tryCount;
    private static List<Integer> carList;
    private static final String SIGN = "-";
    private static Cars cars = new Cars();
    private static ExtractRandom extractRandom = new ExtractRandom();
    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();

    public static void main(String[] args) {
        carCount = setCarCount();
        tryCount = setTryCount();
        carList = setCarList(carCount);

        racing(tryCount, carList);
    }

    public static int setCarCount() {
        resultView.printCar();
        return inputView.inputCar();
    }

    public static int setTryCount() {
        resultView.printTry();
        return inputView.inputTry();
    }

    public static List<Integer> setCarList(int carCount) {
        return cars.createCar(carCount);
    }

    public static void racing(int tryCount, List<Integer> carList) {
        resultView.printResult();

        for (int index = 0; index < tryCount; index++) {
            decideCarForward(carList.size());
            resultView.showResult(carList, SIGN);
            System.out.println();
        }
    }

    public static void decideCarForward(int carListSize) {
        for (int index = 0; index < carListSize; index++) {
            setForwardCount(index);
        }
    }

    public static void setForwardCount(int index) {
        if (cars.canForward(extractRandom.getRandomNumber())) {
            cars.addForward(index);
        }
    }

}
