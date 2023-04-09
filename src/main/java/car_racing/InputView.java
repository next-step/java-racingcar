package car_racing;

import java.util.Scanner;

public class InputView {
    public static final int INVAlID_NUMBER = 0;
    Scanner scanner = new Scanner(System.in);

    public String value = null;
    public int number = INVAlID_NUMBER;

    private void saveValue(){
        value = scanner.nextLine();
    }

    private void saveNumber(){
        number = scanner.nextInt();
    }

    void run(){
        System.out.println("자동차 대수는 몇 대 인가요?");
        saveValue();
        System.out.println("시도할 회수는 몇 회 인가요?");
        saveNumber();
    }
}
