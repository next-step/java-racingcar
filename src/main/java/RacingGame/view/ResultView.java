package RacingGame.view;

import RacingGame.RacingGame;
import RacingGame.domain.Car;
import RacingGame.domain.Cars;
import RacingGame.dto.CarDto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void viewGame(List<CarDto> racingCars){

        for (CarDto racingCar : racingCars){
            String printValue = new String(new char[racingCar.getLocation()]).replace("\0", "-");
            System.out.println(racingCar.getName()+" "+printValue);

        }

        System.out.println();

    }

    public static void viewWinner(List<String> winner){
        System.out.println("게임의 승자는 "
                +winner.stream()
        .collect(Collectors.joining(",")));
    }

}
