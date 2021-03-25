package carRacing.view;

import carRacing.model.Cars;

public class OutputView {
    public void printRacingResultExcutedCycle(Cars cars, int cycle) {
        System.out.printf("try%2d.%n", cycle + 1);
        System.out.println(cars);
        System.out.println();
    }

    public void printRacingWinner(Cars cars) {
        System.out.printf("%s 가 최종 우승했습니다.%n", cars.getNameList());
    }

    public void printRacingResultTitle() {
        System.out.println("실행 결과");
    }
}
