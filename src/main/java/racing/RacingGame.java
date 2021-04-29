package racing;

import racing.utils.ConvertString;
import racing.view.Input;
import racing.view.Output;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<Car> makeCar(String name, List<Car> carList) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이내로 입력하세요.");
        }
        Car car = new Car(name);
        car.init();
        carList.add(car);
        return carList;
    }

    public void gameStart() {
        RacingGame racingGame = new RacingGame();
        Output output = new Output();
        Input input = new Input();
        ConvertString convertString = new ConvertString();

        List<Car> carList;

        output.start();
        String carString = input.makeCars();
        String[] carNameArray = convertString.splitString(carString);

        carList = makeCarList(carNameArray);
        System.out.println(carList.get(0).getName());
    }

    private List<Car> makeCarList(String[] carNameArray) {
        List<Car> carList = new ArrayList<Car>();

        for (String carName : carNameArray) {
            makeCar(carName, carList);
        }
        return carList;
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.gameStart();
    }
}