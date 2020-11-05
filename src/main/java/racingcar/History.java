package racingcar;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class History {
    private List<Memento> mementoList;

    public History() {
        mementoList = new LinkedList<>();
    }

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    public List<Memento> getMementoList() {
        return Collections.unmodifiableList(
          new LinkedList(mementoList)
        );
    }
}
