package racing;

import racing.view.InputView;
import racing.view.ResultView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    private List<Car> cars;
    private Random random = new Random();

    public RacingGame(List<Car> cars) {
        if (Objects.isNull(cars) || cars.isEmpty()) {
            throw new IllegalArgumentException("차 대수는 0 이상이야 합니다.");
        }

        this.cars = cars.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public RacingGame(String[] carNames) {
        this(Stream.of(carNames)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public void move() {
        cars.forEach(car -> car.moveForward(random.nextInt(10)));
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        Car winner = cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow(IllegalStateException::new);

        return cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String carNames = inputView.input("경주할 자동차 이름을 입력하세요(이름은 쉼표를(,) 기준으로 구분).");
        RacingGame racingGame = new RacingGame(carNames.split(","));

        int time = inputView.inputInt("시도할 회수는 몇 회 인가요?");

        System.out.println("실행 결과");

        for (int t = 0 ; t < time ; t++) {
            racingGame.move();
            resultView.printPositions(racingGame.getCars());
        }

        resultView.printWinner(racingGame.getWinners());
    }

}
