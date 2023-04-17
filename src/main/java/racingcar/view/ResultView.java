package racingcar.view;

import racingcar.domain.Car;

public class ResultView {

    public void showCarsDistance(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            System.out.print("[" + cars[i].getName() + "] : ");
            drawLines(cars[i]);
        }
        System.out.println();
    }

    private void drawLines(Car cars) {
        for (int i = 0; i < cars.getDistance(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void showWinners(String[] winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}

