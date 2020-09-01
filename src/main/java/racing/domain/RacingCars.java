package racing.domain;

import racing.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class RacingCars {

    private List<RacingCar> racingCars;
    private int countOfRacingCar;

    public RacingCars(List<RacingCar> racingCars){
        this.racingCars = racingCars;
        this.countOfRacingCar = racingCars.size();
    }
    public static RacingCars of(List<RacingCar> racingCars) {
        return new RacingCars(racingCars);
    }

    public static RacingCars of(String[] input) {
        return Arrays.stream(input)
                .map(RacingCar::new)
                .collect(collectingAndThen(toList(), RacingCars::of));
    }

    public void startRacing(int countOfRacing, MoveStrategy moveStrategy) {
        racingCars.stream().forEach(racingCar -> racingCar.move(countOfRacing, moveStrategy));
    }

    public List<RacingCar> getRecingCarList() {
        return racingCars;
    }

    public int getCountOfRacingCar() {
        return this.countOfRacingCar;
    }


    public ArrayList<String> getCarsOfWinnerName() {
        int temp = 0;
        int max = 0;

        ArrayList<String> result = new ArrayList<String>();
        for(int i = 0; i< racingCars.size(); i++) {
            RacingCar racingCar = racingCars.get(i);
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
