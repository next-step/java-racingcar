package car;

import java.util.List;

public class Drive {
    private static final int MAXIMUM_RANDOM_NUMBER = 10;
    private static final int MINIMUM_NUMBER = 4;

    public int getMoveValue() {
        int randomNumber = (int) (Math.random() * MAXIMUM_RANDOM_NUMBER);
        if (randomNumber >= MINIMUM_NUMBER) return 1;
        return 0;
    }

    public void carDrive(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            int nowKm = cars.get(i).getKm();
            cars.get(i).setKm(nowKm + getMoveValue());
        }
    }
}
