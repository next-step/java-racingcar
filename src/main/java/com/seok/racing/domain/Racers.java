package com.seok.racing.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.seok.racing.utils.StringUtils.split;

public class Racers {

    private List<Racer> racers;

    public Racers(String racers) {
        this.racers = Arrays.stream(split(racers))
                .map(Racer::new)
                .collect(Collectors.toList());
    }

    protected Cars ready() {
        return new Cars(board());
    }

    private List<Car> board() {
        return racers.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

}
