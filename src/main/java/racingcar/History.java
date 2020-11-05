package racingcar;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class History {
    private List<Memento> mementoList;

    public History() {
        mementoList = new LinkedList<>();
    }

    private History(List<Memento> mementoList) {
        this.mementoList = mementoList;
    }

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    public List<Memento> cloneMementoList() {
        List<Memento> mementoList = new LinkedList<>();
        for (Memento memento : mementoList) {
            mementoList.add(
                    memento.clone()
            );
        }
        return mementoList;
    }

    public List<Memento> getMementoList() {
        List<Memento> mementoList = cloneMementoList();
        return Collections.unmodifiableList(
                new LinkedList(mementoList)
        );
    }

    @Override
    public History clone() {
        List<Memento> mementoList = cloneMementoList();
        return new History(mementoList);
    }
}
