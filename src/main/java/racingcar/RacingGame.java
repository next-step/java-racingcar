package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final int MAX_LANDOM_NUMBER = 10;

    public static void execute() {
        String beforeSplitCarsName = InputView.makeCarsName();
        List<String> afterSplitCarsName = splitCarsName(beforeSplitCarsName);

        int repeat = InputView.getCountOfRepeat();

        Cars cars = new Cars(afterSplitCarsName);
        System.out.println(ResultView.startResultMessage());

        for (int i = 0; i < repeat; i++) {
            cars.moveCars(randomNumber());
            ResultView.drawResult(cars);
        }

        ResultView.lastView(cars.carList());
    }

    //랜덤 값 나오는 메서드
    public static int randomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_LANDOM_NUMBER);
    }

    //자동차 이름 분리 및 예외처리
    public static List<String> splitCarsName(String carsName) {
        String[] cars = carsName.split(",");
        for (String car : cars) {
            if (car.length() > 6) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
            }
        }
        return Arrays.asList(cars);
    }
}
