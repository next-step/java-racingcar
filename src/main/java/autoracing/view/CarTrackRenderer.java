package autoracing.view;

import autoracing.domain.Car;

import java.util.Collections;
import java.util.Objects;

import static autoracing.domain.AssertUtils.assertNotNull;

public class CarTrackRenderer {
    private static final String NULL_CAR_SIGN = "carSign must be not null.";
    private static final String NULL_STARTING_LINE = "startingLine must be not null.";
    private static final String NULL_TRACE_SIGN = "traceSign must be not null.";

    private final String carSign;
    private final String startingLine;
    private final String traceSign;

    public CarTrackRenderer(String carSign, String startingLine, String traceSign) {
        assertNotNull(carSign, NULL_CAR_SIGN);
        assertNotNull(startingLine, NULL_STARTING_LINE);
        assertNotNull(traceSign, NULL_TRACE_SIGN);

        this.carSign = carSign;
        this.startingLine = startingLine;
        this.traceSign = traceSign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarTrackRenderer that = (CarTrackRenderer) o;
        return carSign.equals(that.carSign) &&
                startingLine.equals(that.startingLine) &&
                traceSign.equals(that.traceSign);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carSign, startingLine, traceSign);
    }

    public String render(Car car, int round, int maxNameSize) {
        return renderName(car.getName(), maxNameSize)
                + startingLine
                + renderTrace(car.getLocation(round).getDistance())
                + carSign;
    }

    private String renderName(String name, int maxNameSize) {
        return padLeft(name, maxNameSize, ' ');
    }

    private String renderTrace(int distanceFromStartingLine) {
        return String.join("", Collections.nCopies(distanceFromStartingLine, traceSign));
    }

    private String padLeft(String input, int length, char pad) {
        if (input.length() >= length) {
            return input.substring(0, length);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (stringBuilder.length() < length - input.length()) {
            stringBuilder.append(pad);
        }
        stringBuilder.append(input);

        return stringBuilder.toString();
    }
}
