package edu.nextstep.racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-23 23:51
 */
public class CarNames {

    private List<CarName> carNames;

    public CarNames(List<CarName> carNames) {
        this.carNames = new ArrayList<>(carNames);
    }

    public static CarNames of(List<String> names) {
        return new CarNames(names.stream()
                .map(CarName::new)
                .collect(Collectors.toList()));
    }

    public List<String> getNames() {
        return carNames.stream()
                .map(CarName::getName)
                .collect(Collectors.toList());
    }
}
