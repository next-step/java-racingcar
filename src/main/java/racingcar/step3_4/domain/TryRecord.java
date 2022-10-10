package racingcar.step3_4.domain;

import java.util.Objects;

public class TryRecord {

    private final String name;
    private final int position;

    public TryRecord(String name, int position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TryRecord tryRecord = (TryRecord) o;
        return position == tryRecord.position && name.equals(tryRecord.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
