package racing.component;

import racing.dto.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private List<Car> cars;

    /* step1
    public RacingGame(int carNum, int times) {
        this.cars = getCarObjects(carNum);
        this.times = times;
    }

    public List<Car> getCarObjects(int carNum){
        List<Car> cars = new ArrayList<Car>();
        for(int i=0; i<carNum; i++){
            cars.add(new Car(0));
        }

        return cars;
    }

    */

    public RacingGame(String[] carNames) {
        this.cars = getCarObjects(carNames);
    }

    private static List<Car> getCarObjects(String[] carNames){
        List<Car> initCars = new ArrayList<Car>();
        for(int i=0; i<carNames.length; i++){
            initCars.add(new Car(0, carNames[i]));
        }
        return initCars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getRand(){
        return new Random().nextInt(10);
    }

    /**
     * 1회당 움직임
     */
    public void startGame(){
            for(Car c : cars){
                c.countPosition(getRand());
        }
    }

    // private으로 선언해야할 것 같은데 stream test가 필요하다.
    public static int maxPostion(List<Car> cars){
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .get()
                .getPosition();
    }

    public static List<Car> racingWinners(List<Car> cars){

        List<Car> winners = new ArrayList<>();
        int maxP = maxPostion(cars);
        for(Car c : cars){
            if(c.isNeedPosition(maxP)) {
                winners.add(c);
            }
        }
        return winners;
    }
}
