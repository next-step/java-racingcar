package racingcar.domain;

import java.util.Objects;

public class State {

    private static final int DEFAULT_STATE = 0;
    private int state;

    public State() {
        this(DEFAULT_STATE);
    }

    public State(int state) {
        this.state = state;
    }

    public void increase() {
        this.state++;
    }

    public int getState() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;
        State state1 = (State) o;
        return state == state1.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }
}
