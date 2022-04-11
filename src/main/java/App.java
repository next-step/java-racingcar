import racingcar.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    static final InputView inputView = new InputView();

    public static void main(String[] args) {
        List<Integer> inputDataList = new ArrayList<>();

        inputDataList = inputView.printInput();

    }

}
