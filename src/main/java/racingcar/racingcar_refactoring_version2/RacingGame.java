package racingcar.racingcar_refactoring_version2;

public class RacingGame {
    private Race race;
    private int moveCount;
    private WinnerUtils winnerUtils;

    public RacingGame(String carNames, int moveCount) {
        this.moveCount = moveCount;
        this.race = new Race(carNames);
        this.winnerUtils = new WinnerUtils(this.race);
    }

    public void startRace() {
        for (int i = 0; i < moveCount; i++) {
            System.out.println((i + 1) + "번째횟수");
            race.run();
            printCarsDistance();
        }
        winnerUtils.topRankSearchAndPrint();
    }


    private void printCarsDistance() {
        for (Car car : race.getCars()) {
            printCarDistance(car);
        }
    }

    private void printCarDistance(Car car) {
        StringBuilder raceResult = new StringBuilder(car.getName() + " : ");
        for (int i = 0; i < car.getMovingDistance(); i++) {
            raceResult.append("-");
        }
        System.out.println(raceResult.toString());
    }


}

