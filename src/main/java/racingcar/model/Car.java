package racingcar.model;

public class Car {
    private final Integer name;
    public Integer getName(){
        return name;
    }

    private Integer distance;
    public Integer getDistance(){
        return distance;
    }

    public Car(Integer name, Integer distance){
        this.name = name;
        this.distance = distance;
    }

    public void move(){
        distance += 1;
    }
}
