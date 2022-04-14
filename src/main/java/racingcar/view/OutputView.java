package racingcar.view;

import racingcar.model.Cars;

public class OutputView {
    private OutputView() throws InstantiationException {
        throw new InstantiationException();
    }

    public static void outputStatus(Cars cars) {
        cars.getStatus().forEach(System.out::println);
        outputEmptyLine();
    }

    private static void outputEmptyLine() {
        System.out.println();
    }
}
