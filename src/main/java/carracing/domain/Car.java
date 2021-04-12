package carracing.domain;


import carracing.util.RandomUtil;

public class Car {

    private Name name;
    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(int randomNumber) {
        if (RandomUtil.win(randomNumber)) {
            position.move();
        }
    }

    public boolean isWinner(int max) {
        return position.isMaxPosition(max);
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public Name getName() {
        return this.name;
    }

}
