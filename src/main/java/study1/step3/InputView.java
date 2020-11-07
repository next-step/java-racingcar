package study1.step3;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;
    InputView(){
        this.scanner = new Scanner(System.in);
    }

    public int getAnswer(String text){
        System.out.println(text);
        return this.scanner.nextInt();
    }

    public void close(){
        this.scanner.close();
    }
}
