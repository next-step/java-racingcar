package racing.view;

import racing.Cars;

public class OutputView {

    public static final String CAR_PROGRESS = "-";

    public static void output(Integer numberOfCar) {
        System.out.println("실행 결과");

        for (int i = 0; i < numberOfCar; i++) {
            System.out.println(CAR_PROGRESS);
        }
        System.out.println();

    }

    public static void outputProgress(Cars cars) {
        cars.getMoves()
            .forEach(move -> System.out.println(CAR_PROGRESS.repeat(move)));
        System.out.println();
    }

}
