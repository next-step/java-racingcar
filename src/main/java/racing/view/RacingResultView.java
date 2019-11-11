package racing.view;

import racing.model.Car;
import racing.model.Cars;

public class RacingResultView {

    private static final String EXECUTE_RESULT_MESSAGE = "%n실행 결과%n" ;
    private static final String WINNER_RESULT_MESSAGE = "%s가 최종 우승했습니다.%n";

    public RacingResultView() {
        System.out.printf(EXECUTE_RESULT_MESSAGE);
    }

    public void printRace(Cars racingCars) {
        int countOfCar = racingCars.countOfCars();
        for (int i = 0; i < countOfCar; i++) {
            printCar(racingCars.getCar(i));
        }
        System.out.println();
    }

    private void printCar(Car racingCar) {
        System.out.println(racingCar.printNameAndPosition());
    }

    public void printWinners(Cars racingCars) {
        System.out.printf(WINNER_RESULT_MESSAGE, racingCars.getWinners());
    }
}
