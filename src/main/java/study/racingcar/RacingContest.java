package study.racingcar;

public class RacingContest {

    private Cars cars;
    private final int tryNo;
    private int currentTry;

    public RacingContest(int racingParticipantNo, int tryNo) {
        cars = new Cars(racingParticipantNo);
        this.tryNo = tryNo;
        this.currentTry = 0;
    }

    public RacingContest(String racingParticipantByName, int tryNo) {
        cars = new Cars(racingParticipantByName);
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
        cars.moveAll();
        currentTry++;
    }
}
