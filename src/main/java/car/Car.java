package car;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private List<Boolean> distance;
    private static final int RACING_CONDITION = 4;

    public Car() {
        distance = new ArrayList<>();
    }
    public boolean isMoveAble(int index) {
        if(index >= distance.size()) {
            return false;
        }
        return distance.get(index);
    }

    public void racing(RandomUtil randomUtil) {
        if(isMoveAble(randomUtil)) {
            distance.add(true);
            return;
        }
        distance.add(false);
    }

    private boolean isMoveAble(RandomUtil randomUtil) {
        return RACING_CONDITION <= randomUtil.generateRandomNumber();
    }
}
