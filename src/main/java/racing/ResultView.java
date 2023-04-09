package racing;

import static racing.Car.randomNumber;

public class ResultView {

    public static void resultCars(int carCount, int racingCount){
        String dash = "-";
        String[] count = new String[carCount];
        for (int i = 0; i < racingCount; i++) {
            for (int j = 0; j < carCount; j++) {
                if(i==0){
                    System.out.println(dash);
                    count[j] = dash;
                }

                if(i!=0){
                    int randomNumber = randomNumber();
                    if(randomNumber>5){
                        count[j] += dash;
                    }
                    System.out.println(count[j]);
                }
            }
            System.out.println("");
        }
    }
}
