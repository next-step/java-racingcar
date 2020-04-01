package study.racingcar.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameEvent implements Iterable<Cars> {
    private List<Cars> gameEvent;

    public GameEvent() {
        this(new ArrayList<>());
    }

    public GameEvent(List<Cars> gameEvent) {
        this.gameEvent = gameEvent;
    }

    public GameEvent(GameEvent gameEvent) {
        this();

        for (Cars cars : gameEvent) {
            add(new Cars(cars));
        }
    }

    public void add(Cars cars) {
        gameEvent.add(cars);
    }

    public Cars getLastEvent() {
        return gameEvent.get(lastGameEventIndex());
    }

    public int size() {
        return gameEvent.size();
    }

    private int lastGameEventIndex() {
        return gameEvent.size() - 1;
    }

    @Override public Iterator<Cars> iterator() {
        return gameEvent.iterator();
    }
}
