package racing.carRacing.view;

import racing.carRacing.Car;
import racing.carRacing.Cars;
import racing.carRacing.Count;

public class OutputView {
    public static final String MOVEMENT = "-";

    public static void printResultMention() {
        System.out.println("실행 결과");
    }

    public static void printCarsStatus(Cars cars) {
        for (int i = 0; i < cars.getCarsSize(); i++) {
            Car currentCar = cars.getCurrentCar(i);
            printCarStatus(currentCar);
        }
    }

    private static void printCarStatus(Car car) {
        for (int i = 0; i < car.getCurrentPosition(); i++) {
            System.out.print(MOVEMENT);
        }
        System.out.println();
    }

    public static void printTotalStage(Count count) {
        System.out.println("총 회수 :" + count);
    }

    public static void printRemainStage(Count count) {
        System.out.println("==================");
        System.out.println("남은 회수 :" + count);
    }

}
