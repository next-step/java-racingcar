package com.kkambi.racing.domain;

import java.util.Collections;
import java.util.List;

public class Winners {

    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public List<Car> getWinners() {
        return Collections.unmodifiableList(winners);
    }
}
