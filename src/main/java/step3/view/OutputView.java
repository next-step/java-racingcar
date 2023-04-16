package step3.view;

import step3.domain.Car;

import java.util.List;

public class OutputView {

    public static void eachRacingResult(List<Car> carList) {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            List<String> movingList = car.getMovingList();
            arrToString(movingList, sb);
        }
        sb.append("\n");
        System.out.print(sb);
    }

    public static void arrToString(List<String> movingList, StringBuilder sb) {
        for(String str : movingList) {
            sb.append(str);
        }
        sb.append("\n");
    }
}

