package study.step3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Car {

    private int location;

    private Car() {
        this.location = 0;
    }

    public static Car of() {
        return new Car();
    }

    public int getLocation() {
        return location;
    }

    public String getLocationString() {
        return Arrays.stream(new int[location])
                .mapToObj(location -> RacingConstant.DASH)
                .collect(Collectors.joining(RacingConstant.DELIMITER));
    }

    public Car move() {
        location++;
        return this;
    }
}
