package race;

import java.util.List;

public class Racing {

    private static Cars cars = new Cars();
    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();

    public static void main(String[] args) {
        racing(setCarList(setCarCount()), setTryCount());
    }

    public static int setCarCount() {
        inputView.printCar();
        return inputView.inputCar();
    }

    public static int setTryCount() {
        inputView.printTry();
        return inputView.inputTry();
    }

    public static List<Car> setCarList(int carCount) {
        return cars.createCar(carCount);
    }

    public static void racing(List<Car> carList, int tryCount) {
        resultView.printResult();

        for (int index = 0; index < tryCount; index++) {
            cars.decideForward(carList.size());
            resultView.showResult(carList);
            System.out.println();
        }
    }

}
