package racingCar;

import java.util.ArrayList;
import java.util.List;

import static racingCar.Car.compare;


public class GameResult {

    private List<Car> resultList;
    public GameResult(){
    }
    public GameResult(List<Car> resultList) {
        this.resultList = resultList;
    }
    public List<Car> getResultList(){

        return this.resultList;
    }

    //우승자 리스트 추출하기.
    public List<Car> getWinnerCar(){
        List<Car> winnerList = new ArrayList<Car>();
        winnerList.add(this.resultList.get(0));
        for(int i=1; i<this.resultList.size();i++){
            winnerList = compare(winnerList, this.resultList.get(i));
        }

        return winnerList;
    }



}


