package racingCar;

import racingCar.utils.RandomGenerator;
import racingCar.utils.Utils;
import racingCar.view.InputView;
import racingCar.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingRecordsWithWinner {
    public void runRaceWithWinner(){

        List<RacingCar> records = new ArrayList<>();
        List<String> nameOfWinner = new ArrayList<>();

        String carNameString = InputView.nameOfCar();
        String[] carNames = carNameString.split(",");
        int roundNum = Utils.toInt(InputView.numberOfRound());

        for (String car : carNames){
            Utils.checkUsableName(car);
            records.add(new RacingCar(car));
        }

        OutputView.printRacingResult();
        for (int i = 0; i < roundNum ; i++){
            runOneRound(records);
            OutputView.printRacingWithName(records);
        }
        nameOfWinner = findWinner(records);
        OutputView.WinnerOfRacing(nameOfWinner);
    }

    public void runOneRound(List<RacingCar> records) {
        for (RacingCar racingCar: records) {
            racingCar.move(moving());
        }
    }

    private static MovingStrategy moving(){
        RandomGenerator randomGenerator = new RandomGenerator();
        return new RandomMovingStrategy(randomGenerator);
    }

    private List<String> findWinner(List<RacingCar> racingCars){
        int highScore = findRecordsOfWinner(racingCars);
        List<String> carName = new ArrayList<>();
        for(RacingCar car: racingCars){
            carName.add(findNameOfWinner(highScore,car));
        }
        carName.removeAll(Collections.singletonList("notWinner"));
        return carName;
    }

    private int findRecordsOfWinner(List<RacingCar> racingCars){
        LinkedList<Integer> score = new LinkedList<Integer>();
        for(RacingCar car: racingCars){
            score.add(car.positionOfRacingCar());
        }
        return Collections.max(score);
    }

    private String findNameOfWinner(int highScore, RacingCar car){
        if(highScore == car.positionOfRacingCar()){
            return car.NameOfCar();
        }
        return "notWinner";
    }

}
