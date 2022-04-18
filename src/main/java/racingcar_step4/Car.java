package racingcar_step4;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private int position;

    private String name;
    private List<Integer> positionHistory;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        this.positionHistory = new ArrayList<>();
    }

    public void move(int randomValue) {
        if (moveCondition(randomValue)) {
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

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
