package racinggame.view;

import java.util.ArrayList;
import java.util.List;
import racinggame.domain.Car;
import racinggame.domain.Winner;

public class ResultView {

    public void printCarsLocation(List<Car> cars){
            for (Car car : cars) {
                System.out.print(car.getCarName() + " : " + "");
                for (int i = 0; i < car.getLocation(); i++) {
                    System.out.print('-');
                }
                System.out.println();
            }
            System.out.println();
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
