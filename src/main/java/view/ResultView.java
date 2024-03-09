package view;

import domain.Car;

public class ResultView {

    private ResultView() {
    }

    public static void print(Car car) {
        for (int i = 0; i < car.position().getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
