public class Car {

    private final int MOVE_CONDITION = 4;

    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(int condition) {
        if (condition >= MOVE_CONDITION) {
            this.position++;
        }
    }

    public int getCurrentPosition() {
        return this.position;
    }

}
