package racingGame.domain;

import racingGame.strategy.NumberGenerateStrategy;

import java.util.Objects;

public class Car {

    private String name;
    private int position;

    public Car(String name){
        this(name, 0);
    }

    public Car(String name, int position){
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public void move(NumberGenerateStrategy numberGenerateStrategy){
        if(numberGenerateStrategy.NumberGenerate() >= 4){
            this.position++;
        }
    };

    public boolean isSamePosition(int position){
        return this.position == position;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "position=" + position +
                ", name='" + name + '\'' +
                '}';
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
        return Objects.hash(position, name);
    }
}
