package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    private final String COMMA = ",";

    private int winnerDistance = 0; // 우승자의 distance

    public List<Car> initCars(String[] names) {
        List<Car> cars = new ArrayList<>();

        for(int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i].trim()));
        }

        return cars;
    }

    public String[] splitNames(String names) {
        return names.split(COMMA);
    }

    public void startRace(List<Car> cars) {
        Random random = new Random();

        for(Car car : cars) {
            car.move(random.nextInt(10));
        }
    }

    public List<String> getWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();

        for(Car car : cars) {
            winners = addIfWinner(winners, car);
        }

        return winners;
    }

    public List<String> addIfWinner(List<String> winners, Car car) {
        int distance = car.getDistance();

        if (winnerDistance == distance) {
            // 같을 경우 이름 추가
            winners.add(car.getName());
        } else if (winnerDistance < distance) {
            // input 차의 거리가 더 클 경우 list 생성
            winners = new ArrayList<>();
            winners.add(car.getName());
            winnerDistance = distance;
        }

        return winners;
    }

}
