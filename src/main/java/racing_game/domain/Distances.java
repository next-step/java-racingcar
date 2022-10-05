package racing_game.domain;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import racing_game.core.Positive;

public class Distances implements Iterable<Positive> {

    private final List<Positive> holder;

    private Distances(List<Positive> distances) {
        this.holder = distances;
    }

    public static Distances create(List<Positive> distances) {
        return new Distances(distances);
    }

    @Override
    public Iterator<Positive> iterator() {
        return holder.iterator();
    }

    @Override
    public void forEach(Consumer<? super Positive> action) {
        holder.forEach(action);
    }

    @Override
    public Spliterator<Positive> spliterator() {
        return holder.spliterator();
    }
}
