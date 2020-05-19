package step3;

import calculator.CalculatorSymbol;

import java.util.Random;

public final class Dice {

    private Dice() {
    }

    private static Dice dice = null;
    private static Random random = new Random();
    private static int randomNumber;

    public static Dice getInstance() {

        if (dice == null) {
            dice = new Dice();
        }
        return dice;
    }

    private static void makeRandomNumber(){
        randomNumber = random.nextInt(10);
    }

    public static boolean canGo(){
        makeRandomNumber();
        return randomNumber > 4? true : false;
    }
}
