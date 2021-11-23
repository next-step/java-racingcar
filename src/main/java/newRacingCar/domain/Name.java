package newRacingCar.domain;

public class Name {
    private final int MAX_NAME_LENGTH = 5;

    private String name;

    Name(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("차 이름은 5글자가 넘을 수 없습니다.");
        }

        this.name = name;
    }
}
