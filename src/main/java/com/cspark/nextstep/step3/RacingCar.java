package com.cspark.nextstep.step3;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {

    public int race(List<Boolean> records) {
        String skidMark = records.stream()
                .filter(b -> b)
                .map(b -> "-")
                .collect(Collectors.joining());
        System.out.println(skidMark);

        return skidMark.length();
    }

}
