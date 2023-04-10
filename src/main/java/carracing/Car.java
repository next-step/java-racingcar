package carracing;

public class Car {
    private int carNumber;

    private Integer distance;

    public Car(int carNumber) {
        this.carNumber = carNumber;
    }

    public Car() {

    }

    public static void movingCondition(int nextInt) {

    }



    public void assignRandomDistance(int randomNumber) {
        this.distance = randomNumber;
    }

    public Integer getDistance() {
       return this.distance;
    }

    public Boolean isMovable() {
        if (distance < 4) {
            return false;
        }
        return true;
    }
}
