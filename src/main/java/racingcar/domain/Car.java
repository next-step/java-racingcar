package racingcar.domain;

public class Car {
    public boolean initParticipationNumber(int number) {
        if (number  <= 0) {
            throw new IllegalArgumentException("자동차 대수는 양수만 입력가능합니다");
        }
        return true;
    }

    public boolean initRepetitionCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("자동차 시도 횟수는 양수만 입력 가능합니다");
        }
        return true;
    }
}
