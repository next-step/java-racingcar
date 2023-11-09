package racing4.application;

import racing4.domain.Race4Car;
import racing4.view.ResultView;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race4Service {
    private final List<Race4Car> race4Cars;
    private final int tryCount;

    public Race4Service(List<Race4Car> race4Cars, int tryCount) {
        this.race4Cars = race4Cars;
        this.tryCount = tryCount;
    }

    public void playAndDisplay() {
        System.out.println();
        System.out.println("실행 결과");
        playGamesByRound();
        ResultView.printWinner(getWinnerNames());
    }

    private void playGamesByRound() {
        IntStream.range(0, this.tryCount)
                 .forEach(i -> playGame());
    }

    private void playGame() {
        int randomNumber = new Random().nextInt(10);
        race4Cars.forEach(car -> car.moveForwardByCondition(randomNumber));
        ResultView.displayGameResult(this.race4Cars);
    }

    private List<String> getWinnerNames() {
        return race4Cars.stream()
                        .filter(race4Car -> race4Car.isMaxPosition(getMaxPosition()))
                        .map(Race4Car::getName)
                        .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return race4Cars.stream()
                        .mapToInt(Race4Car::getPosition)
                        .max()
                        .orElse(0);
    }
}
