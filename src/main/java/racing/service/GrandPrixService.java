package racing.service;

import racing.domain.GrandPrix;
import racing.domain.LineUp;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GrandPrixService {
    private static final Map<Integer, GrandPrix> grandPrixMap = new ConcurrentHashMap<>();

    public GrandPrix createGrandPrix(LineUp lineUp, int maxRounds) {
        GrandPrix grandPrix = new GrandPrix(lineUp, maxRounds);
        grandPrix.setId(grandPrixMap.size());
        grandPrixMap.put(grandPrix.getId(), grandPrix);
        return grandPrix;
    }

    public GrandPrix getGrandPrix(int id) {
        return grandPrixMap.get(id);
    }
}
