package racing;

import racing.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class RacingCarList {

    private List<RacingCar> racingCarList;

    public RacingCarList(List<RacingCar> racingCarList){
            this.racingCarList = racingCarList;
    }

    public static List<RacingCar> setRacingCars(String[] input, MoveStrategy strategy) {
        List<RacingCar> result = new ArrayList<RacingCar>();
        Arrays.stream(input).forEach( name -> result.add(new RacingCar(strategy, name)) );

        return result;
    }


    public void startRacing(int countOfRacing) {
        racingCarList.stream().forEach( racingCar -> racingCar.startRacing(countOfRacing));
    }

    public List<RacingCar> getRecingCarList() {
        return racingCarList;
    }
}
