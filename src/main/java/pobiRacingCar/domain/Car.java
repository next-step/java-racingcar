package pobiRacingCar.domain;

import java.util.Objects;
import java.util.Random;

public class Car {
    public static final int MAX_BOUND = 10;
    public static final int FORWARD_NUM = 4;
    private final String name;
    private int position = 0;

    public Car(final String name) { this.name = name.trim();
    }

    public int getPosition() { return position; }

    public String getName() { return name; }

    //move() getRandom 즉 Random 객체에 의존 : 아예 외부에서 고정값(int 등)전달받게 하라
    public void move(int randomNo) {
        if (randomNo >= FORWARD_NUM)
            this.position++;
    }
    /*
    public void move() {
        if (getRandomNo() >= FORWARD_NUM)
            this.position++;
    }
    */

    private int getRandomNo() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Car car = (Car) o;
        return position == car.position &&
                name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}



