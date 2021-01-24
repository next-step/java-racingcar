package racingcar.utils;

import racingcar.domain.Car;

import java.util.List;

public class StringDecoration {
    public String[] splitCarName(String inputLine){
        return inputLine.split(",");
    }

    public String decorateWinner(List<Car> winners){
        StringBuilder winnersBuilder = new StringBuilder();
        for (Car winner : winners) {
            winnersBuilder.append(winner.getName()).append(", ");
        }

        return winnersBuilder.substring(0, winnersBuilder.length() - 2);
    }

    public String decorateCarPosition(Car car){
        String name = car.getName();
        int position = car.getPosition();

        StringBuilder stringBuilder = new StringBuilder(name + " : ");
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
