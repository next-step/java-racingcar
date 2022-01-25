package racinggame.domain;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private List<RacingCar> racingCars;
    private int trial;

    public RacingGame() {}

    public RacingGame(List<RacingCar> racingCars, int trial) {
        this.racingCars = racingCars;
        this.trial = trial;
    }

    public void start() throws IOException {
        for (int i = 0; i < trial; i++) {
            System.out.println("그만 하시려면 q, 계속하시려면 아무키나 입력해 주세요.");
            String input = Utils.getInput();

            if (isEnd(input)) {
                System.exit(0);
            }

            progress();
        }

        List<Integer> carPositions = getCarPositions();
        int max = Collections.max(carPositions);

        List<String> winners = getWinners(max);
        printWinners(winners);
    }

    private List<Integer> getCarPositions() {
        List<Integer> carPositions = racingCars.stream()
                .map(RacingCar::getPosition)
                .collect(Collectors.toList());

        return carPositions;
    }

    private List<String> getWinners(int max) {
        List<String> winners = racingCars.stream()
                .filter(car -> car.getPosition() == max)
                .map(RacingCar::getCarName)
                .collect(Collectors.toList());

        return winners;
    }

    private void printWinners(List<String> winners) {
        String result = winners.stream().collect(Collectors.joining(", "));
        System.out.println("최종 우승자: " + result);
    }

    private void progress() {
        racingCars.forEach(car -> {
            int randomValue = getRandomValue();
            if (canForward(randomValue)) {
                car.forward();
            }

            car.printCurrPosition();
        });
    }

    private boolean canForward(int randomValue) {
        return randomValue >= 4;
    }

    private boolean isEnd(String input) {
        return input.equals("q");
    }

    public int getRandomValue() {
        int random = (int) Math.floor(Math.random() * (9 - 0 + 1));
        return random;
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    public int getTrial() {
        return this.trial;
    }
}
