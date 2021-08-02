package CarRacing;

public class Position {

    private static final int FORWARD_NUM = 4;
    private int position = 0;


    public void increasePosition(int randomNum) {
        if (randomNum >= FORWARD_NUM) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
