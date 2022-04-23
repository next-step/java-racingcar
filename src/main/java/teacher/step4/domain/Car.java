package teacher.step4.domain;

import java.util.Objects;

public class Car {

    private static final int FORWARD_NUM = 4;
//    private static final int MAX_BOUND = 10;

    private final String name;
    private Position position;

    // 테스트 코드를 위한 생성자를 추가 및 변경은 가능하다.
    // 테스트 코드 작성을 위한 메서드 추가는 절대 하면 안된다.
    public Car(final String name) {
        this(name, 0);
    }

    // 생성자 추가: 인자 수가 많은 부분에 적은 부분의 로직을 넘기고 생성자 정리
    public Car(String name, int position) {
        this(name, new Position());
    }

    public Car(String name, Position position) {
        if ("".equals(name) || name == null) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        this.name = name.trim();
        this.position = position;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name;
    }

    // 컴파일 에러 덜 생기게 하려면 과거의 코드와 내가 리펙터링하려고 하는 코드가 공존하도록 하면서 조금씩 갈아끼운다.
    // 지속적인 리펙터링의 동력은 과거의 코드와 리펙터링 하려고 하는 코드가 돌아가도록 되어있는 상태이다.

    // 서비스 레이어에 로직을 구현하지 않고 도메인 즉 모델 영역에 로직을 구현하기 위해서 노력해야 한다.
    public void move(int randomNo) {
        if (randomNo >= FORWARD_NUM) {
            //this.position++;
        }
    }

    public boolean isWinner(int maxPosition) {
        return position.isMaxPosition(maxPosition);
    }

    public int maxPosition(int maxPosition) {
        return position.maxPosition(maxPosition);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }

    // 상태를 가지는 도메인 객체인 경우 필요하다.
    // equals 와 hashcode는 항상 쌍으로 구하는 것이 맞다. 공부 필요
   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
