package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 초간단 자동차 경주 게임의 자동차 개체 하나를 나타냅니다.
 */
public class Car {
    /** 자동차가 움직이는 조건을 판단하는 데에 쓰이는 조건 판별 기준 상수 */
    private static final int MOVE_CONDITION = 4;

    /** 자동차의 현재 위치를 나타냅니다. */
    private int position = 0;
    private final Random random = new Random();

    /**
     * 초기 위치를 지정하여 자동차를 생성합니다.
     * @param initPosition 초기 위치. 0 이상이여야 합니다.
     */
    public Car(int initPosition) {
        validatePosition(initPosition);

        this.position = initPosition;
    }

    /**
     * 초기 위치가 1인 자동차를 생성합니다.
     */
    public Car() {
        this(1);
    }

    /**
     * 전부 기본값으로 값이 세팅된 자동차를 지정된 개수만큼 반환합니다.
     *
     * @param theNumberOfCars 생성할 자동차 개수
     *
     * @return 생성된 자동차 목록
     */
    public static List<Car> createDefaultCars(int theNumberOfCars) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < theNumberOfCars; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    /**
     * 자동차를 앞으로 또는 뒤로 움직입니다.
     *
     * @param distance 움직일 거리. 양수면 앞으로 이동, 음수면 뒤로 이동, 0이면 움직이지 않습니다.
     */
    public void move(int distance) {
        this.position += distance;

        validatePosition(this.position);
    }

    /**
     * 확률적으로 자동차를 앞으로 한 칸 움직입니다.
     */
    public void go() {
        if (trial()) {
            this.move(1);
        }
    }

    /**
     * 움직일지 말지 확률 시행 한 번.
     *
     * @return 시행 결과, true면 움직이는 것으로 결과나 나왔다는 뜻입니다.
     */
    private boolean trial() {
        return canIMove(random.nextInt(10));
    }

    /**
     * 주어진 moveSource에 대해 이 자동차가 움직일 조건을 만족했는지 반환합니다.
     *
     * @param moveSource 움직이는 조건을 만족했는지 검사할 외부의 소스값
     *
     * @return true면 이 자동차는 움직일 수 있다는 것을 의미합니다.
     */
    public boolean canIMove(int moveSource) {
        return moveSource >= MOVE_CONDITION;
    }

    // 이 이하로 validation 함수 모음
    private static void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 0 이상이어야 하지만 " + position + "이 되었습니다.");
        }
    }

    // 이 이하로 단순 getter 모음
    /**
     * 자동차의 현재 위치
     * @return 자동차의 현재 위치. 위치는 0 이상입니다.
     */
    public int getPosition() {
        return this.position;
    }

}
