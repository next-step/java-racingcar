package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    static Random random = new Random();

    static String NEGATIVE_INPUT = "음수 입력은 불가능 합니다.";

    public static void racingStart(int carCount, int tryCount){

        List<Car> carList = new ArrayList<>();

        validation(carCount, tryCount);

        for(int i=0; i<tryCount; i++){
            numberOfCarAttempts(carCount, i, carList);
            ResultView.viewResultView(carList);
        }

    }

    private static void validation(int carCount, int tryCount) {
        if(carCount < 0 || tryCount <0){
            throw new RuntimeException(NEGATIVE_INPUT);
        }
    }


    private static void numberOfCarAttempts(int carCount, int i, List<Car> carList) {
        for(int j = 0; j< carCount; j++){
            firstMakeCar(i, j, carList);
            Car.moveCar(carList.get(j),randomNumber());
        }
    }

    private static void firstMakeCar(int i, int j, List<Car> carList) {
        if(i == 0){
            Car car = new Car(j);
            carList.add(car);
        }
    }

    public static int randomNumber() {
        return random.nextInt(10);
    }

}
