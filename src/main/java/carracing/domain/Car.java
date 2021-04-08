package carracing.domain;


import carracing.util.RandomUtil;

public class Car {

    private Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move(int randomNumber) {
        if (RandomUtil.win(randomNumber)) {
            position = new Position(getPosition() + 1);
        }
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
