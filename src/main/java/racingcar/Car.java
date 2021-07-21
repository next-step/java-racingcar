package racingcar;

import racingcar.ui.ResultView;

public class Car {
    private final int MOVE_NUM = 4;
    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(int randomNumber) {
        if(isMove(randomNumber)){
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public boolean isMove(int randomNumber) {
        if(randomNumber>=MOVE_NUM){
            return true;
        }
        return false;
    }
}
