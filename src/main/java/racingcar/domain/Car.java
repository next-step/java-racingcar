package racingcar.domain;

public class Car {
    static final int LIMIT = 4;
    private int curPosition;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public int getCurPosition() {
        return this.curPosition;
    }

    public String getName() {
        return name;
    }

    public int move(int carNum) {
        if(carNum > LIMIT) {
            return ++this.curPosition;
        }
        return this.curPosition;
    }

    public String findWinner(int maxNum) {
        if(maxNum == this.curPosition) {
            return this.name;
        }
        return "";
    }

    public int compareNum(int number) {
        if(this.curPosition > number) {
            return this.curPosition;
        }
        return number;
    }
}
