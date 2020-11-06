package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    public static final int HIGHER_THAN_WINNERS = 1;
    public static final int SAME_AS_WINNERS = 0;
    public static final int LOWER_THAN_WINNERS = -1;
    private final List<String> names;
    private Integer position;

    public Winners(List<String> names, Integer position) {
        this.names = new ArrayList<>(names);
        this.position = position;
    }

    public Winners() {
        this.names = new ArrayList<>();
        this.position = Car.INITIAL_POSITION;
    }

    public void checkNewPlayerRecord(String name, int position) {
        int result = compare(position);
        if (result == SAME_AS_WINNERS)
            names.add(name);
        if (result == HIGHER_THAN_WINNERS) {
            names.clear();
            names.add(name);
            this.position = position;
        }
    }

    private int compare(int position) {
        if (this.position > position)
            return LOWER_THAN_WINNERS;
        if (this.position == position)
            return SAME_AS_WINNERS;
        return HIGHER_THAN_WINNERS;
    }

    public List<String> getNames() {
        return new ArrayList<>(this.names);
    }

    public Integer getPosition() {
        return position;
    }
}
