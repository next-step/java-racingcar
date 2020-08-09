package racing.view;

import racing.Car;

public class ResultView {
    public static void print(Car[] cars) {
        System.out.println("실행결과");

        for (Car car : cars) {
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
