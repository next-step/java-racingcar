package racing_game.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racing_game.domain.Distances;

public class SnapShot {

    private final List<Distances> holder;

    public SnapShot() {
        this.holder = new ArrayList<>();
    }

    public void capture(Distances distances) {
        holder.add(distances);
    }

    public List<Distances> get() {
        return Collections.unmodifiableList(holder);
    }

}
