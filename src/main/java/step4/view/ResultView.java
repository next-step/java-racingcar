package step4.view;

import step4.game.Game;
import step4.model.PointOfCar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ResultView {
    private final List<String> winnerNames = new ArrayList<>();

    static public ResultView of() {
        return new ResultView();
    }

    public void showResult(Game game) {
        for (int i = 0; i <= game.countOfGame(); i++) {
            List<PointOfCar> pointOfCarsByTime = game.cars().getPointOfTime(i);
            pointOfCarsByTime.forEach(this::printPoint);
            printBorder();
        }

        setWinnerOfGame(game);
        printWinner();
    }

    private void printPoint(PointOfCar point) {
        System.out.print(point.getName() + " : ");
        for (int i = 0; i < point.getPoint(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void printBorder() {
        System.out.println("==========================");
    }

    public void setWinnerOfGame(Game game) {
        if (gameDidNotStarted(game)) return;

        List<PointOfCar> distancesOfTime = game.cars().getPointOfTime(game.countOfGame());
        int max = distancesOfTime.stream()
            .max(Comparator.comparingInt(PointOfCar::getPoint))
            .map(PointOfCar::getPoint)
            .orElse(Integer.MAX_VALUE);


        distancesOfTime.forEach(pointOfCar -> checkWinner(pointOfCar, max));
    }

    private boolean gameDidNotStarted(Game game) {
        return game.countOfGame() == 0;
    }

    private void printWinner() {
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }

    public void checkWinner(PointOfCar distanceOfTime, int max) {
        if (distanceOfTime.getPoint() >= max) winnerNames.add(distanceOfTime.getName());
    }

    public int getCountOfWinner() {
        return winnerNames.size();
    }
}
