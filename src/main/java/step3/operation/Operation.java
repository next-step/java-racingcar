package step3.operation;

import java.util.Random;

public class Operation {

    public int[] makeRandomValue(int numOfCars) {
        Random random = new Random();
        int[] randomValue = new int[numOfCars];
        for(int i = 0; i < randomValue.length; i++) {
            randomValue[i] = random.nextInt(10);
        }
        return randomValue;
    }
    

}
