package domain;

import dto.RaceInfo;

import java.util.Random;

public class Race {
    private static final int RANDOM_RANGE = 10;
    private static final int RANDOM_DIVIDING_POINT = 4;

    private final NumberOfCars numberOfCars;
    private final NumberOfRaces numberOfRaces;

    public Race(RaceInfo raceInfo) {
        this.numberOfCars = raceInfo.getCarNumber();
        this.numberOfRaces = raceInfo.getRaceNumber();
    }

    public RaceResult calculate() {
        RaceResult raceResult = new RaceResult();
        GameResult gameResult = GameResult.createInitialGameResult(numberOfCars);

        raceResult.add(gameResult);
        for (int i = 0; i < numberOfRaces.getNumber(); i++) {
            GameResult nextGameResult = calculateNextGameResult(gameResult);
            raceResult.add(nextGameResult);
            gameResult = nextGameResult;
        }

        return raceResult;
    }

    private GameResult calculateNextGameResult(GameResult gameResult) {
        GameResult nextGameResult = GameResult.createCopy(gameResult);
        for (int j = 0; j < numberOfCars.getNumber(); j++) {
            nextGameResult.getCar(j).move(calculateMove() ? Position.ONE.getPosition() : Position.ZERO.getPosition());
        }

        return nextGameResult;
    }

    private boolean calculateMove() {
        Random ran = new Random();
        return ran.nextInt(RANDOM_RANGE) >= RANDOM_DIVIDING_POINT;
    }
}
