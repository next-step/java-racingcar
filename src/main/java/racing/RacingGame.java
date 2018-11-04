package racing;

import java.util.*;

public class RacingGame {

    private int time;
    private List<Car> cars;
    public int getCarCount(){
        return cars.size();
    }
    public String getName(int index){
        return cars.get(index).getName();
    }
    RacingGame(String player, int time){
        String[] names = player.split(",");
        cars = new ArrayList<>();
        for(int i = 0; i < names.length; i ++){
            Car car = new Car(names[i], i);
            cars.add(car);
        }
        this.time = time;
    }

    public int getTime(){
        return time;
    }


    public List<Car> move() {
        List<Car> nextStepCars = new ArrayList<>();
        for(int i = 0; i < cars.size(); i++){
             nextStepCars.add(tryMove(cars.get(i)));
        }
        return nextStepCars;
    }

    public List<Car> getCars(){
        return cars;
    }

    private Car tryMove(Car car) {
        if(isMove()){
           car.addPosition();
        }
        return car;
    }

    private boolean isMove() {
        final int MIN_NUM = 4;
        return getRandomNum() >= MIN_NUM;
    }

    private int getRandomNum() {
        final int MAX_NUM = 10;
        Random random = new Random();
        return random.nextInt(MAX_NUM);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        InputView inputView = new InputView(sc);
        RacingGame racingGame = new RacingGame(inputView.getRacingCars(), inputView.getTryCnt());
        ResultView.watchRace(racingGame);
    }


}
