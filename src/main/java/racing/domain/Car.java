package racing.domain;

import org.apache.commons.lang3.StringUtils;

import static racing.common.Verify.checkArgument;

public class Car {

    private static final String INVALID_INPUT_MESSAGE = "car name cannot be null or empty";
    private static final String NAME_LEN_OVER_MESSAGE = "car name cannot exceed 5 characters: %s";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String name;
    private final CarContext context;
    private int distance;

    public Car(String name) {
        checkArgument(StringUtils.isNotBlank(name), INVALID_INPUT_MESSAGE);
        checkArgument(name.length() <= MAX_CAR_NAME_LENGTH, NAME_LEN_OVER_MESSAGE, name);
        this.name = name;
        context = new CarContext(this);
    }

    public void move() {
        distance++;
    }

    public int getMovedDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public CarContext getContext() {
        return context;
    }
}
