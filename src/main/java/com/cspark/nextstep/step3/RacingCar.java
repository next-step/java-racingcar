package com.cspark.nextstep.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {

    private List<Boolean> records;

    public RacingCar() {
        this.records = new ArrayList<>();
    }

    public int race(boolean isg) {
        records.add(isg);
        return recording();
    }

    private int recording() {
        String skidMark = records.stream()
                .filter(b -> b)
                .map(b -> "-")
                .collect(Collectors.joining());
        System.out.println(skidMark);

        return skidMark.length();
    }
}
