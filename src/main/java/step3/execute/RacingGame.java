package step3.execute;

import step3.generator.RandomGenerator;
import step3.model.Car;
import step3.view.InputView;
import step3.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {
    private List<Car> challengerList;
    private InputView inputView;
    private OutputView outputView;

    public RacingGame() {
        initializeVariable();
    }

    public void initializeVariable() {
        this.challengerList = new ArrayList<>();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void playGame() {
        // For문으로 구성된 내용을 Stream으로 모두 변경 진행
        challengerList.forEach(Car::accelerateCar);
        challengerList.stream()
                .map(car -> OutputView.getDashDistance(car.showDistance()))
                .forEach(System.out::println);
    }

    public void run() {
        // Input 입력
        inputView.runInputView();
        // Stream으로 변경
        challengerList = Stream.generate(Car::new)
                .limit(inputView.getNumberOfCars())
                .collect(Collectors.toList());

        //결과 출력
        outputView.runOutputView(challengerList, inputView.getTrialCounts());
    }
}
