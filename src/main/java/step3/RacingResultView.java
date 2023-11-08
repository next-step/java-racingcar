package step3;

import java.util.Arrays;

public class RacingResultView {

    private static final String VIEW_OF_CAR = "-";

    private CarRacing carRacing;

    public RacingResultView() {
    }

    public RacingResultView(CarRacing carRacing) {
        this.carRacing = carRacing;
    }

    public void printCarRacing(int numOfTry) {
        System.out.println("실행 결과");

        int numOfCars = carRacing.getCars().getNumOfCars();
        for (int i=0; i<numOfTry; i++) {
            tryCarMoving(numOfCars);
            printCarPositions(carRacing.findPositions());
        }
    }

    private void tryCarMoving(int numOfCars) {
        for (int carNo = 0; carNo< numOfCars; carNo++) {
            carRacing.moveCar(NumberUtil.createRandomNum(), carNo);
        }
    }

    private void printCarPositions(int[] positions) {
        Arrays.stream(positions)
            .forEach(position -> System.out.println(VIEW_OF_CAR.repeat(position)));

        System.out.println();
    }
}
