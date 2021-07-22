package racing_car.step03;

import java.util.Random;

public class Race {
    String[] cars;
    Random r = new Random();
    public String[] car(int count, int attempt) {
        cars = new String[count];
        for (int i = 0; i < attempt; i++) {
            for (int j = 0; j < count; j++) {
                int random = r.nextInt(10);
                if (random>=4){
                    cars[j] += "-";
                }
            }
        }
        return cars;
    }
}
