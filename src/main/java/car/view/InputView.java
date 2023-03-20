package car.view;

import java.util.Scanner;

public class InputView {

    private static Scanner sc;

    public InputView(){
        this.sc= new Scanner(System.in);
    }

    public int getScInt() {
        return sc.nextInt();
    }

    public String getScString() {
        return sc.next();
    }
}
