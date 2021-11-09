package racingcar;

import java.util.Objects;

public class Info {
    private final String name;
    private final Makable makable;
    private final int step;

    public Info(String name, Makable makable) {
        this(name, makable, 0);
    }

    public Info(String name, Makable makable, int step) {
        this.name = name;
        this.makable = makable;
        this.step = step;
    }

    public boolean valid() {
        return makable.valid(name);
    }

    public int step() {
        return step;
    }

    public Info moved() {
        return new Info(name, makable, step + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return step == info.step && Objects.equals(name, info.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, step);
    }

    @Override
    public String toString() {
        return "Info{" +
                "name='" + name + '\'' +
                ", step=" + step +
                '}';
    }
}
