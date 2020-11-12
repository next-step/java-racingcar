package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList;

    public Cars(String[] names){
        carList= new ArrayList<Car>();

        for(int i=0;i<names.length;i++){
            this.carList.add(new Car(names[i]));
        }
    }

    public List<Car> getCarList(){
        return this.carList;
    }

    public int getBestRecord(){
        int bestRecord = 0;
        for(Car car : this.carList) {
            if(car.getLastRecord() >=bestRecord){
                bestRecord = car.getLastRecord();
            }
        }
        return bestRecord;
    }

    public List<String> findWinner(){
        List<String> winners = new ArrayList<String>();
        for(Car car : this.carList){
            if(car.getLastRecord() == getBestRecord()){
                winners.add(car.getName());
            }
        }
        return winners;
    }
}