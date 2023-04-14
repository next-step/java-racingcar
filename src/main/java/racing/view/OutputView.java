package racing.view;

import racing.Cars;

public class OutputView {

    public static final String CAR_PROGRESS = "-";

    public static void basicOutput() {
        System.out.println("실행 결과");
    }

    public static void outputProgress(Cars cars) {
        cars.getCarDTOs()
            .forEach(carDTO -> System.out.println(CAR_PROGRESS.repeat(carDTO.getPosition())));
        System.out.println();
    }

}
