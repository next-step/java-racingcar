package racing.view;

import racing.domain.Car;
import racing.domain.CarGroup;
import racing.message.ViewMsg;

import java.util.stream.IntStream;

public class ResultView {
    public static void viewResultMsg() {
        System.out.println(ViewMsg.RESULT_VIEW_START.getMsg());
    }

    private static String getLocationVisualization(int location) {
        String result = "";
        for (int i = 0; i < location; i++) {
            result += "-";
        }
        return result;
    }

    private static void viewGameStatus(Car car) {
            System.out.println(car.getName() + " : " + getLocationVisualization(car.getLocation()));
    }

    public static void printVictory(String names) {
        System.out.println(names + ViewMsg.VICTORY_MSG.getMsg());
    }

    public static void nextRoundWithCarsStatus(CarGroup carGroup) {
        carGroup.getCarList().stream().forEach(car -> {
            car.run();
            viewGameStatus(car);
        });
        System.out.println(ViewMsg.END_LINE.getMsg());
    }
}
