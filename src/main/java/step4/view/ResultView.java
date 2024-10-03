package step4.view;

import step4.vehicle.Car;

public class ResultView {
    private static final String EXECUTION = "\n실행 결과";
    private static final String ROUND_SEPARATION = "\n";

    public void printResultView() {
        System.out.println(EXECUTION);
    }

    public void separateRound() {
        System.out.println(ROUND_SEPARATION);
    }

    public void printCarLocation(int location) {
        for (int i = 0; i < location; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    public void printCarName(Car car) {
        System.out.print(car.getName() + " : ");
    }
}
