package carRacing.domain;

import carRacing.dto.UserInput;

import java.util.List;
import java.util.stream.Collectors;

public class Judge {

    private int count;

    public Judge() {
        this.count = 0;
    }

    public boolean isGameOver(UserInput userInput) {
        return userInput.getNumberOfRace() <= this.count;
    }

    public void recordTime() {
        this.count += 1;
    }

    public boolean isCount(int count) {
        return this.count == count;
    }

    public List<String> findWinners(List<Car> cars) {
        cars.sort((carA, carB) -> carB.getScore() - carA.getScore());
        int winningScore = cars.get(0)
                .getScore();
        return cars.stream()
                .filter(car -> car.getScore() == winningScore)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
