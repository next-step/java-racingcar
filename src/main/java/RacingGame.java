import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RacingGame {
    private InputView inputView;

    public RacingGame() {
        inputView = new InputView();
    }

    public InputDto validation(String names, String number){
        return new InputDto(names, number);
    }

    public void Race(Cars cars, int numberOfAttempts){
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfAttempts; i++) {
            cars.advanceCars(new ConditionStrategy());
            ResultView.showRaceRound(cars.getCarRecords());
        }
    }

    public void start() {
        String names = inputView.inputArgument("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String number = inputView.inputArgument("시도할 회수는 몇 회 인가요?");

        InputDto inputDto = validation(names, number);

        Cars cars = CarFactory.generateCars(inputDto.getNames());
        Race(cars, inputDto.getNumberOfAttempts());
        ResultView.showWinners(cars.getWinnerNames());
    }
}
