package racingcar;

import racingcar.domain.CarName;
import racingcar.domain.Race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Races {

    private final List<Race> races;

    public Races() {
        this(new ArrayList<>());
    }

    public Races(List<Race> races) {
        this.races = new ArrayList<>(races);
    }

    public void add(Race race) {
        races.add(race);
    }

    public List<CarName> winners() {
        return lastLace().raceRecords().winners();
    }

    private Race lastLace() {
        Race lastRace = races.get(races.size() - 1);
        return lastRace;
    }

    public List<Race> getRaces() {
        return Collections.unmodifiableList(races);
    }
}
