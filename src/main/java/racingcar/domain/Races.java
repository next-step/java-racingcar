package racingcar.domain;

import racingcar.rule.Rule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Races {

    private final List<Race> races;

    private Races() {
        this(new ArrayList<>());
    }

    private Races(List<Race> races) {
        this.races = new ArrayList<>(races);
    }

    public static Races newInstance(Cars cars, Rule rule, int count) {
        Races races = new Races();
        for (int i = 0; i < count; i++) {
            Race race = new Race(cars, rule);
            races.add(race);
        }

        return races;
    }

    public void add(Race race) {
        races.add(race);
    }

    public List<CarName> winners() {
        return lastLace().raceRecords().winners();
    }

    private Race lastLace() {
        return races.get(races.size() - 1);
    }

    public List<Race> getRaces() {
        return Collections.unmodifiableList(races);
    }
}
