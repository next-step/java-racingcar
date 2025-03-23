package racingcar.domain;

public class Attempt {
    private int attempt;

    public Attempt(int attempt) {
        this.attempt = attempt;
        if(attempt <= 0){
            throw new IllegalArgumentException("자동차 경주 횟수는 0보다 큰값이어야 합니다.");
        }
    }

    public int getAttempt() {
        return attempt;
    }
}
