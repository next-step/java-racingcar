package racingcar.view;
import racingcar.Constant;

import java.util.Scanner;

public class InputView {

    Scanner scanner;


    public InputView() {
        this.scanner = new Scanner(System.in);;
    }

    public int carNum(){
        System.out.println(Constant.INPUT_REQUEST_CAR_COUNT);
        return scanner.nextInt();
    }

    public int tryGameNum(){
        System.out.println(Constant.INPUT_REQUEST_PLAY_COUNT);

        return scanner.nextInt();
    }


}
