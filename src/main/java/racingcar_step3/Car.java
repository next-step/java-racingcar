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

    public void move(int randomValue){
        if(moveCondition(randomValue)){
            this.position++;
        }
        positionHistory.add(this.position);
    }

    private boolean moveCondition(int randomValue) {
        return randomValue >= 4;
    }

    public List<Integer> getPositionHistory() {
        return positionHistory;
    }


}
