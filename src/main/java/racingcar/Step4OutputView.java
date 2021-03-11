package racingcar;

import java.util.List;

public class Step4OutputView implements OutputView {
    final String FORWARD = "-";
    final String CAR_NAME_POSTFIX = " : ";

    @Override
    public void printTitle() {
        final String TITLE = "실행 결과";
        System.out.println();
        System.out.println(TITLE);
    }

    @Override
    public void printSingleRacingResult(List<Car> cars) {
        cars.forEach(car -> {
            int distance = car.getDistance();
            System.out.print(car.getName() + CAR_NAME_POSTFIX);
            while (distance-- != 0) {
                System.out.print(FORWARD);
            }
            System.out.print('\n');
        });
        System.out.print('\n');
    }

    @Override
    public void printWinners(List<String> winnersName) {
        if (winnersName.isEmpty()) return;

        System.out.print(winnersName.get(0));
        for (int i = 1; i < winnersName.size(); i++) {
            System.out.print(", ");
            System.out.print(winnersName.get(i));
        }
        System.out.print("가 최종 우승했습니다.\n");
    }
}
