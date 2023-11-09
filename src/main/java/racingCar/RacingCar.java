package racingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    public static final int FORWRARD_BOUNDARY_VALUE = 3;
    public static final int RANDOM_LIMIT_VALUE = 10;

    public static void main(String[] args) {
        int[] inputValues = InputView.input();
        int carNum = inputValues[0];
        int tryNum = inputValues[1];

        Cars cars = new Cars(carNum);

        movingResult(cars.carArray, tryNum);

    }

    public static int moveCar(int inputValue){
        if(inputValue<=FORWRARD_BOUNDARY_VALUE) return 0;
        return 1;
    }

    public static int[] addMoving(int[] carArray){
        for (int i=0; i<carArray.length; i++){
            carArray[i] += moveCar(RandomNumber.getRandom(RANDOM_LIMIT_VALUE));
            ResultView.print(carArray[i]);
        }

        return carArray;
    }

    public static List<Car> addMovingNamedCar(List<Car> carList){

        for(Car car : carList){
            car.addForward(moveCar(RandomNumber.getRandom(RANDOM_LIMIT_VALUE)));
        }

        return carList;
    }

    public static int[] movingResult(int[] carArray, int tryNum){
        for(int i=0; i<tryNum; i++){
            addMoving(carArray);
            System.out.println();
        }

        return carArray;
    }

    public static NamedCars movingResultNamedCar(NamedCars namedCars, int tryNum){
        for(int i=0; i<tryNum; i++){
            addMovingNamedCar(namedCars.getCarList());
            System.out.println();
        }

        return namedCars;
    }

    public static List<String> returnWinner(NamedCars namedCars){
        int maxForward = namedCars.getMaxForward();

        List<String> winners = new ArrayList<>();

        for(Car car : namedCars.getCarList()){
            if(car.getForwardCnt() == maxForward) winners.add(car.getCarName());
        }

        return winners;
    }

}
