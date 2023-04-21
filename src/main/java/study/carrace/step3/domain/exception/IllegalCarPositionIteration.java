package study.carrace.step3.domain.exception;

public class IllegalCarPositionIteration extends RuntimeException {
    public IllegalCarPositionIteration(int moveStatusSize, int iteration) {
        super("자동차 위치 관련 조회 시, 자동차 이동 시도 횟수(" + moveStatusSize + ") 이하의 시도 순서를 인덱스로 사용해야 합니다: "
                + iteration);
    }
}
