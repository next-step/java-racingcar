package racing_car.step03;

import java.util.Random;

public class Race {
    private Random r = new Random();
    private final int MIN_NUMBER = 4;
    private final int BORDER = 10;
    private final String DISTANCE_SYMBOL = "-";

    public void execute(String [] cars){
        for (int i=0; i<cars.length; i++){
          if (move(getRandomNumber())){
              cars[i] += DISTANCE_SYMBOL;
          }
        }
    }

    public boolean move(int random) {
        if (random >= MIN_NUMBER) return true;

        return false;
    }

    public int getRandomNumber(){
        return r.nextInt(BORDER);
    }
}
