package carracing.domain;


public class Car {

    private Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move(int randomNumber) {
        this.position.getPosition(randomNumber);
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public Name getName() {
        return this.name;
    }

    public boolean isWinner(int max) {
        return this.position.getPosition() >= max;
    }
}
