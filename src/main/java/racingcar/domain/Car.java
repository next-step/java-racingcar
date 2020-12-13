package racingcar.domain;

public class Car {
    private Position position = new Position();

    public void play(RandomNumber randomNumber) {
        if (randomNumber.movable()) {
            move();
        }
    }

    private void move() {
       this.position.add();
    }

    public int position() {
        return this.position.getPosition();
    }

    public boolean isMoved() {
        return this.position.isMoved();
    }
}
