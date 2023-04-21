package study.carrace.step3.domain.exception;

public class IllegalCarPositionIndex extends RuntimeException {
    public IllegalCarPositionIndex(int moveStatusSize, int index) {
        super("특정 시점의 자동차 이동 여부 조회 시, 자동차 이동 시도 횟수(" + moveStatusSize + ")보다 작은 값을 인덱스로 사용해야 합니다: "
                + index);
    }
}
