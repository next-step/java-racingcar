package racingcar.domain.car;

public class Car {
    private final int INITIAL_VALUE = 0;
    private int status;

    public Car() {
        status = INITIAL_VALUE;
    }

    // 이 부분 질문 있습니다! : 생성자에 넣는 것이 좋을가요? 메서드에 넣는 것이 좋을까요?
    // 이전에 생성자에 만든 코드가 있는데 클래스를 여러개 생성할 때마다 주입해줘야 하는 작업을 했습니다.
    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            status++;
        }
    }

    public int getStatus() {
        return status;
    }

}
