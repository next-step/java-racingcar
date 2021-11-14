package Racing.stage;

import Racing.car.CarList;

public class Stage {

    public StageStatus status;

    public Stage() {
        status = StageStatus.READY;
    }

    public CarList moveCars(CarList cars) {
        this.status = StageStatus.DONE;
        return cars.moveAllCar(this);
    }
}
