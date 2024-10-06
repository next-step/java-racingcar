package study.racing;

import java.util.Map;

public class ResultView {

    final static String FORWARD_DASH = "-";

    public static void printView(Map<Integer, Integer> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int j = 0; j < cars.size(); j++) {
            if(cars.get(j) > 0) {
                stringBuilder.append(FORWARD_DASH);
            }
        }
        stringBuilder.append("\n");
        System.out.print(stringBuilder);
    }

}
