package study;

public class RacingCar {
    private boolean[] distance;
    private int index;
    private int length;

    public RacingCar(int length) {
        this.index = 0;
        this.length = length;
        this.distance = new boolean[length];
    }

    public int getLength() {
        return this.length;
    }

    public int getIndex() {
        return this.index;
    }

    public void moveForward(boolean movement) {
        distance[index] = movement;
        if (index < length) { index++; }
    }
}
