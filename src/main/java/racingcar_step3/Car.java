package racingcar_step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {

    private int position;

    private List<Integer> positionHistory;

    public Car() {
        this.position = 0;
        this.positionHistory = new ArrayList<>();
    }

    public void run(){
        if(getRandomNum() >= 4){
            this.position++;
        }

        positionHistory.add(this.position);
    }

    public int getRandomNum() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public int getPosition() {
        return position;
    }

    public List<Integer> getPositionHistory() {
        return positionHistory;
    }
}
