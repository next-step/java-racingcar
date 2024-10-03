package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RacingGameResults implements Iterable<RacingGameResult> {
    private final List<RacingGameResult> results;

    public RacingGameResults() {
        this.results = new ArrayList<>();
    }

    public void add(final RacingGameResult result) {
        results.add(result);
    }

    public int size() {
        return results.size();
    }

    public RacingGameResult last() {
        return results.get(results.size() - 1);
    }

    @Override
    public Iterator<RacingGameResult> iterator() {
        return Collections.unmodifiableList(results).iterator();
    }
}
