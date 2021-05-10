package domain.racing;

import java.util.*;

public class Car {
    ArrayList<String> x = new ArrayList<>();
    HashMap<String, StringBuffer> car = new HashMap<>();
    ArrayList<String> winner = new ArrayList<>();


    public boolean isCarName(String carName) {
        return carName.length() <= 5;
    }

    public void cars(String carName) {
        Arrays.stream(carName.split(",")).forEach(v -> {
            if (!isCarName(v)) {
                throw new IllegalArgumentException();
            }
        });
        carsConfig(carName.split(","));
    }

    public void gameCount(int count) {
        for (int i = 1; i < count; i++) {
            for (int j = 0; j < x.size(); j++) {
                startGame(j);
            }
        }
        win(x);
    }

    public boolean moveCar() {
        return ((int) (Math.random() * 1) + 9) >= 4;
    }

    public void carsConfig(String[] cars) {
        Arrays.stream(cars).forEach(v -> {
            x.add(v);
            car.put(v, new StringBuffer(""));
        });
    }

    public void startGame(int j) {
        if (moveCar()) {
            car.get(x.get(j)).append("-");
        }
    }

    public void win(ArrayList<String> x){
        HashMap<String, Integer> result = new HashMap<>();
        for (String carName : x) {
            result.put(carName, car.get(carName).length());
        }
        int maxValueInMap = Collections.max(result.values());
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                winner.add(entry.getKey());
            }
        }
    }
}
