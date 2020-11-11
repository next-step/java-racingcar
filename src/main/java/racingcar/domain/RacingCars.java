package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCars {

    private List<RacingCar> racingCars;
    private int winnerPosition;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void roundExecute(int i, Commander commander) {
        racingCars.get(i).move(commander);
        saveWinnerPosition(racingCars.get(i).getCurrentPosition());
    }

    private void saveWinnerPosition(int currentPosition) {
        if(currentPosition >= winnerPosition){
            winnerPosition = currentPosition;
        }
    }

    public List<Integer> getResult() {
        return IntStream.range(0, racingCars.size())
                .mapToObj(i -> racingCars.get(i).getCurrentPosition())
                .collect(Collectors.toList());
    }

    public List<String> getCarName() {
        return IntStream.range(0, racingCars.size())
                .mapToObj(i -> racingCars.get(i).getCarName())
                .collect(Collectors.toList());
    }

    public List<RacingCar> getWinner() {
        return  IntStream.range(0, racingCars.size())
                .filter(i -> racingCars.get(i).getCurrentPosition() == winnerPosition)
                .mapToObj(i -> racingCars.get(i))
                .collect(Collectors.toList());
    }
}
