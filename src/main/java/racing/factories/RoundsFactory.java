package racing.factories;

import racing.models.Rounds;

import java.util.ArrayList;

public class RoundsFactory {
    public static Rounds createFrom() {
        return new Rounds(new ArrayList<>());
    }
}
