package racinggame.domain;

import java.util.List;
import java.util.Random;

public class PlayRacingGame {

    public int makeRandomNumber(){
        Random random = new Random();
        int randomValue=random.nextInt(9);
        return randomValue;
    }

    public void move(List<Car> cars){
        for (Car car:cars) {
            int randomNumber = makeRandomNumber();
            if(randomNumber>=4){
                int location = car.getLocation();
                location++;
                car.setLocation(location);
            }
        }

    }

}
