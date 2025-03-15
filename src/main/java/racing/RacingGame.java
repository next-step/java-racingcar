package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    public static final int MAX_RANDOM_VALUE = 9; // random 최대값

    public static final int MIN_MOVE_VALUE = 4; // 전진하기 위한 최소값

    public static void main(String[] args) {
        int carCount = RacingGameInputView.getIntegerInput(GameMessage.CAR_COUNT_MESSAGE);
        int roundCount = RacingGameInputView.getIntegerInput(GameMessage.ATTEMPT_COUNT_MESSAGE);

        playRacingGame(carCount, roundCount);
    }

    // 레이싱 게임 진행 (자동차 리스트 생성 => RoundCount 만큼 라운드 진행)
    private static void playRacingGame(int carCount, int roundCount) {
        List<Car> cars = generateCars(carCount);

        RacingGameOutputView.printOutputHeadMessage();

        for (int i = 0; i < roundCount; i++) {
            playRound(cars);
            RacingGameOutputView.printRoundResult(cars);
        }
    }

    // 라운드 진행 (자동차 리스트 순회 => 전진 할 수 있다면 전진)
    private static void playRound(List<Car> cars) {
        for (Car car : cars) {
            if (isMovable(getRandomValue())) {
                car.move();
            }
        }
    }

    public static int getRandomValue() {
        return new Random().nextInt(MAX_RANDOM_VALUE);
    }

    public static boolean isMovable(int input) {
        return input >= MIN_MOVE_VALUE;
    }

    private static List<Car> generateCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        return cars;
    }

}
