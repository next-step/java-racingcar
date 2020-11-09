package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winners implements Comparable<Integer> {
    private final List<String> names;
    private Integer position;

    public Winners(List<String> names, Integer position) {
        this.names = new ArrayList<>(names);
        this.position = position;
    }

    public Winners() {
        this.names = new ArrayList<>();
        this.position = null;
    }

    public void checkPlayerRecord(String name, int position) {
        if (checkPlayerRecordIsFirst(name, position))
            return;

        checkPlayerRecordWithComparing(name, position);
    }

    private void checkPlayerRecordWithComparing(String name, int position) {
        checkPlayerRecordSame(name, position);
        checkPlayerRecordHigh(name, position);
    }

    private void checkPlayerRecordHigh(String name, int position) {
        int comparison = compareTo(position);
        if (comparison < 0) {
            addPlayerRecordWithReset(name, position);
        }
    }

    private void checkPlayerRecordSame(String name, int position) {
        int comparison = compareTo(position);
        if (comparison == 0) {
            names.add(name);
        }
    }

    private boolean checkPlayerRecordIsFirst(String name, int position) {
        if (this.position == null) {
            addPlayerRecordWithReset(name, position);
            return true;
        }

        return false;
    }

    private void addPlayerRecordWithReset(String name, int position) {
        names.clear();
        names.add(name);
        this.position = position;
    }

    public List<String> getNames() {
        return new ArrayList<>(this.names);
    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public int compareTo(Integer position) {
        return this.position.compareTo(position);
    }
}
