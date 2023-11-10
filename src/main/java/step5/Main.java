package step5;

import step5.util.Game;
import step5.util.MoveStrategy;
import step5.util.RandomValueGenerator;

public class Main {
    public static void main(String[] args) {
        final MoveStrategy randomValueGeneratorFromZeroToNine = new RandomValueGenerator();
        Game.start(randomValueGeneratorFromZeroToNine);
    }
}
