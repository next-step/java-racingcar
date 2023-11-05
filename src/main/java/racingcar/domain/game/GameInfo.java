package racingcar.domain.game;

public class GameInfo {
    private final CarInfo carInfo;
    private final RoundInfo roundInfo;

    public GameInfo(int carCount, int totalGameRound) {
        this.carInfo = new CarInfo(carCount);
        this.roundInfo = new RoundInfo(totalGameRound);
    }

    public int getCarCount() {
        return this.carInfo.getCarCount();
    }

    public boolean isEndGame() {
        return this.roundInfo.isEndGame();
    }

    public void increaseGameRound() {
        this.roundInfo.increaseRound();
    }
}
