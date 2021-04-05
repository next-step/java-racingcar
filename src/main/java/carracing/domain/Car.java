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

    @Override
    public String toString() {
        return name.toString() + " : " + position.toString();
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public String getName() {
        return this.name.toString();
    }
    public boolean isWinner(int max) {
        return this.position.getPosition() >= max;
    }
}
