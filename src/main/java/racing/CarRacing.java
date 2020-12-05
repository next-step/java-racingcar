package racing;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private static final List<Car> cars = new ArrayList<>();

    private static Display display;
    private static InputUtil inputUtil;
    public CarRacing( Display display,InputUtil inputUtil){
        this.display = display;
        this.inputUtil = inputUtil;
    }

    public void startRacing(){
        displayInputNumberOfCar();
        createCar( inputNumberOfCar());
        displayNumberOfTry();
        racingCount( inputNumberOfTry());
    }

    private void displayNumberOfTry() {
        display.printLine("시도할 회수는 몇 회 인가요?");
    }

    private void displayInputNumberOfCar(){
        display.printLine("자동차 대수는 몇 대 인가요?");
    }
    private int inputNumberOfCar(){
        int numberOfCar = NumberParserUtil.toInt(inputUtil.inputNumber());
        return numberOfCar;
    }
    private int inputNumberOfTry(){
        int racingCount = NumberParserUtil.toInt(inputUtil.inputNumber());
        return racingCount;
    }

    protected int createCar(int numberOfCar){
        for ( int i = 0; i < numberOfCar; i++){
            cars.add(new Car( display));
        }
        return cars.size();
    }
    private void racingCount(int racingCount) {
        for (int i = 0; i < racingCount; i++){
            racingStart();
            endTryRacing();
        }
    }

    private void racingStart(){
        for ( int i = 0; i < cars.size() ; i++){
            Car car = cars.get(i);
            car.run(RandomGenerator.getRandomNumber());
        }
    }

    private void endTryRacing(){
        display.printEmptyLine();
    }

}
