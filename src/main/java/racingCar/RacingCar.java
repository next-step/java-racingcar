package racingCar;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class RacingCar {
    private ArrayList<Car> cars = new ArrayList<Car>();
    private int trial = 0;
    private int maxPosition = 0;

    private int winnerCount = 0;
    private StringBuilder winners = new StringBuilder();

    public RacingCar(String input) {
        StringTokenizer stringTokenizer = new StringTokenizer(input, ",");
        while (stringTokenizer.hasMoreTokens()) {
            this.cars.add(new Car(stringTokenizer.nextToken()));
        }
    }

    public void setTrial(int trial) {
        this.trial = trial;
    }

    public void run() {
        int i=0;
        System.out.println("실행 결과");
        for(i=0; i<trial; i++) {
            racingCar();
            System.out.println("");
        }
        setWinner();
    }

    private void racingCar() {
        for (Car car : cars) {
            car.step();
            car.printPosition();
            setMaxPosition(car.myPosition());
        }
    }
    private void setMaxPosition(int position) {
        if(maxPosition < position)
            maxPosition = position;
    }

    private void setWinner() {
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

    public void showWinner() {
        System.out.print("최종 우승자: "+winners+"\n");
    }
}




