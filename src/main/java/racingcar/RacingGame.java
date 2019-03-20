package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {

    private static final int RANDOM_BOUND = 10;
    private int time;
    private List<Car> cars;
    private String carNames;

    public RacingGame(String carNames, int time) {
        this.time = time;
        this.carNames = carNames;
    }

    private static int randomValue() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND);
    }

    private List<Car> racing() {
        if (cars == null) {
            initCarList(carNames);
        }

        for (Car car : cars) {
            int randomValue = randomValue();
            car.move(randomValue);
        }

        return cars;
    }

    private void initCarList(String carNames) {
        cars = new ArrayList<>();
        String[] carNamesArray = carNames.split(",");
        for (String carName : carNamesArray) {
            cars.add(new Car(carName.trim(), 0));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String cars = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        String count = scanner.nextLine();

        RacingGame racingGame = new RacingGame(cars, Integer.parseInt(count));
        ResultView resultView = new ResultView();
        List<Car> gameResult = null;

        for (int i = 0; i < racingGame.time; i++) {
            gameResult = racingGame.racing();
            resultView.showRaceResult(gameResult);
        }

        resultView.showWinner(gameResult);
    }
}
