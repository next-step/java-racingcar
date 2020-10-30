/**
 * 클래스 이름: Memento
 * 버전 정보: 0.1
 * 날짜: 2020.10.30
 * 저작권 주의: 없음
 */

package racingcar;

/**
 * NOTE: 게임의 진행 상태를 독립적으로 관리하기 위해 Memento 클래스를 만들었다.
 * restore 기능이 요구사항에 없으므로, Originator 와 CareTaker 를 만들지 않았다.
 * 하지만 게임이라면 상식적으로 세이브와 로드 기능이 있으므로,
 * Memento 클래스를 따로 만든 것은 유용하다고 생각한다.
 */

public class Memento {
    private Car[] carArr;
    private int currTry;
    private int maxTry;

    public Memento(Car[] carArr, int tryNum) {
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

    // FIXME: stream 을 활용할 수는 없을까
    public int[] getCarPositions() {
        int carNum = this.carArr.length;
        int[] carPositions = new int[carNum];
        for (int i = 0; i < carNum; i++) {
            carPositions[i] = this.carArr[i].getPosition();
        }
        return carPositions;
    }
}
