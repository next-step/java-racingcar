package racing;

import java.util.Random;

public class ResultView {

    public static final String DASH = "-";
    public static final int FORWARD_COUNT = 5;

    public static void resultCars(int carCount, int racingCount){

        String[] count = new String[carCount];
        for (int i = 0; i < racingCount; i++) {
            resultCarCount(carCount, count);
        }
    }

    private static void resultCarCount(int carCount, String[] count) {
        for (int i = 0; i < carCount; i++) {
            extracted(count, i);
        }
    }

    private static void extracted(String[] count, int i) {
        Random random = new Random();
        if(random.nextInt(10) > FORWARD_COUNT){
            count[i] += DASH; //비즈니스 로직이므로 빼야함
        }
        System.out.println(count[i]);
    }
}
