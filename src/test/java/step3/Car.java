package step3;

import java.util.List;

public class Car {
    public List<Integer> movement;
    
    public void setPosition(boolean isMove) {
        this.movement.add(isMove ? 1 : 0);
    }
    
    public int getPosition(int round) {
        return this.movement.get(round);
    }
}
