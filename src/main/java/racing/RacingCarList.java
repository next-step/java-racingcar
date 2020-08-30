package racing;

import racing.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class RacingCarList {

    private List<RacingCar> racingCarList;

    public RacingCarList(String[] input, MoveStrategy strategy){
            this.racingCarList = RacingCarList.setRacingCars(input, strategy);
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

    public int getCountOfRacingCar() {
        return racingCarList.size();
    }

    public int getCountOfRacingRound() {
        return racingCarList.get(0).racingResult.length;
    }

    public ArrayList<String> getCarsOfWinnerName() {
        int temp = 0;
        int max = 0;
        ArrayList<String> result = new ArrayList<String>();
        for(int i=0;i<racingCarList.size();i++) {
            RacingCar racingCar = racingCarList.get(i);
            temp = racingCar.getRacingResult();

            if(temp==max) {
                result.add(racingCar.getName());
            }

            if(temp>max) {
                result.clear();
                result.add(racingCar.getName());
                max = temp;
            }

        }

        return result;
    }
}
