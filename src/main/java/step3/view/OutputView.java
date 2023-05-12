package step3.view;

import step3.domain.Car;

import java.util.List;

public class OutputView {

    private static final String MOVE_MARK = "-";

    public static void eachRacingResult(List<Car> carList) {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            List<Integer> movingList = car.getMovingList();
            intToString(movingList, sb);
        }
        sb.append("\n");
        System.out.println(sb);
    }

    public static void intToString(List<Integer> movingList, StringBuilder sb) {
        for(int movement : movingList) {
            String str = MOVE_MARK.repeat(movement);
            sb.append(str);
        }
        sb.append("\n");
    }
}

