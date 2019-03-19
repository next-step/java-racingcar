package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {

    private static final int RANDOM_BOUND = 10;
    private int time = 0;
    private List<Car> cars;

    public RacingGame() {
    }

    public RacingGame(int time) {
        this.time = time;
        this.cars = new ArrayList<>();
    }

    private static int randomValue() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND);
    }

    private void racing() {
        ResultView resultView = new ResultView();

        for (Car car : cars) {
            int randomValue = randomValue();
            car.move(randomValue);
            resultView.showResult(car);
        }
    }

    private void initCarList(String carNames) {
        String[] carNamesArray = carNames.split(",");
        for (String carName : carNamesArray) {
            cars.add(new Car(carName.trim(), 0));
        }
    }

    List<Car> sortByValue(List<Car> carList) {
        carList.sort((o1, o2) -> {
            if (o1.getPosition() < o2.getPosition()) return 1;
            return -1;
        });

        return carList;
    }

    List<String> getWinners(List<Car> cars) {
        List<String> winnerList = new ArrayList<>();
        int winnerPosition = 0;

        for (Car car : cars) {
            winnerPosition = checkWinner(car, winnerPosition, winnerList);
        }

        return winnerList;
    }

    private int checkWinner(Car car, int winnerPosition, List<String> winnerList) {
        int maxPosition = car.isMaxPosition(winnerPosition);
        if (maxPosition > 0) {
            winnerList.add(car.getCarName());
            return maxPosition;
        }

        return winnerPosition;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String cars = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        String count = scanner.nextLine();

        RacingGame racingGame = new RacingGame(Integer.parseInt(count));
        ResultView resultView = new ResultView();

        racingGame.initCarList(cars);

        for (int i = 0; i < racingGame.time; i++) {
            racingGame.racing();
            System.out.println();
        }

        racingGame.sortByValue(racingGame.cars);
        List<String> winners = racingGame.getWinners(racingGame.cars);
        resultView.showWinner(winners);
    }
}
