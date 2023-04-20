package view;

import domain.Car;
import domain.GameResult;
import domain.RaceResult;

public class RaceResultView implements ResultView {
    private final RaceResult raceResult;

    public RaceResultView(RaceResult raceResult) {
        this.raceResult = raceResult;
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
    }

    private void printGameResult(GameResult gameResult) {
        for (Car car : gameResult.getCars()) {
            printCar(car);
            System.out.println();
        }
    }

    private void printCar(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }
}
