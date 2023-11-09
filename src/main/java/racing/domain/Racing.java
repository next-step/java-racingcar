package racing.domain;


import racing.ui.InputView;

import java.util.Random;

public class Racing {

    private final String CANNOT_BE_NEGATIVE_NUMBERS = "음수 입력 불가능합니다.";

    private int carCount = 0;

    private int tryCount = 0;

    private Cars carList = new Cars();

    public Racing(){
        this.carCount = InputView.getCarCount();
        this.tryCount = InputView.getTryCount();
        makeCarList(carCount);
    }

    private void makeCarList(int carCount) {
        for(int i = 0; i< carCount; i++){
            carList.addCar(new Car());
        }
    }

    public Cars racingStart(Random random){
        validation(carCount, tryCount);
        for(int i=0; i< carList.getSize(); i++){
            Car car = carList.getCar(i);
            car.moveCar(random.nextInt(10));
        }
        return carList;
    }

    private void validation(int carCount, int tryCount) {
        if(carCount < 0 || tryCount < 0){
            throw new RuntimeException(CANNOT_BE_NEGATIVE_NUMBERS);
        }
    }

    public Cars getCars(){
        return carList;
    }
}
