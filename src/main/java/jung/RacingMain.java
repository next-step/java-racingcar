package jung;

import java.util.Arrays;

public class RacingMain {
    public static void main(String[] arr){
        CarName carname = new CarName();
        String[] names = carname.car_name();

        RacingGame game = new RacingGame();
        game.racingStart(names);
    }
}
