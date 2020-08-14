package step3;

import java.util.Random;

public class ValueGenerator {
	
    private static final int MAX_RANDOM_VALUE = 9;

    public static int randomValue() {
        return new Random().nextInt(MAX_RANDOM_VALUE);
    }
    
}
