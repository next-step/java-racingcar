package step3_racing_car.domain;

public class Name {
    private String value;
    private static final int LIMIT_LENGTH = 5;

    public Name(String value) {
        if(value.length() > LIMIT_LENGTH){
            throw new IllegalArgumentException("이름은 " + LIMIT_LENGTH + "자를 초과할 수 없습니다.");
        }
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
