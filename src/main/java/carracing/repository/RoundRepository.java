package carracing.repository;

import carracing.domain.Record;
import carracing.domain.Round;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RoundRepository {
    private final Map<Integer, Round> roundDatabase;
    private static int AUTOINCREMENT_INDEX = 1;

    public RoundRepository() {
        this.roundDatabase = new HashMap<>();
    }

    public List<Round> findAll() {
        return new ArrayList<>(roundDatabase.values())
            .stream()
            .sorted()
            .collect(Collectors.toList());
    }

    public Round findById(Integer roundId) {
        return roundDatabase.computeIfAbsent(roundId, (key) -> {
            throw new RuntimeException("Round " + key + " not found in Database");
        });
    }

    public Round save(Round round) {
        round.setId(AUTOINCREMENT_INDEX++);
        return roundDatabase.put(AUTOINCREMENT_INDEX, round);
    }
}
