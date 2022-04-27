package study.step4.try2.domain;

public class NumberOfAttemps {
    private final int numberOfAttempts;

    // private 이지만 테스트를 위해 public 으로 변경
    public NumberOfAttemps(String userInputNumberOfAttempts) {
        if (!valid(userInputNumberOfAttempts)) {
            throw new IllegalArgumentException("0보다 큰 숫자를 입력해주세요.");
        }
        this.numberOfAttempts = Integer.parseInt(userInputNumberOfAttempts);
    }

    // of: 여러 매개변수를 받아 적합한 타입의 인스턴스를 반환하는 집계 메서드
    public static NumberOfAttemps of(String userInputNumberOfAttempts) {
        return new NumberOfAttemps(userInputNumberOfAttempts);
    }

    // private 이지만 테스트를 위해 public 으로 변경
    public boolean valid(String userInputNumberOfAttempts) {
        if (!userInputNumberOfAttempts.matches("[+]?\\d*(\\.\\d+)?")) {
            return false;
        }
        if (Integer.parseInt(userInputNumberOfAttempts) <= 0) {
            return false;
        }
        return true;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }
}
