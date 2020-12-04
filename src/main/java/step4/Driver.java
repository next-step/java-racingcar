package step4;

public class Driver {

    private Car car;

    public Driver(Car car) {
        this.car = car;
    }

    public void drive(int random) {
        car.move(random);
        printCarInfo();
    }

    private void printCarInfo() {
        System.out.println(car);
    }

    public int getDistanceSize() {
        return car.getDistance().length();
    }

    public String getCarName() {
        return car.getName();
    }
}
