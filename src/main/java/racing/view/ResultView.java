package racing.view;

import racing.car.Car;

public class ResultView {

    public static void startCycle(int carNumber, int count) {
        System.out.println("자동차" + carNumber + "대 " + count + "회");
        System.out.println("실행 결과");
    }

    public static void resultGoAndStop(Car car) {
        for (int j = 0; j < car.getPosition(); j++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void endCycle() {
        System.out.println("=========================");
    }
}
