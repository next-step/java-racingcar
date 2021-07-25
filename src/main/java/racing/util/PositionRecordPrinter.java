package racing.util;

import racing.domain.Car;
import racing.view.PositionRecordView;

public class PositionRecordPrinter {

    public static void print(Car car, int index) {
        System.out.println(new PositionRecordView(car.getPlayerName(), car.getPositionRecord(index)).createView());
    }

}
