package carracing.repository;

import carracing.domain.Round;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RoundRepository {

    private final AtomicInteger PRIMARY_KEY;

    private final Map<Integer, Round> roundDatabase;

    public RoundRepository() {
        this.PRIMARY_KEY = new AtomicInteger(1);
        this.roundDatabase = new HashMap<>();
    }

    public List<Round> findAll() {
        return new ArrayList<>(roundDatabase.values())
            .stream()
            .sorted()
            .collect(Collectors.toList());
    }

    public Round findById(Integer roundId) {
        return roundDatabase.get(roundId);
//        return roundDatabase.computeIfAbsent(roundId, (key) -> {
//            throw new RuntimeException("Round " + key + " not found in Database");
//        });
    }

    public void save(Round round) {
        round.setRoundId(PRIMARY_KEY.getAndIncrement());
        roundDatabase.put(round.getRoundId(), round);
    }

    public int count() {
        return roundDatabase.size();
    }
}
