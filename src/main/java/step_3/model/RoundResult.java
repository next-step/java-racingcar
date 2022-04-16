package step_3.model;

import step_3.util.Behavior;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RoundResult {

    private final Map<String, Behavior> behaviorByRacingCarId;

    public RoundResult() {
        this.behaviorByRacingCarId = new HashMap<>();
    }

    public void record(String racingCarId, Behavior behavior) {
        this.behaviorByRacingCarId.put(racingCarId, behavior);
    }

    public void record(RoundResult roundResult) {
        this.behaviorByRacingCarId.putAll(roundResult.getBehaviorByRacingCarId());
    }

    public Map<String, Behavior> getBehaviorByRacingCarId() {
        return this.behaviorByRacingCarId;
    }

    public Set<String> getRacingCarIds() {
        return this.behaviorByRacingCarId.keySet();
    }

    public Behavior getBehavior(String racingCarId) {
        return this.behaviorByRacingCarId.get(racingCarId);
    }
}
