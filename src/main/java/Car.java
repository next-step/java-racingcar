public class Car {
    public static final int MOVE_STANDARD = 4;
    public static final int MOVE_DISTANCE = 1;
    private int position = 0;

    public void addPosition(int number) {
        if (number >= MOVE_STANDARD) {
            this.position +=MOVE_DISTANCE;
        }
    }
    public int getPosition() {
        return this.position;
    }
}
