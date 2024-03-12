package racingcar;

public class Car {
    private int distinct = 0;

    public int getDistinct() {
        return distinct;
    }

    public void move() {
        distinct +=1;
    }
}
