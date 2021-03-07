package racingcar.view;

import java.util.List;

public class ResultView {

    public void printCarGame(int carNum, int position){

        System.out.print(carNum + ":");
        for(int num = 0 ; num < position ; num++){
            System.out.print("-");
        }
        System.out.println("");

    }
}
