package study;

import ui.ResultView;
import ui.InputView;

import java.util.Random;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.List;

class RacingGame {
    public static void main(String[] args) {
        int numberOfCars = InputView.getNumberOfCars();
        int rounds = InputView.getNumberOfRounds();
        RacingGame game = new RacingGame(numberOfCars, rounds, () -> new Random().nextInt(10)); // ✅ 랜덤 생성기 추가
        game.start();
    }

    private final List<Car> cars;
    private final int rounds;
    private final Supplier<Integer> randomSupplier;

    // 기본 생성자에서 Random Supplier 주입
    public RacingGame(int numberOfCars, int rounds) {
        this(numberOfCars, rounds, () -> new Random().nextInt(10)); // ✅ 랜덤 값 공급자 추가
    }

    // 의존성 주입 가능 (테스트 용도)
    public RacingGame(int numberOfCars, int rounds, Supplier<Integer> randomSupplier) {
        if (numberOfCars <= 0) {
            throw new IllegalArgumentException("자동차 대수는 1대 이상이어야 합니다.");
        }
        if (rounds <= 0) {
            throw new IllegalArgumentException("라운드 수는 1 이상이어야 합니다.");
        }

        this.randomSupplier = randomSupplier; // ✅ null이 아니라 Random을 받음
        this.cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car(this.randomSupplier)); // ✅ Car에 올바른 Supplier 전달
        }
        this.rounds = rounds;
    }

    public void start() {
        for (int i = 0; i < rounds; i++) {
            race();
            ResultView.printRoundResult(cars);
        }
    }

    private void race() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}


