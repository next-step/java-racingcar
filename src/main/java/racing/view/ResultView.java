package racing.view;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    private static final String COLON = " : ";
    private static final String PROGRESS = "-";
    private static final String BLANK = "";
    private static final String INFORMATION_FOR_RESULT = "실행결과";
    private static final String INFORMATION_FOR_WINNER = "가 최종 우숭했습니다.";

    public static void carStatus(Cars cars) {
        int size = cars.getSize();
        for (int i = 0; i < size; i++) {
            Car car = cars.getCar(i);
            System.out.println(car.getName() + COLON + PROGRESS.repeat(car.getPosition()));
        }
        System.out.println(BLANK);
    }

    public static void resultMessage() {
        System.out.println(BLANK);
        System.out.println(INFORMATION_FOR_RESULT);
    }
    
    public static void showWinner(Cars cars) {
        List<String> winnerNames = new ArrayList<>();
        int size = cars.getSize();
        for (int i = 0; i < size; i++) {
            winnerNames.add(cars.getCar(i).getName());
        }
        System.out.println(String.join(", ", winnerNames) + INFORMATION_FOR_WINNER);
    }
}
