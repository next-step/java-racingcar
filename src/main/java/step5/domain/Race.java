package step5.domain;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    public Race(String[] carNames, int round) {
        List<CarRacer> carRacers = enroll(carNames);
    }

    private List<CarRacer> enroll(String[] carNames) {
        return Arrays.stream(carNames)
                .map(CarRacer::new)
                .collect(Collectors.toList());
    }
}
