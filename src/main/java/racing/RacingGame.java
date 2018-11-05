package racing;

import java.util.*;

public class RacingGame {
    private static final int MAX_NUM = 10;

    private int time;
    private List<Car> cars;

    public int getCarCount(){
        return cars.size();
    }

    public String getName(int index){
        return cars.get(index).getName();
    }
    RacingGame(String player, int time){
        readyCar(player.split(","));
        this.time = time;
    }

    private void readyCar(String[] names) {
        cars = new ArrayList<>();
        for(int i = 0; i < names.length; i ++){
            cars.add(new Car(names[i]));
        }
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
        return car.addPosition(getRandomNum());
    }

    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(MAX_NUM);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        InputView inputView = new InputView(sc);
        RacingGame racingGame = new RacingGame(inputView.getRacingCars(), inputView.getTryCnt());
        ResultView.watchRace(racingGame);
        CarResult.getRaceWinners(racingGame);
    }




}
