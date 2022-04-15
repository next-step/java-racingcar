package view;

import constant.RacingCarSetting;
import helper.RandomHelper;
import model.Car;
import model.Cars;
import model.MovingRule;

public class ResultView {

    private final String PRINT_RESULT = "실행 결과";

    public void printMoveCarResult(Cars cars) {
        System.out.println(PRINT_RESULT);

        for (Car car : cars.getCars()) {
            int randomNumber = RandomHelper.makeRandomNumber(RacingCarSetting.RACING_DEFAULT_RANDOM_NUMBER_BOUND);
            car.move(new MovingRule(randomNumber));
            printCarPosition(car);
        }

        printLineBreak();
    }

    public void printCarPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        printLineBreak();
    }

    private void printLineBreak() {
        System.out.println();
    }
}
