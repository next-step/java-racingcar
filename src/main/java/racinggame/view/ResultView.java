package racinggame.view;

import racinggame.common.util.PrintUtils;
import racinggame.vo.Car;

import java.util.Map;

public class ResultView {

    private static final StringBuffer sb = new StringBuffer();

    public static void resultPrint(Map<Integer, Car> carMap) {

        for (Integer carNumber : carMap.keySet()) {
            Car car = carMap.get(carNumber);
            sb.append(car.getName()).append(" : ").append("-".repeat(Math.max(0, car.getMoveCount())));
            PrintUtils.println(sb.toString());
            clearStringBuffer();
        }
        PrintUtils.println("");

    }

    private static void clearStringBuffer() {
        sb.setLength(0);
    }

}
