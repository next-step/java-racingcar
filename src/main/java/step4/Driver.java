package step4;

public class Driver {

    private Car car;

    public Driver() {
        this.car = new Car();
    }

    public void drive(int random) {
        car.move(random);
        printCurrentDistance();
    }

    public String getCarDistance() {
        return car.getDistance();
    }

    private void printCurrentDistance() {
        System.out.println(getCarDistance());
    }
}
