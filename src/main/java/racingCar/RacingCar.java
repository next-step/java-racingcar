package racingCar;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class RacingCar {
    private static final int RANDOM_BOUND = 10;
    private int trial = 0;
    public int maxPosition = 0;

    private int winnerCount = 0;
    private StringBuilder winners = new StringBuilder();
    private Random random = new Random();

    public RacingCar(int trial) { this.trial = trial; }

    public RacingCar(int trial, int maxPosition) {
        this(trial);
        this.maxPosition = maxPosition;
    }

    public void run(ArrayList<Car> cars) {
        int i=0;
        System.out.println("실행 결과");
        for(i=0; i<trial; i++) {
            racingCar(cars);
            System.out.println("");
        }
        setWinner(cars);
    }

    private int getRandomNumber() {
        return random.nextInt(RANDOM_BOUND);
    }

    private void racingCar(ArrayList<Car> cars) {
        for (Car car : cars) {
            racingStep(car,getRandomNumber());
        }
    }

    private void racingStep(Car car, int number) {
        car.step(number);
        car.printPosition();
        setMaxPosition(car.myPosition());
    }

    protected void setMaxPosition(int position) {
        if(maxPosition < position)
            maxPosition = position;
    }

    public void setWinner(ArrayList<Car> cars) {
        for (Car car : cars) {
            makeWinners(car.amIWinner(maxPosition));
        }
    }

    private void makeWinners(String name) {
        if (name == null){
            return;
        }
        winnerCount ++;
        if (winnerCount == 1){
            winners.append(name);
            return;
        }
        winners.append(", "+name);
    }

    public String showWinner() {
        String showWinner = "최종 우승자: "+winners+"\n";
        return showWinner;
    }
}




