package domain;


public class Car {
    private final static int MOVE_BOUND = 4;
    private final static int MOVE_STEP = 1;

    private final CarName name;
    private final Position position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new Position(0);
    }

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new Position(position);
    }

    /**
     * 자동차를 앞으로 전진시킵니다.
     */
    public void move(int randomNo) {
        if (randomNo >= MOVE_BOUND) {
            this.position.add(MOVE_STEP);
        }
    }

    public int maxComparedTo(int maxScore) {
        return this.position.maxComparedTo(maxScore);
    }

    public String getName() {
        return name.getName();
    }

    public Boolean isSame(int input) {
        return this.position.isSame(input);
    }
}
