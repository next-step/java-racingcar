package racingcar.domain;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Records implements Iterable<Record> {

    private final List<Record> records;

    public Records(List<Record> records) {
        this.records = records;
    }

    public Record getLast() {
        return records.get(records.size() - 1);
    }

    public Record get(int index) {
        return records.get(index);
    }

    public int size() {
        return records.size();
    }

    @Override
    public Iterator<Record> iterator() {
        return records.iterator();
    }

    @Override
    public void forEach(Consumer<? super Record> action) {
        records.forEach(action);
    }

    @Override
    public Spliterator<Record> spliterator() {
        return records.spliterator();
    }
}
