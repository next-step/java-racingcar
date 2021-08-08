package step4.model;

public class Car {
    private Position position;
    private Name name;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public void go(){
        this.position.move();
    }
}
