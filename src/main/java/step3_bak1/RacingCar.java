package step3_bak1;

import java.util.Random;

public class RacingCar {

    public static final int LIMIT = 4;
    public static final String MARK = "-";
    public static final int RANDOM_LIMIT = 10;

    public void racingCar(String[][] races){
        for (String[] car : races) {
            oneCarRace(car);
        }
    }

    private void oneCarRace(String[] car) {
        for (int i = 0; i< car.length; i++){
            car[i] = hyphenOrNot(isValueMoreThan(randomValue()));
        }
    }

    public boolean isValueMoreThan(int value) {
        return value >= LIMIT;
    }
    public int randomValue() {
        Random random = new Random();
        int value = random.nextInt(RANDOM_LIMIT);
        return value;
    }

    public String hyphenOrNot(boolean input) {
        if(input == true){
            return MARK;
        }
        return "";
    }
}
