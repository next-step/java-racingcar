package thirdstep.logic;

import lombok.Getter;
import java.util.ArrayList;


public class Car {

    private static final int thresHold = 4;

    @Getter
    private static final ArrayList<Car> carArrayList = new ArrayList<>();

    @Getter
    private final StringBuilder carLocation = new StringBuilder("-");

    public Car() {
        carArrayList.add(this);
    }

    public void carMove(int number) {
        if (number >= thresHold) {
            carLocation.append("-");
        }
    }
}
