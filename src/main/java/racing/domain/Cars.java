package racing.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cars {

    private static final int MAX_CAR_NAME = 5;
    private List<Car> carList = new ArrayList<>();

    private String winner = "";
    private int maxCount = 0;

    public Car getCar(int number){
        return carList.get(number);
    }
    
    public int getSize(){
        return carList.size();
    }

    public void makeCarList(String carNames){

        List<String> carNameList = getCarNameList(carNames);
        try {
            for(int i = 0; i< carNameList.size(); i++){
                carNameValidation(carNameList, i);
                carList.add(new Car(carNameList.get(i)));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> getCarNameList(String carNames) {
        List<String> carNameList = List.of(carNames.split(","));
        return carNameList;
    }

    private static void carNameValidation(List<String> carNameList, int i) throws Exception {
        if(carNameList.get(i).length() > MAX_CAR_NAME){
            throw new Exception("자동차 이름은 최대 5글자 입니다.");
        }
    }

    public String findWinner(){
        for(int i = 0; i < carList.size(); i++){
            addWinner(i);
            setWinner(i);
        }
        return winner;
    }

    private void addWinner(int i) {
        if(carList.get(i).getMoveCount() == maxCount){
            winner += ", "+carList.get(i).getCarName();
        }
    }

    private boolean setWinner(int i) {
        if(carList.get(i).getMoveCount() > maxCount){
            maxCount = carList.get(i).getMoveCount();
            winner = carList.get(i).getCarName();
            return true;
        }
        return false;
    }

    public void move(final MoveStrategy moveStrategy) {
        this.carList.forEach(car -> car.moveCar(moveStrategy));
    }

}
