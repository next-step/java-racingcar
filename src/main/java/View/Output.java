package View;

import Model.Car;
import java.util.ArrayList;

public class Output {
    public void printResult(ArrayList<Car> carList){
        for(int i = 0; i < carList.size(); i++){
            System.out.println(carList.get(i).toString());
        }
        System.out.print("\n");
    }

    public void printWinner(ArrayList<Car> carList){
        ArrayList<String> winnerList = new ArrayList<String>();
        int maxDistance = carList.get(0).getDistance();
        for(int i = 0; i < carList.size(); i++){
            if(maxDistance > carList.get(i).getDistance()) continue;
            if(maxDistance < carList.get(i).getDistance()){
                winnerList.clear();
                maxDistance = carList.get(i).getDistance();
            }
            winnerList.add(carList.get(i).getName());
        }
        System.out.print("최종 우승자 : ");
        for(int i = 0; i < winnerList.size(); i++){
            System.out.print(winnerList.get(i));
            if(i != winnerList.size() - 1) System.out.print(", ");
        }
    }
}
