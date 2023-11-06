package racingCar;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int intInput(String question){
        System.out.println(question);
        return scanner.nextInt();
    }

}
