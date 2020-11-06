package racing.view.to;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class RacingInputTO {
    private static final String DRIVER_SPLITTER = ",";
    private final List<String> drivers;
    private final int maxRounds;

    public RacingInputTO(List<String> drivers, int maxRounds) {
        this.drivers = drivers;
        this.maxRounds = maxRounds;
    }

    public RacingInputTO(String drivers, String maxRounds) {
        this.drivers = Arrays.asList(drivers.split(DRIVER_SPLITTER));
        this.maxRounds = Integer.parseInt(maxRounds);
    }
}

