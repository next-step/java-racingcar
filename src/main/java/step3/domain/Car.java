package step3.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Car {
    private final static String LOCATION_EXPRESSION = "-";
    private final static int START_LOCATION = 0;
    private Integer currentLocation;

    public Car() {
        this.currentLocation = START_LOCATION;
    }

    public void moveCar(Boolean isMove) {
        this.currentLocation = isMove ? ++this.currentLocation : this.currentLocation;
    }

    public Integer getCurrentLocation() {
        return this.currentLocation;
    }

    public Car(Integer location) {
        this.currentLocation = location;
    }

    public String getLocationView() {
        String result = "";
        for (Integer i = 0; i < this.currentLocation; i++) {
            result = result.concat(LOCATION_EXPRESSION);
        }
        return result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
