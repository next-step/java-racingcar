package racing.domain;

import racing.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    static Random random = new Random();

    static String NEGATIVE_INPUT = "음수 입력은 불가능 합니다.";

    public List<List<Car>> racingStart(int carCount, int tryCount){

        List<Car> carList = new ArrayList<>();

        validation(carCount, tryCount);

        List<List<Car>> viewList = new ArrayList<>();

        for(int i=0; i<tryCount; i++){
            List<Car> list = numberOfCarAttempts(carCount, i, carList);
            viewList.add(list);
        }

        return viewList;
    }

    private void validation(int carCount, int tryCount) {
        if(carCount < 0 || tryCount <0){
            throw new RuntimeException(NEGATIVE_INPUT);
        }
    }

    private List<Car> numberOfCarAttempts(int carCount, int i, List<Car> carList) {

        for(int j = 0; j< carCount; j++){
            firstMakeCar(i, j, carList);
        }

        moveCar(carList);
        return carList;
    }

    private void moveCar(List<Car> carList) {
        for(Car list : carList){
            Car car = list;
            car.moveCar(car, randomNumber());
        }
    }

    private void firstMakeCar(int i, int j, List<Car> carList) {
        if(i == 0){
            Car car = new Car(j, i, 0);
            carList.add(car);
        }
    }

    public int randomNumber() {
        return random.nextInt(10);
    }

}
