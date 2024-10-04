package study.racing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultView {

    final static String FORWARD_DASH = "-";

    public static void resultView() {
        InputView inputView = new InputView();
        Car car = inputView.input();

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < car.getTryCount(); i++) {
            for(int j = 0; j < car.getCarCount(); j++) {
                int moveCount = RacingCar.goAndStop();
                map = RacingCar.addCountForDash(j, moveCount, map);
                printView(map);
            }
            System.out.println();
        }
    }

    private static void printView(Map<Integer, Integer> map) {
        for(int k = 0; k < map.size(); k++) {
            if(map.get(k) > 0) {
             System.out.print(FORWARD_DASH);
            }
        }
        System.out.println();
    }

}
