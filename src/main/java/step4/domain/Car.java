package step4.domain;

public class Car {

    private final String DASH = "-";

    private String name;
    private int moveNumber;
    private StringBuilder distance = new StringBuilder();

    public String getName() {
        return name;
    }
    public String getDistance() {
        return distance.toString();
    }

    public Car(String name, int moveNumber) {
        this.name = name;
        this.moveNumber = moveNumber;
    }

    public void move(int randomNum) {
        if(randomNum >= moveNumber) {
            distance.append(DASH);
        }
    }
}
