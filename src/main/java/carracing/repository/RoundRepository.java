package carracing.repository;

import carracing.domain.Round;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RoundRepository {
    private final AtomicInteger primaryKeyGenerator;

    private final Map<Integer, Round> roundDatabase;

    public RoundRepository() {
        this.primaryKeyGenerator = new AtomicInteger(1);
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
    }

    public void save(Round round) {
        round.setRoundId(primaryKeyGenerator.getAndIncrement());
        roundDatabase.put(round.getRoundId(), round);
    }

    public int count() {
        return roundDatabase.size();
    }
}
