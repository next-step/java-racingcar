package racing.service;

import racing.domain.GrandPrix;
import racing.domain.LineUp;

import java.util.HashMap;
import java.util.Map;

public class GranPrixService {
    private static final Map<Integer, GrandPrix> grandPrixMap = new HashMap<>();

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
