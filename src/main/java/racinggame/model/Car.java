package racinggame.model;

import racinggame.util.RandomUtils;

public class Car {
    private String name;
    private int position;

    private static final int CAN_MOVE_NUMBER = 4;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }
    public Integer getPosition() {
        return position;
    }

    /**
     * 자동차를 랜덤 결과에 따라 움직이게 한다.
     * @param
     */
    public void moveCar() {
        if(isCarMove(RandomUtils.getRandom10())) {
            this.position++;
        }
    }

    /**
     * 자동차가 움직일 수 있는지 확인
     * @param number
     * @return
     */
    public boolean isCarMove(int number) {
        return number > CAN_MOVE_NUMBER;
    }

    /**
     * 자동차의 포지션 비교
     * @param position
     * @return
     */
    public boolean isSamePosition(int position) {
        return this.position == position;
    }
}