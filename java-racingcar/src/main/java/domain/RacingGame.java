package domain;

import view.ResultView;
import view.InputView;

import java.util.Random;
import java.util.function.Supplier;
import java.util.List;
import java.util.stream.Collectors;

import static view.InputView.getCarNames;

public class RacingGame {
    public static void main(String[] args) {

        List<String> carNames = InputView.getCarNames();
        int rounds = InputView.getNumberOfRounds();

        RacingGame game = new RacingGame(carNames,rounds,() -> new Random().nextInt(10));
        game.start();
        game.end();

    }

//    private final List<Car> cars;
    private final Cars cars;
    private final int rounds;
    private final Supplier<Integer> randomSupplier;


    public RacingGame(List<String> carNames, int rounds, Supplier<Integer> randomSupplier) {
        this.randomSupplier = randomSupplier;
        validateRounds(rounds);
        List<Car> carList = carNames.stream().map(Car::new).collect(Collectors.toList());
        this.cars = new Cars(carList);
        this.rounds = rounds;
    }

    private void validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("라운드 수는 1 이상이어야 합니다.");
        }
    }

    public void start() {
        ResultView.printResultLog();
        for (int i = 0; i < rounds; i++) {
            race();
            ResultView.printRoundResult(cars.getCars());
        }
    }

    public void end() {
        List<String> winners = cars.getWinners();
        ResultView.printWinners(ResultView.formatWinners(winners));

    }

    private void race() {
        cars.moveAll();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public String checkWinnerCar(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);

        List<String> winners = cars.stream()
                .filter(car -> car.getPosition().length() == maxPosition) // 가장 멀리 간 자동차 필터링
                .map(Car::getName) // 이름 가져오기
                .toList(); // 리스트로 변환

        return ResultView.formatWinners(winners);
    }

    private static int getMaxPosition(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(car -> car.getPosition().length())
                .max()
                .orElse(0); // 자동차가 없는 경우 기본값 0
        return maxPosition;
    }


}


