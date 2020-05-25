package step3;

public class Car {

    private int position = 0;
    private final static int MINIMUM_CONDITIONS = 4;

    public void goPosition() {
        this.position += 1;
    }

    public int getPosition() {
        return this.position;
    }
    public boolean canGo(int number) {

        return number >= MINIMUM_CONDITIONS ? true : false;
    }

}
