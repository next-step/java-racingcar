package car;

public class Car {
    private CarPosition carPosition;

    public Car(int distance) {
        this.carPosition = new CarPosition(distance);
    }

    public Integer getDistance() {
        return carPosition.getDistance();
    }

    public void game(int randomNumber) {
        if(isMovableForwardNumber(randomNumber)) {
            carPosition.incrementDistance();
        }
    }

    private boolean isMovableForwardNumber(int randomNumber) {
        return randomNumber >= 4;
    }


}
