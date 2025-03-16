
public class Car {

    private int position;

    private final static int RANDOM_BOUND = 10;
    private final static int MOVE_BOUND = 4;
    private final static int MOVE_STEP = 1;

    /**
     * 자동차를 앞으로 전진시킵니다.
     */
    public void move() {
        if (!validMove()) {
            return;
        }
        position += MOVE_STEP;
    }

    /**
     * @return
     * 랜덤 값이 유효한 값인지 확인합니다.
     */
    private boolean validMove() {
        int num = RandomUtil.nextInt(RANDOM_BOUND);
        return num >= MOVE_BOUND;
    }

    public int getPosition() {
        return position;
    }
}
