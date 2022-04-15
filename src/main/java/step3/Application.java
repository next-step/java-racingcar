package step3;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private final Input input;
    private final View view;

    public Application(Input input, View view) {
        this.input = input;
        this.view = view;
    }

    public void run() {
        int carCnt = input.readCarCount();
        int tryCnt = input.readTryCnt();

        Cars cars = generateCars(carCnt);

        for(int i=0; i<tryCnt; i++){
            cars.moveAll(RandomNumberGenerator.getRandomIntList(carCnt));
            view.printRaceResult(cars);
        }
    }

    private Cars generateCars(int cnt){
        List<Car> carList = new ArrayList<>();
        for(int i=0; i<cnt; i++){
            carList.add(new Car());
        }
        return new Cars(carList);
    }


}
