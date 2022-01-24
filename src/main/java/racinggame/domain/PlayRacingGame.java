package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayRacingGame {

    public List<Integer> makeRandomNumbers(int carNum,Random random) {
        List<Integer>randomNumberList=new ArrayList<>();
        for(int count=0;count<carNum;count++){
            int randomValue = random.nextInt(9);
            randomNumberList.add(randomValue);
        }

        return randomNumberList;
    }

    public int findMaxLocation(List<Car> cars) {
        int maxLocation = 0;
        for (Car car : cars) {
            maxLocation = Math.max(car.getLocation(), maxLocation);
        }
        return maxLocation;
    }

    public List<Winner> findWinner(List<Car> cars,int maxLocation) {
        List<Winner> winnerUsers = new ArrayList<>();
//        int maxLocation = findMaxLocation(cars);
        for (Car car : cars) {
            if (car.getLocation() == maxLocation) {
                winnerUsers.add(new Winner(car.getCarName()));
            }
        }
        return winnerUsers;
    }

    public void printWinner(List<Winner> winners) {
        List<String> winnerNameList = new ArrayList<>();
        String winnerNames = "";
        System.out.print("최종 우승자: ");
        for (Winner winner : winners) {
            winnerNameList.add(winner.getWinnerName());
        }
        winnerNames = String.join(", ", winnerNameList);
        System.out.println(winnerNames);
    }

}
