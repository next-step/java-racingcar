package domain.racing;

import java.util.*;

public class Car {
    ArrayList<String> x = new ArrayList<>();
    HashMap<String, StringBuffer> car = new HashMap<>();
    ArrayList<String> winner = new ArrayList<>();


    public boolean isCarName(String carName) {
        return carName.length() <= 5;
    }

    // 자동차 이름 입
    public void cars(String carName) {
        Arrays.stream(carName.split(",")).forEach(v -> {
            if (!isCarName(v)) {
                throw new IllegalArgumentException();
            }
        });
        carsConfig(carName.split(","));
    }

    // 게임횟수 입력시 게임시작
    public void startGame(int count) {
        for (int i = 1; i < count; i++) {
            for (int j = 0; j < x.size(); j++) {
                racingGame(j);
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

    public void racingGame(int j) {
        if (moveCar()) {
            car.get(x.get(j)).append("-");
        }
    }

    public void win(ArrayList<String> x) {
        HashMap<String, Integer> result = new HashMap<>();
        x.forEach(v -> {
            result.put(v, car.get(v).length());
        });
        int maxValueInMap = Collections.max(result.values());
        result.forEach((key, value) -> {
            if (value == maxValueInMap) {
                winner.add(key);
            }
        });
    }
}
