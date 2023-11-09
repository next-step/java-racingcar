package step4.presentation;

import step4.controller.CarController;
import step4.domain.Car;
import step4.domain.Cars;
import step4.util.NumberUtil;

import java.util.Arrays;
import java.util.List;

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
            printCars(carController.getCars());
        }

        printWinners(carController.findWinners(numOfTry));
    }

    private void tryCarMoving(int numOfCars) {
        for (int carNo = 0; carNo< numOfCars; carNo++) {
            carController.moveCar(NumberUtil.createRandomNum(), carNo);
        }
    }

    private void printCars(Cars cars) {
        for (int i=0; i<cars.getNumOfCars(); i++) {
            Car car = cars.findCarBy(i);
            System.out.println(car.getCarName() + " : " + VIEW_OF_CAR.repeat(car.getCurrentPosition()));
        }

        System.out.println();
    }

    private void printWinners(List<String> winners) {
        int lastIdx = winners.size() - 1;

        for (int i = 0; i<lastIdx; i++) {
            System.out.print(winners.get(i) + ", ");
        }

        System.out.println(winners.get(lastIdx) + "가 최종 우승했습니다.");
    }
}
