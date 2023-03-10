package RacingCar;

import java.util.Random;

public class Car {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int DEFAULT_POSITION = 0;

    public String name;
    public int position;


    public Car(String name){
        this(name, DEFAULT_POSITION);
    }

    public Car(String name, int position) {

        validateName(name);
        this.name = name;
        this.position = position;

    }

    public void updatePosition(int randomcnt) {
        if(randomcnt > 4)
            position ++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int getRandomValue() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public void validateName(String name)
    {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 한다.");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

}
