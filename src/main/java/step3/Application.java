package step3;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private final Input input;
    private final View view;
    private final MovableStrategy movableStrategy;

    public Application(Input input, View view, MovableStrategy movableStrategy) {
        this.input = input;
        this.view = view;
        this.movableStrategy = movableStrategy;
    }

    public void run() {
        String[] carNames = input.readCars();
        int carCnt = carNames.length;
        int tryCnt = input.readTryCnt();
        Cars cars = generateCars(carNames);

        for(int i=0; i<tryCnt; i++){
            cars.moveAll(RandomNumberGenerator.getRandomIntList(carCnt));
            view.printRaceResult(cars);
        }
    }

    private Cars generateCars(String[] carNames){
        List<Car> carList = new ArrayList<>();
        for(int i=0; i<carNames.length; i++){
            if(carNames[i].length() > 5){
                throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.");
            }
            carList.add(new Car(movableStrategy, carNames[i]));
        }
        return new Cars(carList);
    }


}
