package step3.common.view;

import step3.common.util.PrintUtils;
import step3.common.vo.Car;

import java.util.Map;

public class ResultView {

    private static final StringBuffer sb = new StringBuffer();

    public static void resultPrint(Map<Integer, Car> carMap) {

        for (Integer carNumber : carMap.keySet()) {
            sb.append("-".repeat(Math.max(0, carMap.get(carNumber).getMoveCount())));
            PrintUtils.println(sb.toString());
            clearStringBuffer();
        }
        PrintUtils.println("");

    }

    private static void clearStringBuffer() {
        sb.setLength(0);
    }

}
