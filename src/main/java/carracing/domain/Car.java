package carracing.domain;

import java.util.Objects;

public class Car {
    private static final int MOVABLE_NUMBER = 4;
    private static final int INIT_POSITION = 0;

    private Name name;
    private int position;

    public Car(Name name, int position){
        this.name = name;
        this.position = position;
    }

    public Car(Name name) {
        this(name,INIT_POSITION);
    }

    public int getPosition() {
        return this.position;
    }

    public Name getName(){
        return this.name;
    }

    public void move(NumberGenerator numberGenerator) {
        int number= numberGenerator.generate();
        if(number > MOVABLE_NUMBER)
            this.position++;
    }

    public boolean samePosition(int position){
        return this.position==position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}
