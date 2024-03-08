package racing;

import java.util.Iterator;

public class ResultView {

    public ResultView() {
        System.out.println("실행 결과");
    }

    public void printRaceResult(Cars cars) {
        Iterator<Car> iter = cars.iterator();
        iter.forEachRemaining(car-> System.out.println(car.carPosition()));

        System.out.println();
    }
}
