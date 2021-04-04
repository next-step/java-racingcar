package RacingGame;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void viewGame(List<Car> racingCars){

        for (Car racingCar : racingCars){
            int racingCarAt = racingCar.isAt();
            String printValue = new String(new char[racingCarAt]).replace("\0", "-");
            System.out.println(racingCar.carName()+" "+printValue);

        }

        System.out.println();

    }

    public static void viewWinner(List<String> winner){
        System.out.println("게임의 승자는 "
                +winner.stream()
        .collect(Collectors.joining(",")));
    }

}
