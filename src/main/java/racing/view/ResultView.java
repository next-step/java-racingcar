package racing.view;

import racing.domain.Cars;
import racing.domain.Winners;

public class ResultView {

    private static final String RESULT_DELIMITER = " : ";
    private static final String DASH = "-";

    public ResultView() {
        System.out.println("\n실행 결과\n");
    }

    public void printRaceResult(Cars cars) {
        cars.forEach(car -> System.out.println(car.getName() + RESULT_DELIMITER + DASH.repeat(car.getPosition())));

        System.out.println();
    }

    public void printRaceWinner(Cars cars) {
        System.out.println(Winners.from(cars) + "가 최종 우승했습니다.");
    }
}
