package study.step3;

import study.step3.dto.Input;
import study.step3.move.Move;
import study.step3.move.RandomlyMove;

import java.util.*;

public class CarRacing {


    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        resultView.print(racing(inputView.enter(), new RandomlyMove()));

    }

    public static String[][] racing(Input input, Move move) {
        int carNum = input.getCarNum();
        int tryNum = input.getTryNum();
        String[][] positionArr = new String[tryNum][carNum];

        for (String[] row : positionArr) {
            Arrays.fill(row, "-");
        }

        for (int i = 1; i < tryNum; i++) {
            for (int j = 0; j < carNum; j++) {
                if (move.isSuccess()){
                    positionArr[i][j] = positionArr[i - 1][j] + "-";
                }
            }
        }

        return positionArr;
    }
}
