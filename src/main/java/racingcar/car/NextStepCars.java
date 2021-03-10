package racingcar.car;

import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class NextStepCars {
    private List<Car> nextStepCars;

    public NextStepCars(List<Car> nextStepCars) {
        this.nextStepCars = nextStepCars;
    }

    public NextStepCars(String carList) {
        nextStepCars = new ArrayList<>();
        for(String car : carList.split(",")) {
            nextStepCars.add(new NextStepCar(car));
        }
    }

    public int carCount() {
        return nextStepCars.size();
    }

    public List<String> getWinner() {
        int finalWinnerPosition = getFinalWinnerPosition();
        List<String> collect = this.nextStepCars.stream()
                .filter(car -> car.moveForward(0) == finalWinnerPosition)
                .map(car -> car.getName())
                .collect(Collectors.toList());
        return collect;
    }

    private int getFinalWinnerPosition() {
        int winnerPosition = 0;
        for(Car car : this.nextStepCars) {
            winnerPosition = Math.max(winnerPosition, car.moveForward(0));
        }
        int finalWinnerPosition = winnerPosition;
        return finalWinnerPosition;
    }

    public void move(Random randomNumber) {
        for(Car car : this.nextStepCars) {
            car.moveForward(randomNumber.nextInt(10));
        }
    }

    public void printResult() {
        ResultView resultView = new ResultView();
        String carName = "";
        for(Car car : this.nextStepCars) {
            String prefix = (!carName.equals(car.getName())) ? car.getName() + " : " : "";
            resultView.print(prefix + "-".repeat(car.moveForward(0)));
            carName  = car.getName();
        }
        System.out.println();
    }
}
