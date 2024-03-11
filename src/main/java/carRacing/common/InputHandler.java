package carRacing.common;

import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;
    private InputHandler(){
        this.scanner = new Scanner(System.in);
    }
    public static InputHandler of(){
        return new InputHandler();
    }

    public String askCarsNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public int askTrialCount(){
        System.out.println("시도할 회수는 몇 회 인가요?");
        while (!scanner.hasNextInt()){
            scanner.next();
            System.out.println("다시 입력해주세요. (정수)");
        }return scanner.nextInt();
    }

    public void closeScanner() {
        scanner.close();
    }
}
