package racingcar;

import java.util.Arrays;

public class Controller {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String namesRequest = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
        String roundsRequest = "시도할 회수는 몇 회 인가요?";

        String[] names = inputView.nextStrings(namesRequest);
        int rounds = inputView.nextInt(roundsRequest);
        inputView.close();

        RacingCar[] entries = Arrays.stream(names)
                .map(RacingCar::new)
                .toArray(RacingCar[]::new);

        resultView.printlnRace(entries, rounds);
        resultView.printlnWinners(entries);
    }
}
