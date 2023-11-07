package step3;

import java.util.Arrays;

public class RacingOutput {

    private static final String VIEW_OF_CAR = "-";

    public void askQuestionNumOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public void askQuestionNumOfTry() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
    }

    public void printCarRacing(int numOfTry, CarRacing carRacing) {
        System.out.println("실행 결과");

        for (int i=0; i<numOfTry; i++) {
            carRacing.moveCars();

            int[] positions = findPositions(carRacing);
            printCarPosition(positions);

            System.out.println();
        }
    }

    private int[] findPositions(CarRacing carRacing) {
        int numOfCar = carRacing.getCars().getNumOfCars();

        int[] positions = new int[numOfCar];
        for (int i=0; i<numOfCar; i++) {
            positions[i] = carRacing.getCars().findCarBy(i).getCurrentPosition();
        }

        return positions;
    }

    private void printCarPosition(int[] positions) {
        Arrays.stream(positions)
            .forEach(position -> System.out.println(VIEW_OF_CAR.repeat(position)));
    }
}
