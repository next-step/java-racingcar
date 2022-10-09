package step3_pobi.domain;

public class TimeBasedMovingStrategy implements MovingStrategy {

    // 시간관련으로 자동차가 움직이는 요구사항 추가되면 이런식으로 사용
    @Override
    public boolean movable() {
        return false;
    }
}
