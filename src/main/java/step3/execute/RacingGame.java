package step3.execute;

import step3.model.Car;
import step3.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static step3.view.OutputView.runOutputView;
import static step3.view.OutputView.showOutputViewBanner;

public class RacingGame {
    private List<Car> challengerList;
    private InputView inputView;

    public RacingGame() {
        initializeVariable();
    }

    public void initializeVariable() {
        this.challengerList = new ArrayList<>();
        inputView = new InputView();
    }

    public void playGame() {
        // For문으로 구성된 내용을 Stream으로 모두 변경 진행
        challengerList.forEach(Car::accelerateCar);
    }

    public void run() {
        // Input 입력
        inputView.runInputView();
        // Stream으로 변경
        challengerList = Stream.generate(Car::new)
                .limit(inputView.getNumberOfCars())
                .collect(Collectors.toList());

        //결과 출력
        showOutputViewBanner();
        for (int loop = 0; loop < inputView.getTrialCounts(); loop++) {
            playGame();
            runOutputView(challengerList);
        }
    }
}
