package racingCar;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private final String question;

    InputView(String question){
        this.question = question;
    }

    public int intInput(){
        System.out.println(this.question);
        return scanner.nextInt();
    }

}
