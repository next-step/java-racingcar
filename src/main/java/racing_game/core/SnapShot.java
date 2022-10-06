package racing_game.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SnapShot<T> implements Iterable<T> {

    private final List<T> holder;

    public SnapShot() {
        this.holder = new ArrayList<>();
    }

    public void capture(T t) {
        holder.add(t);
    }

    @Override
    public Iterator<T> iterator() {
        return holder.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        holder.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return holder.spliterator();
    }
}
