package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {

    private static final int CHECK_VALUE = 4;
    private static final int INCREASE_VALUE = 1;
    private static final int RANDOM_BOUND = 10;
    private int time = 0;
    private List<Car> carList;

    public RacingGame() {
    }

    public RacingGame(int time) {
        this.time = time;
        this.carList = new ArrayList<>();
    }

    void move(Car car, int randomValue) {
        if (checkMove(randomValue)) {
            int position = car.getPosition();
            car.setPosition(add(position));
        }
    }

    static int add(int carPosition) {
        return carPosition + INCREASE_VALUE;
    }

    static boolean checkMove(int value) {
        return value >= CHECK_VALUE;
    }

    private static int randomValue() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND);
    }

    private void racing() {
        ResultView resultView = new ResultView();

        for (Car car : carList) {
            int randomValue = randomValue();
            move(car, randomValue);
            resultView.showResult(car);
        }
    }

    private void initCarList(String cars) {
        String[] carNames = cars.split(",");
        for (String carName : carNames) {
            carList.add(new Car(carName.trim(), 0));
        }
    }

    List<Car> sortByValue(List<Car> carList) {
        carList.sort((o1, o2) -> {
            if (o1.getPosition() < o2.getPosition()) return 1;
            return -1;
        });

        return carList;
    }

    private List<String> getWinnerList(List<Car> carList) {
        List<String> winnerList = new ArrayList<>();
        Car winner = carList.get(0);
        int winnerPosition = winner.getPosition();
        winnerList.add(winner.getCarName());

        for (int i = 1; i < carList.size(); i++) {
            checkWinner(carList.get(i), winnerPosition, winnerList);
        }

        return winnerList;
    }

    private void checkWinner(Car car, int winnerPosition, List<String> winnerList) {
        int position = car.getPosition();
        if (winnerPosition == position) {
            winnerList.add(car.getCarName());
        }
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

        racingGame.sortByValue(racingGame.carList);
        List<String> winnerList = racingGame.getWinnerList(racingGame.carList);
        resultView.showWinner(winnerList);
    }
}
