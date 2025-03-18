import domain.Race;
import ui.InputView;

import java.util.Scanner;

public class RaceApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);

        Integer numberOfCar = inputView.queryIntegerInputWithPrompt("자동차 대수는 몇 대 인가요?\n");
        Integer numberOfTrial = inputView.queryIntegerInputWithPrompt("시도할 회수는 몇 회 인가요?\n");
        Race race = new Race(numberOfCar, numberOfTrial);
    }
}
