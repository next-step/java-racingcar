package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(int number) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            carList.add(new Car());
        }
        this.carList = carList;
    }

    public static Cars createCars(int input) {
        return new Cars(input);
    }

    public List<Car> valueOf() {
        return carList;
    }

    public void race() {
        for (Car car : carList) {
            judgeOpportunity(car, RandomUtil.generateRandomNumberZeroTo(10));
        }
    }

    private static void judgeOpportunity(Car car, int randomNumber) {
        if(randomNumber >=4){
            car.move();
        }
    }

    public void printCarsPosition() {
        for (Car car : carList) {
            int currentPosition = car.valueOfCurrentPosition();
            StringBuilder position = makeSymbolByPosition(currentPosition);
            System.out.println(position);
        }
    }

    private static StringBuilder makeSymbolByPosition(int currentPosition) {
        StringBuilder position = new StringBuilder();
        for (int i = 0; i < currentPosition; i++) {
            position.append("-");
        }
        return position;
    }
}
