package domain;

public class Car {

    private CarDistance carDistance;
    private CarName carName;

    public Car(String particapantName) {
        carDistance = new CarDistance();
        carName = new CarName(particapantName);
    }

    public void move(MovingStragey movingStragey) {
        carDistance.addCarDistance(movingStragey.carMove());
    }

    public int readCarDistance() {
        return carDistance.readCarDistance();
    }

    public String readParticipantName() {
        return carName.readCarName();
    }

}
