package racingcar.view;

import java.util.List;

public class ResultView {

    private final List<CarStatus> carStatuses;

    private ResultView(List<CarStatus> carStatuses) {
        this.carStatuses = carStatuses;
    }

    public static ResultView result(List<CarStatus> carStatuses) {
        return new ResultView(carStatuses);
    }

    public void print() {
        for (CarStatus carStatus: carStatuses) {
            printWithUnderBar(carStatus);
        }

        System.out.println();
    }

    private void printWithUnderBar(CarStatus carStatus) {
        int grade = carStatus.grade();
        for (int idx = 0; idx < grade; idx++) {
            System.out.print("-");
        }

        System.out.println();
    }
}
