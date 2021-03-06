package racingcar;

import racingcar.car.Car;
import racingcar.car.NextStepCar;
import racingcar.car.NextStepCars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    private final String inputQuestion;
    private final String moveQuestion;
    InputView inputView;
    ResultView resultView;
    Random random;

    public Racing(String inputQuestion, String moveQuestion) {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.random = new Random();
        this.inputQuestion = inputQuestion;
        this.moveQuestion = moveQuestion;
    }

    /**
     * 입력값들 받는다.
     * @return Scanner를 통한 입력값들
     */
    private List<Integer> startQuestion() {
        List<Integer> scannerValues = new ArrayList<>();
        inputView.print(inputQuestion);
        scannerValues.add(inputView.scanner.nextInt());
        inputView.print(moveQuestion);
        scannerValues.add(inputView.scanner.nextInt());
        return scannerValues;
    }

    /**
     * 레이싱 시작
     */
    public void start() {
        List<Car> cars = new ArrayList<>();

        List<Integer> inputs = startQuestion();
        int carCount = inputs.get(0);
        int forwartCount = inputs.get(1);

        for (int i = 0; i < carCount; i++) {
            cars.add(new NextStepCar("dummy"));
        }
        NextStepCars nextStepCars = new NextStepCars(cars);

        startMoveForward(nextStepCars);
        printResultAll(forwartCount, nextStepCars);
    }

    /**
     * 각각의 자동차들 전진
     * @param nextStepCars
     */
    private void startMoveForward(NextStepCars nextStepCars) {
        for(Car car : nextStepCars.getNextStepCars()) {
            car.moveForward(random.nextInt(10));
        }
    }

    /**
     * 모든 결과 출력
     * @param forwartCount
     * @param nextStepCars
     */
    private void printResultAll(int forwartCount, NextStepCars nextStepCars) {
        for (int i = 0; i < forwartCount; i++) {
            for(Car car : nextStepCars.getNextStepCars()) {
                car.moveForward(random.nextInt(10));
                resultView.print("-".repeat(car.getPosition()));
            }
            System.out.println();
        }
    }
}
