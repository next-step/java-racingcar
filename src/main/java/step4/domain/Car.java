package step4.domain;

import step4.ui.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Car {
    private String driverName;
    private int location = 1;

    public Car(String driverName) {
        this.driverName = driverName;
    }

    public static List<Car> ofCars(String inputNames) {
        return Arrays
                .stream(inputNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public String getDriverName() {
        return driverName;
    }

    public int getLocation() {
        return location;
    }

    public void goAhead(Accelerator accelerator) {
        this.location = accelerator.accelerate()
                ? ++this.location
                : this.location;
    }

    public void myState() {
        ResultView.racingRelay(this.driverName, this.location);
    }
}
