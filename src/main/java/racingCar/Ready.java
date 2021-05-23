package racingCar;

public class Ready {
    private final String SPITE_VALUE = ",";

    public String[] createPlayerList(String name) {
        return name.split(SPITE_VALUE);
    }

    public boolean isGreaterThanFive(int number) {
        return number > 5;
    }

    public String checkNameLength(String name) {
        if (isGreaterThanFive(name.length())) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5를 초과합니다.");
        }
        return name;
    }

}
