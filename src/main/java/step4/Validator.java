package step4;

public class Validator {
    private Validator() {}

    public static void checkCarName(String carName) {
        // 일단은 글자 수로만 예외 처리
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름이 5자를 초과하였습니다.");
        }
    }

    // 위와 같이 "자동차 이름", "시도 횟수"를 검증하는 메소드를 2개로 하는 것이 좋을까요? 아니면 오버로딩을 시키는 것이 더 깔끔할까요 ㅠ ??
    public static void checkTryCountIsMinus(int tryCount) {
        // 시도 횟수를 음수로만 예외 처리
        if (tryCount < 0) {
            throw new IllegalArgumentException("시도 횟수가 잘못되었습니다.");
        }
    }
}
