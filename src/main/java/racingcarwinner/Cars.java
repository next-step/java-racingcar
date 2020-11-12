package racingcarwinner;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static List<Car> cars = new ArrayList();

    public static void createCar(String carsName){

        String[] carsNameArray = Game.splitCarsName(carsName);

        for (int i = 0; i < carsNameArray.length; i++) {
            cars.add(new Car(carsNameArray[i]));
        }
    }

    public static Car getCar(int index){
        return cars.get(index);
    }

    public static int getCarsCount(){
        return cars.size();
    }



}
