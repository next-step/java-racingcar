import java.util.Scanner;

import domain.Race;
import view.InputView;
import view.ResultView;

public class main {
    public static void main(String[] args) {
        int[] input = InputView.inputView();
        ResultView.outputView(Race.playRace(input));
    }
}
