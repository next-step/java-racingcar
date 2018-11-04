package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private int tryCnt;
    private List<Car> cars;

    private static final int MAX_NUMBER = 9;
    private static final int POSSIBLE_NUMBER = 4;

    public RacingGame(String[] carNames, int tryCnt){
        cars = new ArrayList<>();
        for(String carName : carNames){
            cars.add(new Car(carName, 0));
        }
        this.tryCnt = tryCnt;
    }

    public boolean nextRacingGame() {
        return tryCnt > 0;
    }

    public List<Car> move() {
        tryCnt--;
        for(int i =0; i < cars.size(); i++){
            moveCar(i);
        }
        return cars;
    }

    private void moveCar(int location) {
        if(isPossibleMove()){
           cars.get(location).carMove();
        }
    }

    protected boolean isPossibleMove(){
        Random number = new Random();
        return number.nextInt(MAX_NUMBER) >= POSSIBLE_NUMBER;
    }

    public List<Car> getCars() {
        return cars;
    }


}
