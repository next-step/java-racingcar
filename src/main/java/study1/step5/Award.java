package study1.step5;

import java.util.ArrayList;

public class Award {
    private int highestScore = 0;


    public ArrayList<String> getWinnerList(Cars cars){
        ArrayList<String> winnerList = new ArrayList<>();

        for(int i = 0; i < cars.getCarsSize(); i++){
            checkWinner(winnerList, cars.getCar(i));
        }
        return winnerList;
    }

    private void checkWinner(ArrayList<String> winnerList, Car car){
        if(car.distance == this.highestScore){
            winnerList.add(car.racer);
        }
        if(car.distance > this.highestScore){
            this.highestScore = car.distance;
            winnerList.clear();
            winnerList.add(car.racer);
        }
    }
}
