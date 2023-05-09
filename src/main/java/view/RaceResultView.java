package view;

import domain.Car;
import domain.CarName;
import domain.GameResult;
import domain.RaceResult;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RaceResultView implements ResultView {
    private final RaceResult raceResult;
    private final List<CarName> carNames;

    public RaceResultView(RaceResult raceResult, List<CarName> carNames) {
        this.raceResult = raceResult;
        this.carNames = carNames;
    }

    @Override
    public void print() {
        printTitle();
        printRaceResult();
    }

    private void printTitle() {
        System.out.println("실행 결과");
    }

    private void printRaceResult() {
        for (GameResult gameResult : raceResult.getGames()) {
            printGameResult(gameResult);
            System.out.println();
        }
        printWinners();
    }

    private void printGameResult(GameResult gameResult) {
        List<Car> cars = gameResult.getCars();
        for (int i = 0; i < cars.size(); i++) {
            printCar(cars.get(i), carNames.get(i));
            System.out.println();
        }
    }

    private void printWinners() {
        List<GameResult> gameResults = raceResult.getGames();
        List<Car> cars = gameResults.get(gameResults.size() - 1).getCars();
        List<String> winners = findWinner(cars);
        System.out.printf("%s가 최종 우승했습니다.\n", String.join(",", winners));
    }

    private List<String> findWinner(List<Car> cars) {
        int highestPosition = cars.stream().mapToInt(Car::getPosition).max().orElseThrow(NoSuchElementException::new);
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            addCarNameIfWinner(winners, cars, i, highestPosition);
        }
        return winners;
    }

    private void addCarNameIfWinner(List<String> winners, List<Car> cars, int index, int highestPosition) {
        if (cars.get(index).getPosition() == highestPosition) {
            winners.add(carNames.get(index).name());
        }
    }

    private void printCar(Car car, CarName carName) {
        System.out.printf("%s : ", carName.name());
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }
}
