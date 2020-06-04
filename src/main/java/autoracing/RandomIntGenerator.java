package autoracing;

import java.util.Random;

@FunctionalInterface
public interface RandomIntGenerator {
    Random RANDOM = new Random();
    RandomIntGenerator DEFAULT_GENERATOR = RANDOM::nextInt;

    int generate(int bound);
}
