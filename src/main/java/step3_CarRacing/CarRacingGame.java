package step3_CarRacing;

import step3_CarRacing.view.InputView;
import step3_CarRacing.view.ResultView;

import java.util.Scanner;

public class CarRacingGame {
    // TODO : 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    // TODO : UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
    public static void main(String[] args) {
        //init
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Scanner scanner = new Scanner(System.in);


        //input
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();

        scanner.nextLine(); // nextInt() 사용 후 nextLine() 호출 시 줄바꿈 문자 처리

        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfRounds = scanner.nextInt();

        Race race = new Race(numberOfCars);

        //result
        runRaces(numberOfRounds, race, resultView);
    }

    private static void runRaces(int numberOfRounds, Race race, ResultView resultView) {
        resultView.printResultHeader();
        for (int i = 0; i < numberOfRounds; i++) {
            race.runRound();
            resultView.displayRaceResult(race.getCars());
        }
    }
}
