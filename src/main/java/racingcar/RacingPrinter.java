package racingcar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingPrinter {
    private Map<RacingCar, Integer> rankMap;
    private List<RacingCar> racingCars;
    private int maxiMumNumber;

    public RacingPrinter(List<RacingCar> racingCars){
        this.racingCars = racingCars;
        this.rankMap = new HashMap<>();
        int maxiMumNumber = -1;
    }

    public void chooseFinalWinners(){
        for(RacingCar racingCar1 : racingCars){
            int tempMaxiMumNumber = racingCar1.compareRacingCarListWithNum(racingCars);
            if(maxiMumNumber < tempMaxiMumNumber){
                maxiMumNumber = tempMaxiMumNumber;
            }
            rankMap.put(racingCar1, tempMaxiMumNumber);
        }
    }

    public void printFinalWinner(){
        StringBuilder sb = new StringBuilder();
        String line = "최종 우승자: ";
        sb.append(line);
        for(RacingCar racingCar : racingCars){
            if(rankMap.get(racingCar).equals(maxiMumNumber)){
                sb.append(racingCar.whoAmI());
                sb.append(", ");
            }
        }
        System.out.println(sb.toString().substring(0, sb.toString().length() - 2));

    }
}
