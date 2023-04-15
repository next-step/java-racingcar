package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingCarGame {
    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_RANGE = 10;
    public static final String MESSAGE_NEGATIVE_NUMBER_INPUT = "음수는 입력할 수 없습니다. input: %d";
    private List<Car> cars;
    private List<String> winners = new ArrayList<>();
    private int maxPosition;

    public RacingCarGame() {
        this.maxPosition = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        InputView.printCarsNamesInputMessage();
        String names = inputNames(scanner);
        InputView.printTryCountInputMessage();
        int tryCount = inputCount(scanner);

        cars = CarFactory.create(names);
        play(tryCount, random);
        findMaxPosition();
        determineWinners();

        ResultView.printResultHeader();
        ResultView.printCarsResult(cars);
        ResultView.printWinners(winners);
    }

    private void determineWinners() {
        for (Car car : cars) {
            determine(car);
        }
    }

    private void determine(Car car) {
        if (isWinner(car.position())) {
            winners.add(car.name());
        }
    }

    private boolean isWinner(int carPosition) {
        return maxPosition == carPosition;
    }

    private void findMaxPosition() {
        maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.position());
        }
    }

    private String inputNames(Scanner scanner) {
        return scanner.nextLine();
    }

    public int inputCount(Scanner scanner) {
        int count = Integer.parseInt(scanner.nextLine());
        if (count < 0) {
            throw new IllegalArgumentException(String.format(MESSAGE_NEGATIVE_NUMBER_INPUT, count));
        }
        return count;
    }

    private void play(int tryCount, Random random) {
        for (int i = 0; i < tryCount; i++) {
            moveCars(random);
        }
    }

    private void moveCars(Random random) {
        for (Car car : cars) {
            move(car, random);
        }
    }

    private void move(Car car, Random random) {
        if (isMovable(random)) {
            car.move();
        }
    }

    private boolean isMovable(Random random) {
        return random.nextInt(RANDOM_RANGE) >= MOVE_THRESHOLD;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<String> getWinners() {
        return winners;
    }
}
