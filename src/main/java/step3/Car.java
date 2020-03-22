package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    private int position;
    private List<Round> roundInfoList = new ArrayList<Round>();

    public static int generateRandomValue() {
        Random generator = new Random();

        int randomValue = generator.nextInt(10);
        ValidationUtils.validateRandomValue(randomValue);

        return randomValue;
    }
}
