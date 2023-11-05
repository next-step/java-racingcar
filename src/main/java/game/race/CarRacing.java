package game.race;

import java.util.Scanner;

import game.race.model.InputView;
import game.race.model.ResultView;

public class CarRacing {

    private static final String SCRIPT_ONE = "자동차 대수는 몇 대 인가요?";
    private static final String SCRIPT_TWO = "시도할 회수는 몇 회 인가요?";
    private static final String LAST_SCRIPT = "실행 결과";

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        race();
    }

    public static void race() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        showPrompt(inputView);

        Race race = new Race(inputView.getTryCnt(), inputView.getVehicleCnt());
        race.start();

        resultView.setResult(race);
        showResult(resultView);
    }

    private static void showResult(ResultView resultView) {
        System.out.println(LAST_SCRIPT);
        for (String tireMark : resultView.getTireMarks()) {
            System.out.println(tireMark);
        }
    }

    private static void showPrompt(InputView inputView) {
        System.out.println(SCRIPT_ONE);
        String val1 = scanner.nextLine();
        inputView.checkInput(val1);

        System.out.println(SCRIPT_TWO);
        String val2 = scanner.nextLine();
        inputView.checkInput(val2);

        inputView.setVehicleCnt(Integer.parseInt(val1));
        inputView.setTryCnt(Integer.parseInt(val2));
    }
}
