package step3.presentation;

import step3.controller.CarController;
import step3.util.NumberUtil;

import java.util.Arrays;

public class RacingResultView {

    private static final String VIEW_OF_CAR = "-";

    private CarController carController;

    public RacingResultView() {
    }

    public RacingResultView(CarController carController) {
        this.carController = carController;
    }

    public void printCarRacing(int numOfTry) {
        System.out.println("실행 결과");

        int numOfCars = carController.getCars().getNumOfCars();
        for (int i=0; i<numOfTry; i++) {
            tryCarMoving(numOfCars);
            printCarPositions(carController.findPositions());
        }
    }

    private void tryCarMoving(int numOfCars) {
        for (int carNo = 0; carNo< numOfCars; carNo++) {
            carController.moveCar(NumberUtil.createRandomNum(), carNo);
        }
    }

    private void printCarPositions(int[] positions) {
        Arrays.stream(positions)
            .forEach(position -> System.out.println(VIEW_OF_CAR.repeat(position)));

        System.out.println();
    }
}
