package com.nextstep.racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class RaceRecord {
    private List<CarRecord> carRecords = new ArrayList<>();

    public void addCarRecord(CarRecord carRecord) {
        this.carRecords.add(carRecord);
    }

    public void forEach(Consumer<CarRecord> consumer) {
        carRecords.forEach(consumer);
    }
}
