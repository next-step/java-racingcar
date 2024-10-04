import domain.RacingCar;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameManagement {
    private List<RacingCar> cars;
    private int games;
    private RandomNumberGenerator randomNumberGenerator;

    public RacingCarGameManagement(
            List<String> names,
            int games,
            RandomNumberGenerator randomNumberGenerator
    ) {
        this.cars = new ArrayList<>(names.size());
        this.games = games;
        this.randomNumberGenerator = randomNumberGenerator;
        for (String name : names) {
            this.cars.add(new RacingCar(name));
        }
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public int getGames() {
        return games;
    }

    public void start() {
        ResultView.printIntroductionResult();
        while (this.games > 0) {
            games--;

            moveCars();
            ResultView.printResult(this.cars);
        }

        ResultView.printWinner(findWinner(this.cars));
    }

    public List<String> findWinner(List<RacingCar> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("cars must not be empty");
        }

        cars.sort(Comparator.comparing(RacingCar::getStatus));
        RacingCar winnerCar = cars.get(cars.size() - 1);
        return getWinners(cars, winnerCar.getStatus());
    }

    private List<String> getWinners(List<RacingCar> cars, int maxStatus) {
        return cars.stream()
                .filter(car -> car.getStatus() == maxStatus)
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private void moveCars() {
        for (RacingCar car : this.cars) {
            car.move(this.randomNumberGenerator.generate());
        }
    }

    public static void main(String[] args) {
        String[] split = InputView.getNames();
        int numberOfGames = InputView.getNumberOfGames();
        RandomNumberGeneratorImpl randomNumberGeneratorImpl = new RandomNumberGeneratorImpl();

        RacingCarGameManagement carGameManagement = new RacingCarGameManagement(Arrays.asList(split), numberOfGames, randomNumberGeneratorImpl);
        carGameManagement.start();
    }
}
