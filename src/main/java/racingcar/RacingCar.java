package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingCar {
    private static final int ENDNUMBER = 5;
    private final int MAX = 10;
    private final int MOVE_CONDITION = 4;

    public Car createCar(String name) {
        return new Car(name, 1);
    }

    public String[] seperator(String inputStr) {
        return inputStr.split(",");
    }

    public List<Car> play(String inputStr, int playNumber) {
        String[] carStrArr = seperator(inputStr);
        List<Car> cars = getCars(carStrArr);
        List<Car> winCars = new ArrayList<>();
        for(int i=0; i<playNumber; i++){
            moveCar(cars);
            winCars = isEndGame(cars);
            if(!winCars.isEmpty())
                break;
        }
        return winCars;
    }

    private void moveCar(List<Car> cars) {
        for (Car car : cars) {
            move(car);
        }
    }

    private List<Car> getCars(String[] cars) {
        List<Car> carList = new ArrayList<>();
        for (String car : cars) {
            carList.add(createCar(car));
        }
        return carList;
    }

    private List<Car> isEndGame(List<Car> carList) {
        return carList.stream().filter(car -> car.getPosition()==ENDNUMBER).collect(Collectors.toList());
    }

    public void move(Car car) {
        if (isMove())
            car.move();
    }

    private boolean isMove(){
        Random random = new Random();
        int temp = random.nextInt(MAX);
        System.out.println(temp);
        if(temp <= MOVE_CONDITION)
            return true;
        return false;
    }


}
