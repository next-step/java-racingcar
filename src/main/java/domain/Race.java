package domain;

import java.util.Random;

public class Race {
    private final CarNumber carNumber;
    private final RaceNumber raceNumber;

    public Race(RaceInfo raceInfo) {
        this.carNumber = raceInfo.getCarNumber();
        this.raceNumber = raceInfo.getRaceNumber();
    }

    public RaceResult calculate() {
        RaceResult raceResult = new RaceResult();
        GameResult gameResult = new GameResult(carNumber);

        raceResult.add(gameResult);
        for (int i = 0; i < raceNumber.getRaceNumber(); i++) {
            GameResult nextGameResult = calculateNextGameResult(gameResult);
            raceResult.add(nextGameResult);
            gameResult = nextGameResult;
        }

        return raceResult;
    }

    private GameResult calculateNextGameResult(GameResult gameResult) {
        GameResult nextGameResult = new GameResult(gameResult);
        for (int j = 0; j < carNumber.getCarNumber(); j++) {
            Random ran = new Random();
            nextGameResult.getCar(j).move(ran.nextInt(10) >= 4 ? 1 : 0);
        }

        return nextGameResult;
    }
}
