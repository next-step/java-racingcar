package step3;

import java.util.Arrays;
import java.util.Random;

public class Racing {


    private final static String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private final static String GAME_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private final static int MOVE_NUMBER = 4;

    public static void main(String[] args) {

        InputView inputView = new InputView();
        int carCount = inputView.getCount(CAR_COUNT_MESSAGE);
        int gameCount = inputView.getCount(GAME_COUNT_MESSAGE);

        Validator.checkInput(carCount, gameCount);

        ResultView resultView = new ResultView();
        resultView.printGameResultText();

        Car[] cars = initCars(carCount);

        Random random = new Random();

        for(int i = 0; i < gameCount; i++) {
            Arrays.stream(cars)
                    .forEach(a -> {
                        a.move(random.nextInt(10));
                        resultView.printGameResult(a.getDistance());
                    });

            resultView.printNewLine();
        }
    }

    public static Car[] initCars(int carCount) {
        Car[] cars = new Car[carCount];

        for(int i = 0; i < carCount; i++) {
            cars[i] = new Car(MOVE_NUMBER);
        }

        return cars;
    }
}
