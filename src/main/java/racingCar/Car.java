package racingCar;


import java.util.ArrayList;
import java.util.List;

import static racingCar.RacingCarUtil.showPosition;


public class Car {

    private static final int CONDITIONBOUNDARY=4;

    private String name;
    private int position;

    //생성자
    public Car(String name){
        this.name = name;
        this.position = 0;
    }

    public Car(String name, int position ){
        this.name = name;
        this.position = position;
    }
    //차량 한대에 대한 이동
    public int move(int randomValue) {
        if (randomValue > CONDITIONBOUNDARY) {
            return this.position += 1;
        }
        return this.position;
    }

    //차량 비교
    public static List<Car> compare(List<Car> winnerList, Car car){
        if(winnerList.get(0).position < car.position){
            List<Car> returnList = new ArrayList<Car>();
            returnList.add(car);
            return returnList;
        }
        if(winnerList.get(0).position == car.position) {
            winnerList.add(car);
        }
        return winnerList;
    }
    //리스트에서 이름 추출하기.
    public static List<String> getNamesFromList(List<Car> winnerList){

        List<String> carNames = new ArrayList<String>();
        for(int i=0;i<winnerList.size();i++){
            carNames.add(winnerList.get(i).name);
        }
        return carNames;

    }

    //진행 결과값
    public String toString(){
        return this.name + " : " + showPosition(this.position);
    }




}
