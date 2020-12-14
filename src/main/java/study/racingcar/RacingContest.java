package study.racingcar;

public class RacingContest {

    private Cars cars;
    private final int tryNo;
    private int currentTry;

    public RacingContest(String racingParticipantByName, int tryNo) {
        cars = new Cars(CarGenerator.generateByString(racingParticipantByName));
        this.tryNo = tryNo;
        this.currentTry = 0;
    }

    public RacingResult gerResult() {
        return cars.getResult();
    }

    public boolean isPlaying() {
        return currentTry < tryNo;
    }

    public void play() {
        cars.moveAll(new RandomMovingStrategy());
        currentTry++;
    }

    public WinnerResults findWinners() {
        return cars.findWinners();
    }
}
