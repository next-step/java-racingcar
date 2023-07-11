package car.domain.model;

public final class Car implements Comparable<Car> {

    private final CarName carName;
    private Position position = new Position(0);


    public Car(final String carName) {
        this.carName = new CarName(carName);
    }

    public void move(final int randomNumber) {
        position = position.moveTo(randomNumber);
    }

    public boolean isWinner(final Car car) {
        return position.isSamePosition(car.position.getPosition());
    }

    public String getPosition() {
        return position.getTotalDistance();
    }

    public String getCarName() {
        return carName.getName();
    }

    @Override
    public int compareTo(Car otherCar) {
        return otherCar.position.getPosition() - position.getPosition();
    }
}
