package racingcar.io;

import racingcar.car.Car;
import racingcar.car.Cars;

public class ConsoleOutputHandler implements OutputHandler {
    @Override
    public void showCommentForCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    @Override
    public void showCommentForTrialCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    @Override
    public void showExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    @Override
    public void showSimpleMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showTrialResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(drawCurrentLocation(car.getCurrentLocation()));
        }
        System.out.println();
    }

    private StringBuilder drawCurrentLocation(int currentLocation) {
        return new StringBuilder().append("-".repeat(Math.max(0, currentLocation)));
    }
}
