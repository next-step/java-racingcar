package step3.domain;

public class Car {

    private final String DASH = "-";
    private int moveNumber;
    private StringBuilder distance = new StringBuilder();

    public Car(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    public void move(int randomNum) {
        if(randomNum >= moveNumber) {
            distance.append(DASH);
        }
    }

    public String getDistance() {
        return distance.toString();
    }
}
