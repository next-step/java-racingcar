package step4;
import java.util.List;
import java.util.Scanner;

public class RacingGame {

    public static void main(String[] args) {

        InputView inputView = new InputView(new Scanner(System.in));
        inputView.getUserInput();
        Cars cars = new Cars(inputView.getnameList());

        OutputView outputView = new OutputView();
        DiceWithRandom dice = new DiceWithRandom();
        for (int time = 0; time < inputView.getInputTime(); time++) {

            cars.playGame(dice);
            List<Integer> positionList = cars.getPositionList();
            outputView.resultPrint(positionList);
            System.out.println("============" + (time + 1) + "실행 끝==================");
        }
    }


}
