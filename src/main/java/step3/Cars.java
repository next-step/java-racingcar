package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> carList = new ArrayList<>();

    //TODO: cars객체의 생성자로 카운트를 받아서 createCars호출 inputView의존관계 줄이기
    //createCars하기전에 cars생성자 호출
    /*private int carCount;
    public void Cars(int carCount){
        this.carCount = carCount;
    }*/

    public void createCars(){
        for (int i = 0; i < InputView.carCount; i++) {
            carList.add(new Car());
        }
    }

    public int getSize(){
        return carList.size();
    }

    public Car getCar(int i){
        return carList.get(i);
    }
}