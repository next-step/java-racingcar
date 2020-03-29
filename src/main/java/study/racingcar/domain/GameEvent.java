package study.racingcar.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameEvent implements Iterable<Cars> {
    private List<Cars> gameEvent;

    public GameEvent() {
        gameEvent = new ArrayList<>();
    }

    public void add(Cars cars) {
        gameEvent.add(cars);
    }

    public Cars getLastEvent() {
        return gameEvent.get(gameEvent.size() - 1);
    }

    public GameEvent clone() {
        GameEvent clonedGameEvent = new GameEvent();

        for (Cars cars : gameEvent) {
            clonedGameEvent.add(cars.clone());
        }

        return clonedGameEvent;
    }

    public int size() {
        return gameEvent.size();
    }

    @Override public Iterator<Cars> iterator() {
        return gameEvent.iterator();
    }
}
