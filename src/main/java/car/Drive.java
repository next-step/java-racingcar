package car;

import java.util.List;

public class Drive {

    public int getMoveValue() {
        int randomNumber = (int) (Math.random() * 10);
        if (randomNumber >= 4) return 1;
        return 0;
    }

    public void carDrive(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            int nowKm = cars.get(i).getKm();
            cars.get(i).setKm(nowKm + getMoveValue());
        }
    }
}
