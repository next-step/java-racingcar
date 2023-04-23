package racing.domain;

public class Name {

    private final int MAX_CAR_NAME = 5;

    private final String name;

    public Name(String name) {
        validateNameUnderFive(name);
        this.name = name;
    }

    private void validateNameUnderFive(String name) {
        if(name.length() > MAX_CAR_NAME){
            throw new IllegalArgumentException("자동차 이름은 다섯자리 이하만 가능합니다");
        }
    }

    public String getName() {
        return name;
    }
}
