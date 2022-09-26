package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public String showWinnerNames(){
       return winners.stream()
               .map(Car::showName)
               .collect(Collectors.joining(","));
    }

    
}
