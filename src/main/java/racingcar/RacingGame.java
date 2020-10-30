package racingcar;

public class RacingGame {
    private Memento memento;

    public RacingGame(Memento memento) {
        this.memento = memento;
    }

    public boolean checkNotGameOver() {
        int currTry = memento.getCurrTry();
        int maxTry = memento.getMaxTry();
        return currTry < maxTry;
    }

    // TODO: 테스트 코드 작성 필요
    public void play(RandomGenerator random) {
        if (!checkNotGameOver()) {
            return;
        }
        memento.increaseCurrTry();
        int carNum = memento.getCarNum();
        for (int carIdx = 0; carIdx < carNum; carIdx++) {
            int randomNum = random.getRandomNum();
            memento.moveCar(carIdx, randomNum);
        }
    }

}
