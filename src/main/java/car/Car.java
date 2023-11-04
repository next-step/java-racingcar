package car;

public class Car {
    private Integer distance;

    public Car() {
        this.distance = 0;
    }

    public Integer getDistance() {
        return distance;
    }

    public void game(int randomNumber) {
        if(isMovableForwardNumber(randomNumber)) {
            this.distance += 1;
        }
    }

    private boolean isMovableForwardNumber(int randomNumber) {
        return randomNumber >= 4;
    }


}
