package racing.domain;

public class Car {

    public static final int MAX_LENGTH = 5;
    public static final int ZERO = 0;
    private int position = ZERO;
    private final String name;

    public Car(String name) {
        this.name = substringMaxLength(name);
    }

    public Car(String name, int initPosition) {
        this.position = initPosition;
        this.name = substringMaxLength(name);
    }

    private String substringMaxLength(String name) {
        if(name.length() > MAX_LENGTH){
            return name.substring(ZERO, MAX_LENGTH);
        }
        return name;
    }

    public int valueOfCurrentPosition() {
        return position;
    }

    public String valueOfName() {
        return name;
    }

    public int race(int randomNumber) {
        if(randomNumber > 3) {
            position++;
        }
        return position;
    }
}
