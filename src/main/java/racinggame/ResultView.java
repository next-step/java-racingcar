package racinggame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultView {

    private int maxLocation = 0;
    private List<String> victoryCar;

    public void print(List<Car> cars) {
        for(int i =0; i < cars.size(); i++){
            printCarName(cars.get(i));
            printCar(cars.get(i));
        }
        System.out.println();
        printVictoryCar(cars);
        printVictoryCarPrint();
    }

    private void printVictoryCar(List<Car> cars) {
        maxLcationSetting(cars);
        victoryCarSetting(cars);
    }

    private void victoryCarSetting(List<Car> cars) {
        victoryCar = new ArrayList();
        for(int i =0; i < cars.size(); i++){
            vicotryCar(cars.get(i));
        }
    }

    private void vicotryCar(Car car) {
        if(maxLocation == car.getLocation()){
            victoryCar.add(car.getName());
        }

    }

    private void printVictoryCarPrint() {
        System.out.println(Arrays.toString(victoryCar.toArray()) + "가 최종 우승했습니다.");
    }

    private void maxLcationSetting(List<Car> cars) {
        for(int i =0; i < cars.size(); i++){
            maxLocation(cars.get(i).getLocation());
        }
    }

    private void maxLocation(int location) {
        if(maxLocation < location){
            maxLocation = location;
        }
    }

    private void printCarName(Car car) {
        System.out.print(car.getName() + " : ");
    }

    private void printCar(Car car) {
        for(int i =0; i < car.getLocation(); i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
