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

    public void solveResult() {
        ResultView resultView = new ResultView();
        for(Car car : this.nextStepCars) {
            resultView.print(this.generateResultString(car));
        }
        System.out.println();
    }

    /**
     * 출력 해 줄 문자열생성
     * @param car
     * @return
     */
    private String generateResultString(Car car) {
        String result = car.getName() + "-".repeat(car.getPosition());;
        return result;
    }

    /**
     * 우승자해결
     */
    public void solveWinner() {
        ResultView resultView = new ResultView();
        resultView.printWinner(this.getWinner());
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
