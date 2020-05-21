package step3;

import calculator.CalculatorSymbol;

import java.util.Random;

public final class Dice {

    private static Random random = new Random();

    public static int makeRandomNumber(){
        return  random.nextInt(10);
    }
}
