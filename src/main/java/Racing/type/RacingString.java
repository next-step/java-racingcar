package Racing.type;

import java.util.Objects;
import java.util.stream.Collector;

public class RacingString {
    static public final RacingString DELIMITER = new RacingString("\n");
    static private final String DISPLAY_TOKEN = "-";
    static public final RacingString DISPLAY_TOKEN_STRING = new RacingString(DISPLAY_TOKEN);
    private final String value;

    public RacingString(String input) {
        value = input;
    }

    public RacingString() {
        this("");
    }

    public RacingString(RacingString racingString) {
        this(racingString.value);
    }

    public static Collector<RacingString, RacingString, RacingString> joining() {
        return Collector.of(
                () -> new RacingString(),
                (racingString, input) -> racingString.concat(input),
                (racingString1, input1) -> racingString1.concat(input1),
                racingString2 -> new RacingString(racingString2)

        );
    }

    public static Collector<RacingString, ?, RacingString> joining(RacingString delimiter) {
        return Collector.of(
                () -> new RacingString(),
                (a, b) -> a.concat(delimiter).concat(b),
                (a, b) -> a.concat(delimiter).concat(b),
                racingString -> new RacingString(racingString)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingString that = (RacingString) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public RacingString repeat(RacingNumber times) {
        String repeat = value.repeat(times.parseInt());
        return new RacingString(repeat);
    }

    public RacingString concat(RacingString input) {
        return new RacingString(this.value + input.value);
    }

    @Override
    public String toString() {
        return value;
    }
}
