package racing;

import java.util.Iterator;

public class ResultView {

    private static final String RESULT_DELIMITER = " : ";
    private static final String DASH = "-";

    public ResultView() {
        System.out.println("\n실행 결과\n");
    }

    public void printRaceResult(Cars cars) {
        Iterator<Car> iter = cars.iterator();
        iter.forEachRemaining(car -> System.out.println(car.getName() + RESULT_DELIMITER + DASH.repeat(car.getPosition())));

        System.out.println();
    }

    public void printRaceWinner(Cars cars) {
        System.out.println(cars.getWinnerList() + "가 최종 우승했습니다.");
    }
}
