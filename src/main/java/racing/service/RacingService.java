package racing.service;

import racing.domain.GrandPrix;

import java.util.HashMap;
import java.util.Map;

public class RacingService {
    private static final Map<Integer, GrandPrix> grandPrixMap = new HashMap<>();

    public GrandPrix createGrandPrix(GrandPrix grandPrix) {
        grandPrix.setId(grandPrixMap.size());
        grandPrixMap.put(grandPrix.getId(), grandPrix);
        return grandPrix;
    }

    public GrandPrix getGrandPrix(int id) {
        return grandPrixMap.get(id);
    }
}
