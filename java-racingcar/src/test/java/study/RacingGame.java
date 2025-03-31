package study;

import ui.ResultView;
import ui.InputView;

import java.util.Random;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ui.InputView.getCarNames;

class RacingGame {
    public static void main(String[] args) {
//        int numberOfCars = InputView.getNumberOfCars();

        List<String> carNames = InputView.getCarNames();
        int rounds = InputView.getNumberOfRounds();

//        RacingGame game = new RacingGame(numberOfCars, rounds, () -> new Random().nextInt(10)); // ✅ 랜덤 생성기 추가
        RacingGame game = new RacingGame(carNames,rounds,() -> new Random().nextInt(10));
        game.start();
        game.end();

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

    public RacingGame(List<String> carNames, int rounds, Supplier<Integer> randomSupplier) {
        this.randomSupplier = randomSupplier;
        validateRounds(rounds);
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        this.rounds = rounds;
    }

    private void validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("라운드 수는 1 이상이어야 합니다.");
        }
    }

    public void start() {
        System.out.println("\n실행 결과.");
        for (int i = 0; i < rounds; i++) {
            race();
            ResultView.printRoundResult(cars);
        }
    }

    public void end() {
        String car = checkWinnerCar(cars);
        ResultView.printWinners(car);

    }

    private void race() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public String checkWinnerCar(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);

        return cars.stream()
                .filter(car -> car.getPosition().length() == maxPosition) // 가장 멀리 간 자동차 필터링
                .map(Car::getName) // 이름 가져오기
                .collect(Collectors.joining(", ")); // 이름을 쉼표로 구분하여 합침
    }

    private static int getMaxPosition(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(car -> car.getPosition().length())
                .max()
                .orElse(0); // 자동차가 없는 경우 기본값 0
        return maxPosition;
    }


}


