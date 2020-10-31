/**
 * 클래스 이름: RacingGame
 * 버전 정보: 0.1
 * 날짜: 2020.10.30
 * 저작권 주의: 없음
 */

package racingcar;

public class RacingGame {
    private Car[] carArr;
    private int currTry;
    private int maxTry;

    public RacingGame(Car[] carArr, int tryNum) {
        this.carArr = carArr;

        this.currTry = 0;
        this.maxTry = tryNum;
    }

    public int getCarNum() {
        return this.carArr.length;
    }

    public int getCurrTry() {
        return this.currTry;
    }

    public int getMaxTry() {
        return this.maxTry;
    }

    public void increaseCurrTry() {
        this.currTry++;
    }

    public void moveCar(int carIdx) {
        this.carArr[carIdx].move();
    }

    public Car[] getCarArr() {
        return this.carArr;
    }

    public boolean checkNotGameOver() {
        return this.currTry < this.maxTry;
    }

    public void play() {
        if (!this.checkNotGameOver()) {
            return;
        }
        this.currTry++;
        for (int carIdx = 0; carIdx < this.carArr.length; carIdx++) {
            this.carArr[carIdx].move();
        }
    }
}
