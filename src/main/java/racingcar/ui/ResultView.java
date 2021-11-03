package racingcar.ui;

import racingcar.service.dto.Cars;

public class ResultView implements Output {
    private static final String DASH = "-";

    @Override
    public void output(int number, Cars cars) {
        System.out.println(String.format("%d 번째 경주", number));
        cars.getPositions().forEach(ResultView::print);
    }

    public static void print(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(DASH);
        }
        System.out.println();
    }
}
