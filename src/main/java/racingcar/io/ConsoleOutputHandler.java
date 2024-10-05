package racingcar.io;

import racingcar.car.Car;
import racingcar.car.Cars;

import java.util.List;

public class ConsoleOutputHandler implements OutputHandler {


    @Override
    public void showCommentForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
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
            System.out.println(drawCurrentLocation(car));
        }
        System.out.println();
    }

    private StringBuilder drawCurrentLocation(Car car) {
        return new StringBuilder().append(car.getName()).append(" : ").append("-".repeat(Math.max(0, car.getCurrentLocation())));
    }

    @Override
    public void showWinnerOfRace(Cars cars) {
        printWinners(cars.getWinners());
    }

    private void printWinners(List<String> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        int winnersSize = winners.size();

        for (int i = 0; i < winnersSize; i++) {
            stringBuilder.append(winners.get(i));
            addComma(winnersSize, i, stringBuilder);
        }

        stringBuilder.append("가 최종 우승했습니다.");

        System.out.println(stringBuilder);
    }

    private void addComma(int winnersSize, int index, StringBuilder stringBuilder) {
        if (index < winnersSize - 1) {
            stringBuilder.append(", ");
        }
    }
}
