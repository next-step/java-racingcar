package racing.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Rounds implements Iterable<Round> {
    private final List<Round> roundList;

    public Rounds() {
        this(new ArrayList<>());
    }

    public Rounds(List<Round> roundList) {
        this.roundList = roundList;
    }

    @Override
    public Iterator<Round> iterator() {
        return roundList.iterator();
    }

    @Override
    public void forEach(Consumer<? super Round> action) {
        roundList.forEach(action);
    }

    @Override
    public Spliterator<Round> spliterator() {
        return roundList.spliterator();
    }

    public void add(Round round) {
        roundList.add(round);
    }

    public int size() {
        return roundList.size();
    }

    public Round getLast() {
        if (roundList.isEmpty()) {
            return null;
        }
        return roundList.get(roundList.size() - 1);
    }
}
