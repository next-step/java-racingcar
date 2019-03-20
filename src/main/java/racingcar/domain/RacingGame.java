package racingcar.domain;

import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {

    private static final int RANDOM_BOUND = 10;
    private int time;
    private List<Car> cars;
    private String carNames;

    public RacingGame() {
    }

    public RacingGame(String carNames, int time) {
        this.time = time;
        this.carNames = carNames;
    }

    private static int randomValue() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND);
    }

    public List<Car> racing() {
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

    List<Car> sortByValue(List<Car> carList) {
        carList.sort((o1, o2) -> {
            if (o1.getPosition() < o2.getPosition()) return 1;
            return -1;
        });

        return carList;
    }

    public List<Car> getWinners(List<Car> cars) {
        sortByValue(cars);
        List<Car> winners = new ArrayList<>();
        Car winner = cars.get(0);

        for (Car car : cars) {
            checkWinner(car, winner, winners);
        }

        return winners;
    }

    private void checkWinner(Car car, Car winner, List<Car> winners) {
        if (car.isMaxPosition(winner)) {
            winners.add(car);
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
