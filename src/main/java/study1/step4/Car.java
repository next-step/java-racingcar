package study1.step4;

import java.util.Objects;

public class Car {
    public final String racer;
    public int distance;

    public Car(String racer, int initialNumber){
        this.racer = racerValidate(racer);
        this.distance = initialNumber;
    }

    public void move(Decision generator){
        if(generator.moveDecision()){
            this.distance ++;
        }
    }

    public boolean isBestRacer(int highestScore){
        return highestScore == this.distance;
    }

    private String racerValidate(String racerName){
        if(Validator.inputValidate(racerName)){
            throw new IllegalArgumentException("자동차 이름이 올바르지 않습니다.");
        }
        return racerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return distance == car.distance &&
                Objects.equals(racer, car.racer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racer, distance);
    }
}
