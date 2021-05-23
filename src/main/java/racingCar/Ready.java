package racingCar;

public class Ready {
    private final String SPITE_VALUE = ",";

    public String[] createPlayerList(String name) {
        return name.split(SPITE_VALUE);
    }

    public boolean isGreaterThanFive(int number) {
        return number > 5;
    }

}
