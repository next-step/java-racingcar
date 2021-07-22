package step4.view;

import step4.game.Game;
import step4.model.PointOfCar;
import step4.model.Winners;

import java.util.Comparator;
import java.util.List;

public class ResultView {
    private final String NAME_SEPARATOR = ",";

    private final Winners winners = new Winners();

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
        int maxPoint = distancesOfTime.stream()
            .max(Comparator.comparingInt(PointOfCar::getPoint))
            .map(PointOfCar::getPoint)
            .orElse(Integer.MAX_VALUE);

        distancesOfTime.forEach(pointOfCar -> checkWinner(pointOfCar, maxPoint));
    }

    private boolean gameDidNotStarted(Game game) {
        return game.countOfGame() == 0;
    }

    private void printWinner() {
        System.out.println(String.join(NAME_SEPARATOR, winners.getWinnerNames()) + "가 최종 우승했습니다.");
    }

    public void checkWinner(PointOfCar distanceOfTime, int maxPoint) {
        if (distanceOfTime.getPoint() >= maxPoint) winners.addWinner(distanceOfTime.getName());
    }

    public int getCountOfWinner() {
        return winners.size();
    }
}
