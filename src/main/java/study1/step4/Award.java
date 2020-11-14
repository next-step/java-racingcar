package study1.step4;

import java.util.ArrayList;

public class Award {
    private int highestScore = 0;


    public ArrayList<String> getWinnerList(Cars cars){
        ArrayList<String> winnerList = new ArrayList<>();
        for(Car car: cars.getCars()){
            checkWinner(winnerList, car);
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
