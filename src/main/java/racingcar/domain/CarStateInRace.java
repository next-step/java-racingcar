package racingcar.domain;

public class CarStateInRace {

    private final static String STEP = "-";
    private final static int ZERO = 0;

    private String currentCarStatement;
    private final Car car;
    private final StringBuilder stringBuilder = new StringBuilder();

    public CarStateInRace(final Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public String getCurrentCarStatement() {
        return currentCarStatement;
    }

    public void storeCurrentCarState(final String result) {
        currentCarStatement = result;
    }
}
