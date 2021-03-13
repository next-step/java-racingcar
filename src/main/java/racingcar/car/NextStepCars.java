package racingcar.car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class NextStepCars {
    private List<Car> nextStepCars;

    public NextStepCars(Inputs inputs) {
        nextStepCars = new ArrayList<>();
        for(String car : inputs.getCarNames()) {
            nextStepCars.add(new NextStepCar(car));
        }
    }

    public NextStepCars(List<Car> nextStepCars) {
        this.nextStepCars = nextStepCars;
    }

    public int carCount() {
        return nextStepCars.size();
    }

    private int getFinalWinnerPosition() {
        int winnerPosition = 0;
        for(Car car : this.nextStepCars) {
            winnerPosition = Math.max(winnerPosition, car.getPosition());
        }
        int finalWinnerPosition = winnerPosition;
        return finalWinnerPosition;
    }

    public void move(Random randomNumber) {
        for(Car car : this.nextStepCars) {
            car.moveForward(randomNumber.nextInt(10));
        }
    }

    public String solveResult() {
        return this.generateResultString();
    }

    /**
     * 출력 해 줄 문자열생성
     * @return
     */
    private String generateResultString() {
        StringBuilder sb = new StringBuilder();
        for(Car car : this.nextStepCars) {
            sb.append(car.getName() + "-".repeat(car.getPosition())+"\n");
        }
        return sb.toString();
    }

    /**
     * 우승자 찾기
     * @return
     */
    public List<String> getWinner() {
        int finalWinnerPosition = getFinalWinnerPosition();
        List<String> collect = this.nextStepCars.stream()
                .filter(car -> car.getPosition() == finalWinnerPosition)
                .map(car -> car.getName())
                .collect(Collectors.toList());
        return collect;
    }
}
