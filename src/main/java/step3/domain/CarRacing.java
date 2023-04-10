package step3.domain;

import step3.view.InputView;
import step3.view.ResultView;

import java.util.ArrayList;
import java.util.Random;

public class CarRacing {
    private static final int NUM_RANDOM = 10;
    private static final Random rand = new Random();
    public static final InputView inputView = new InputView();
    public static final ResultView resultView = new ResultView();
    public ArrayList<Car> carList = new ArrayList<>();

    public void start() {
        int numCar = inputView.getNumCar();
        int numTry = inputView.getNumTry();
        resultView.ResultText();
        carRacing(createCarList(numCar), numTry);
    }

    public ArrayList<Car> createCarList(int numCar) {
        for (int i = 0; i < numCar; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    public void carRacing(ArrayList<Car> carList, int numTry) {
        for (int i = 0; i < numTry; i++) {
            for (Car car : carList) {
                resultView.showCarDistance(car.tryMove(rand.nextInt(NUM_RANDOM)));
            }
            System.out.println();
        }
    }
}
