package step4;

public class Car {
    private static final int NAME_LENGTH = 5;

    private String name;
    private Position position;

    public Car(String name, Position position) {

        if(name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }

        this.name = name;
        this.position = position;
    }

    public void move() {
        position.move();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
    }
}
