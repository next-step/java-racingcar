package racingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerPolicyImpl implements WinnerPolicy{

    @Override
    public List<String> winnerDecision(List<RacingCar> cars) {
        //1. max num
        int winnerDistance = getMaxDistance(cars);
        //2, get
        return getWinners(winnerDistance, cars);
    }

    private int getMaxDistance(List<RacingCar> cars){
        int max = 0;
        for(RacingCar car : cars){
            int distance = car.showDrivenDistance();
            max = getBigggerNum(max,distance);

        }
        return max;
    }

    private int getBigggerNum(int num1, int num2){
        return Math.max(num1, num2);
    }

    private List<String> getWinners(int winnerDistance, List<RacingCar> cars){
        List<String> winners = new ArrayList<>();
        for(RacingCar car : cars){
            isWinner(winnerDistance, car, winners);
        }
        return winners;
    }

    private void isWinner(int winnerDistance, RacingCar car, List<String> winners){
        if(winnerDistance == car.showDrivenDistance()){
            winners.add(car.getCarName());
        }
    }
}
