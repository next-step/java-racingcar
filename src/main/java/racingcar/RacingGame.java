/**
 * 클래스 이름: RacingGame
 * 버전 정보: 0.1
 * 날짜: 2020.10.30
 * 저작권 주의: 없음
 */

package racingcar;

public class RacingGame {
    private Memento memento;

    public RacingGame(Memento memento) {
        this.memento = memento;
    }

    public boolean checkNotGameOver() {
        int currTry = this.memento.getCurrTry();
        int maxTry = this.memento.getMaxTry();
        return currTry < maxTry;
    }

    // TODO: 테스트 코드 작성 필요
    public void play() {
        if (!this.checkNotGameOver()) {
            return;
        }
        this.memento.increaseCurrTry();
        int carNum = this.memento.getCarNum();
        for (int carIdx = 0; carIdx < carNum; carIdx++) {
            this.memento.moveCar(carIdx);
        }
    }

}
