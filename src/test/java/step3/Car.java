package step3;

import java.util.List;

public class Car {
    public List<Boolean> movement;
    
    public void setPosition(boolean isMove) {
        this.movement.add(isMove);
    }
    
    public boolean getPosition(int round) {
        return this.movement.get(round);
    }
}
