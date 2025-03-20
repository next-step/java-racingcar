
public class Car {

    private String name;
    private int position;

    private final static int RANDOM_BOUND = 10;
    private final static int MOVE_BOUND = 4;
    private final static int MOVE_STEP = 1;

    public Car(String name) {
        this.name = name;
    }

    /**
     * 자동차를 앞으로 전진시킵니다.
     */
    public void move() {
        int num = RandomUtil.nextInt(RANDOM_BOUND);
        if (num >= MOVE_BOUND) {
            position += MOVE_STEP;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
