package carracing;

import java.util.*;


public class CarRacing {

    public static void main(String[] args) {

        List<Integer> inputList = InputView.inputView();
        int carCnt = inputList.get(0);
        int tryCnt = inputList.get(1);

        List<Car> carList = new ArrayList<>();

        for(int i = 0; i < carCnt; i++) {
            carList.add(new Car());
        }

        ResultView.outMsg();
        for(int i = 0; i <tryCnt; i++) {
            race(carList);
            System.out.println("");
        }
    }

    private static void race(List<Car> carList) {
        for(Car car : carList) {
            car.move();
            ResultView.resultView(car.distance());
        }
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int toInt(String text) {
        return Integer.parseInt(text);
    }
}