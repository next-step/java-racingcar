package racing;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {
    private final List<Integer> locations = new ArrayList<>();

    public void addResult(final int location){
        locations.add(location);
    }
}
