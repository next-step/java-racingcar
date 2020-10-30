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

    public Memento(int carNum, int tryNum) {
        this.carArr = new Car[carNum];
        for (int i = 0; i < carNum; i++) {
            carArr[i] = new Car();
        }

        this.currTry = 0;
        this.maxTry = tryNum;
    }

    public int getCarNum() {
        return carArr.length;
    }

    public int getCurrTry() {
        return currTry;
    }

    public int getMaxTry() {
        return maxTry;
    }

    public void increaseCurrTry() {
        currTry++;
    }

    public void moveCar(int carIdx, int randomNum) {
        carArr[carIdx].move(randomNum);
    }

    // FIXME: stream 을 활용할 수는 없을까
    public int[] getCarPositions() {
        int carNum = carArr.length;
        int[] carPositions = new int[carNum];
        for (int i = 0; i < carNum; i++) {
            carPositions[i] = carArr[i].getPosition();
        }
        return carPositions;
    }
}
