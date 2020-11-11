package racingcar.domain;

// 테스트를 위한 테스터 Motor
public class TesterImmobileMotor implements Motor {

    @Override
    public boolean isMovable() {
        return false;
    }
}
