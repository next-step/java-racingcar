package Racing;

public class Stage {

  public StageStatus status;

  public CarList moveCars(CarList cars) {
    this.status = StageStatus.DONE;
    return cars.moveAllCar();
  }
}
