package racing.service;

import racing.domain.RaceMachine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RaceMachineService {
    private static final Map<Integer, RaceMachine> raceMachineMap = new ConcurrentHashMap<>();

    public RaceMachine create(RaceMachine raceMachine) {
        raceMachine.setId(raceMachineMap.size());
        raceMachineMap.put(raceMachine.getId(), raceMachine);
        return raceMachine;
    }

    public RaceMachine get(int id) {
        return raceMachineMap.get(id);
    }
}
