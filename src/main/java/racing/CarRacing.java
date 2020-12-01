package racing;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private static final List<Car> cars = new ArrayList<>();

    private static Display display;
    private static Util util;
    public CarRacing( Display display, Util util){
        this.display = display;
        this.util = util;
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
        int numberOfCar = util.inputNumber();
        return numberOfCar;
    }
    private int inputNumberOfTry(){
        int racingCount = util.inputNumber();
        return racingCount;
    }

    protected int createCar(int numberOfCar){
        for( int i=0;i<numberOfCar;i++){
            cars.add(new Car());
        }
        return cars.size();
    }
    private void racingCount(int racingCount) {
        for(int i = 0; i < racingCount; i ++){
            racingStart();
            endTryRacing();
        }
    }

    private void racingStart(){
        for( int i = 0; i < cars.size() ; i ++){
            Car car = cars.get(i);
            car.run( util.getRandomNumber());
        }
    }

    private void endTryRacing(){
        System.out.println();
    }

}
