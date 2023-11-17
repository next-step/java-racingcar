package racingCar;

import java.util.List;

public class RacingCar {
    public static final int FORWARD_BOUNDARY_VALUE = 3;
    public static final int RANDOM_LIMIT_VALUE = 10;

    public static void main(String[] args) {
        int[] inputValues = InputView.input();
        int carNum = inputValues[0];
        int tryNum = inputValues[1];

        Cars cars = new Cars(carNum);

        movingResult(cars.carArray, tryNum);

    }

    public static int[] addMoving(int[] carArray){
        for (int i=0; i<carArray.length; i++){
            Car.moveCar(carArray[i]);
            ResultView.print(carArray[i]);
        }

        return carArray;
    }

    public static List<Car> addNamedCarMoving(List<Car> carList){
        for(Car car : carList){
            car.moveNamedCar();
            car.printCar();
        }

        return carList;
    }

    public static int[] movingResult(int[] carArray, int tryNum){
        for(int i=0; i< tryNum; i++){
            addMoving(carArray);
            System.out.println();
        }

        return carArray;
    }

    public static NamedCars movingNamedCarResult(NamedCars namedCars, int tryNum){
        for(int i=0; i< tryNum; i++){
            addNamedCarMoving(namedCars.getCarList());
            ResultView.printNewLine();
        }

        return namedCars;
    }

}
