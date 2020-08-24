package step4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private List<Car> carList = new ArrayList<Car>();

    public void add(Car car)
    {
        carList.add(car);
    }

    public int size()
    {
        return carList.size();
    }

    public void run(){
        for (Car car : carList) {
            car.run(getRandomNum());
        }
    }

    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(10);
    }

    private int compareAndSetMaxStatus(int currentStatus, int maxStatus){
        if(currentStatus > maxStatus){
            maxStatus = currentStatus;
        }
        return maxStatus;
    }

    public int getMaxStatus(){
        int maxStatus = 0;

        for(Car car : carList){
            maxStatus = compareAndSetMaxStatus(car.getCurrentStatus(), maxStatus);
        }

        return maxStatus;
    }

    private Winners selectWinners(){
        int winnerStatus = getMaxStatus();
        Winners winners = new Winners(winnerStatus);
        for (Car car : carList) {
            winners.add(car);
        }

        return winners;
    }

    public String printWinner(){
        Winners winners = selectWinners();

        return winners.getWinnerString();
    }
}
