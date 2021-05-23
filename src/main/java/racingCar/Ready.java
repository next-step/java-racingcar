package racingCar;

import java.util.List;

public class Ready {
    private final String SPERATE_VALUE = ",";

    public String[] createPlayerListByName(String name) {
        return name.split(SPERATE_VALUE);
    }

}
