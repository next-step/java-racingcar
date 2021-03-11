package racingcar;

import racingcar.car.NextStepCars;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    InputView inputView;
    Random random;

    public Racing(InputView inputView) {
        this.inputView = inputView;
        this.random = new Random();
    }

    /**
     * 입력값들 받는다.
     * @return Scanner를 통한 입력값들
     */
    private List<String> startQuestion() {
        List<String> scannerValues = new ArrayList<>();
        scannerValues.add(inputView.questionStepByStep());
        scannerValues.add(inputView.questionStepByStep());
        return scannerValues;
    }

    /**
     * 레이싱 시작
     */
    public void start() {
        List<String> inputs = startQuestion();

        String carList = inputs.get(0);
        int forwartCount = Integer.parseInt(inputs.get(1));

        NextStepCars nextStepCars = new NextStepCars(carList);

        for (int i = 0; i < forwartCount; i++) {
            nextStepCars.move(random);
            nextStepCars.printResult();
        }

        printWinner(nextStepCars);
    }


    private void printWinner(NextStepCars nextStepCars) {
        List<String> winners = nextStepCars.getWinner();
        int i = 0;
        for(String winner : winners) {
            System.out.print(winner + ((i == winners.size() - 1) ? "가 최종 우승했습니다." : ","));
            i++;
        }
    }
}
