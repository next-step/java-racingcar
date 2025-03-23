package domain;

public class Car {

    private final static int RANDOM_BOUND = 10;
    private final static int MOVE_BOUND = 4;
    private final static int MOVE_STEP = 1;

    private final CarName name;
    private int position;

    public Car(String name) {
        this.name = new CarName(name);
    }

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = position;
    }

    /**
     * 자동차를 앞으로 전진시킵니다.
     */
    public void move(int randomNo) {
        if (randomNo >= MOVE_BOUND) {
            this.position += MOVE_STEP;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }
}
