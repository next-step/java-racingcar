package autoracing.view;

import autoracing.domain.Car;

import java.util.Collections;

public class CarTrackRenderer {
    private String carSign;
    private String startingLine;
    private String traceSign;

    public CarTrackRenderer(String carSign, String startingLine, String traceSign) {
        this.carSign = carSign;
        this.startingLine = startingLine;
        this.traceSign = traceSign;
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
