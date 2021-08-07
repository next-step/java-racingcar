package race;

public class Car {

    private String distance;

    private final int STANDARD_NUM = 4;

    public Car(String input) {
        distance = input;
    }

    public void addDistance() {
        if (RandomNum.getRandomNum() > STANDARD_NUM)
            distance += "-";
    }

    public String getDistance() {
        return distance;
    }


}
