package study.step3;

import java.util.Random;

public class RacingCar {

    static final int MOVE_POSSIBLE_NUMBER = 4;

    private int position = 0;

    public int getPosition() {
        return position;
    }

    public int getRandomNumber() {
        return new Random().nextInt(10);
    }

    public boolean movePossible(int number) {
        return number >= MOVE_POSSIBLE_NUMBER;
    }

    public int carMove(){
        this.position = this.position + 1;
        return this.position;
    }

    public void oneStep(){
        if(movePossible( getRandomNumber() )) {
            carMove();
        }
    }


}
