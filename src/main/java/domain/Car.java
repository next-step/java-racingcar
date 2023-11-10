package domain;

import domain.type.CarName;
import domain.type.Position;

/**
 * 초간단 자동차 경주 게임의 자동차 개체 하나를 나타냅니다.
 */
public class Car {
    /** 사용자가 위치를 지정하지 않았을 때 기본 시작할 자동차의 위치 */
    private static final Position DEFAULT_INIT_POSITION = new Position(1);
    public static final int DEFAULT_MOVE = 1;
    public static final int MOVE_THRESHOLD = 4;

    /** 자동차의 현재 위치를 나타냅니다. */
    private Position position = DEFAULT_INIT_POSITION;

    /** 자동차의 이름 */
    private CarName name = CarName.anonymous();

    private Car() {
    }

    /**
     * 가장 기본적인 자동차를 생성합니다.
     * 익명 이름에 기본 위치로 지정됩니다.
     *
     * @return 생성된 자동차 객체
     */
    public static Car create() {
        Car car = new Car();

        car.position = DEFAULT_INIT_POSITION;
        car.name = CarName.anonymous();

        return car;
    }

    /**
     * 이름을 지정하여 자동차를 생성합니다.
     * 그 외의 값은 전부 기본값으로 지정됩니다.
     *
     * @param name 자동차 이름
     *
     * @return 생성된 자동차 객체
     */
    public static Car createWithName(CarName name) {
        Car car = Car.create();
        car.name = name;
        return car;
    }

    /**
     * 초기 위치를 지정하여 자동차를 생성합니다.
     * 그 외의 값은 전부 기본값으로 지정됩니다.
     *
     * @param position 자동차 초기 위치
     *
     * @return 생성된 자동차 객체
     */
    public static Car createWithPosition(Position position) {
        Car car = Car.create();
        car.position = position;
        return car;
    }

    /**
     * 자동차를 생성합니다.
     *
     * @param name 자동차 이름
     * @param position 자동차 위치
     * @return
     */
    public static Car create(CarName name, Position position) {
        Car car = Car.create();
        car.position = position;
        car.name = name;

        return car;
    }

    /**
     * 자동차를 앞으로 또는 뒤로 "강제로" 움직입니다.
     *
     * @param distance 움직일 거리. 양수면 앞으로 이동, 음수면 뒤로 이동, 0이면 움직이지 않습니다.
     */
    public void move(int distance) {
        this.position = this.position.add(distance);
    }

    /**
     * 전략에 따라 자동차를 앞으로 미리 지정된 만큼 움직입니다.
     *
     * @param decisionSeed 판단의 근거가 될 값입니다. 이 값에 무엇이 들어오는지에 따라 앞으로 가거나 말거나가 결정됩니다. 상위에서 랜덤값을 줄 수도 있습니다.
     */
    public void go(int decisionSeed) {
        if (decisionSeed >= MOVE_THRESHOLD) {
            this.move(DEFAULT_MOVE);
        }
    }

    // 이 이하로 단순 getter 모음
    public Position getPosition() {
        return this.position;
    }

    /**
     * @return 자동차의 이름
     */
    public CarName getName() {
        return this.name;
    }

}
