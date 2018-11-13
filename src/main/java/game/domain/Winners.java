package game.domain;

import game.domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {
    private static final String SPERATOR = ", ";

    public static String findWinners(List<Car> cars) {
        return insertSeparator(convertsNameToString(makeWinners(cars)));
    }

    private static String insertSeparator(String[] winnerNames){
        return String.join(SPERATOR,winnerNames);

    }

    private static String[] convertsNameToString(List<String> winners){
        return winners.toArray(new String[winners.size()]);
    }

    private static List<String> makeWinners(List<Car> cars){
        int maxScore = findCarWithMaxScore(cars);
        List<String> winners = new ArrayList<>();
        for(Car car: cars){
            if(car.isEqualsMaxScore(maxScore)){
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private static int findCarWithMaxScore(List<Car> cars) {
        return Collections.max(cars).getLocation();
    }
}