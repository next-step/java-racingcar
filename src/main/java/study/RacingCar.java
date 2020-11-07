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

    public boolean getDistanceByIndex(int index) {
        return this.distance[index];
    }

    public void moveForward(boolean movement) {
        if (index < length) {
            distance[index] = movement;
            index++;
        }
    }
}
