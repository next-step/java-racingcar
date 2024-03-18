package carRacingWinner.entity;

public class Car {

    String name;
    int location;

    public Car(String name) {
        if(name.length() > 5)
            throw new IllegalArgumentException("차량의 이름이 너무 깁니다.");
        this.name = name;
    }

    public void move() {
        location++;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
