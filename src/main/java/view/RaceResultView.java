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
        System.out.println("실행 결과");
        for (GameResult gameResult : raceResult.getGames()) {
            for (Car car : gameResult.getCars()) {
                for (int i = 0; i < car.getLocation(); i++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
