package racingcarwinner;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static List<Car> cars = new ArrayList();
    private static int NAME_LENGTH_LIMIT = 5;

    public static void createCar(String carsName){

        String[] carsNameArray = Game.splitCarsName(carsName);

        for (int i = 0; i < carsNameArray.length; i++) {
            cars.add(new Car(checkNameLength(carsNameArray[i])));
        }
    }

    private static String checkNameLength(String name){
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름의 글자 수는 다섯 글자를 넘을 수 없습니다");
        }
        return name;
    }

    public static Car getCar(int index){
        return cars.get(index);
    }

    public static int getCarsCount(){
        return cars.size();
    }



}
