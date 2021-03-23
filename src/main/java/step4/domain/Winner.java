package step4.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {

     List<String> winners;

    public Winner() {
        winners = new ArrayList<>();
    }

    public List<String> getWinners() {
        return winners;
    }

    public void findWinner(Cars cars) {
        int grade = cars.topGrade();
        for(Car car : cars.getCarList()){
            isWinner(car , grade);
        }
    }

    private void isWinner(Car car, int grade) {
        if(car.isWinner(grade)){
            winners.add(car.myName());
        }
    }
}
