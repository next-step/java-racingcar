package racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {
    private List<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.start();
    }

    private void start() {
        participateCars();
        play();
    }

    private void play() {
        int rounds = InputView.inputRounds();
        ResultView.printResultTitle();
        for (int i = 1; i <= rounds; i++) {
            playRound();
            announceRoundResult(i);
        }
        announceWinner();
    }

    private void announceWinner() {
        List<String> winnerNames = findWinners();
        ResultView.printWinners(winnerNames);
    }

    private List<String> findWinners() {
        int maxDistance = cars.stream().mapToInt(Car::getDistance).max().getAsInt();
        return cars.stream().filter(car -> car.getDistance() == maxDistance).map(car -> car.getName()).collect(Collectors.toList());
    }

    private void playRound() {
        for (Car car : cars) {
            car.run();
        }
    }

    private void participateCars() {
        List<String> carNames = generateCarNames();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private void announceRoundResult(int round) {
        ResultView.printRound(round);
        for (Car car: cars) {
            ResultView.printDistance(car.getName(), car.getDistance());
        }
        ResultView.printNewLine();
    }

    private List<String> generateCarNames() {
        String names = InputView.inputCarNames();
        return Arrays.asList(names.split(","));
    }
}
