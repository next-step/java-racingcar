package racing;

import java.util.Random;

public class ResultView {

    private static final Random RANDOM = new Random();

    public static final String DASH = "-";
    public static final int FORWARD_COUNT = 5;

    public static void resultCars(int carCount, int racingCount){

        String[] count = new String[carCount];
        for (int i = 0; i < racingCount; i++) {
            resultCarCount(carCount, count);
        }
        System.out.println();
    }

    private static void resultCarCount(int carCount, String[] count) {
        for (int j = 0; j < carCount; j++) {
            Random random = new Random();
            if(random.nextInt(10) > FORWARD_COUNT){
                count[j] += DASH; //비즈니스 로직이므로 빼야함
            }
            System.out.println(count[j]);
        }
    }

}
