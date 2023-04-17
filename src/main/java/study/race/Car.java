package study.race;

public class Car {

    private int moved = 0;

    public void move() {
        moved++;
    }

    public int getScore() {
        return moved;
    }

}
