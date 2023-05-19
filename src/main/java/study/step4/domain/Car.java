package study.step4.domain;

public class Car {

    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private int position = 1;

    public void move(){
        this.position += 1;
    }

}
