package race;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static List<Integer> carList = new ArrayList<>();
    private static final int STANDARD = 4;

    public List<Integer> createCar(int number) {
        for (int i=0; i<number; i++) {
            carList.add(0);
        }
        return carList;
    }

    public boolean canForward(int number) {
        return number >= STANDARD;
    }

    public void addForward(int index) {
        carList.set(index, carList.get(index) + 1);
    }

}
