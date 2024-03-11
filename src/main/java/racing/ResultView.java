package racing;

import java.util.Iterator;

public class ResultView {


    public static final String RESULT_DELIMITER = " : ";

    public ResultView() {
        System.out.println("\n실행 결과\n");
    }

    public void printRaceResult(Cars cars) {
        Iterator<Car> iter = cars.iterator();
        iter.forEachRemaining(car-> System.out.println(car.getName() + RESULT_DELIMITER + car.carPosition()));

        System.out.println();
    }
}
