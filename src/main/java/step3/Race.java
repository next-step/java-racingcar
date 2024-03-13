package step3;

import java.util.Random;

public class Race {

    public static int getRandomSingleDigitNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static String move(String position, int chance) {
        if (chance >= 4){
            position += "-";
        }
        return position;
    }

}