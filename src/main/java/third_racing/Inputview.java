package third_racing;

import java.util.List;
import java.util.Scanner;

public class Inputview {
    private static final int RACING_CAR_MIN_NO = 1;

    public Inputview() {
    }

    public int userCarNoInput() {
        int carNo = carNoInput();
        if (!validationCheck(carNo)) return 0;

        return carNo;
    }

    public static int carNoInput() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public List<Car> userTryNoInput(int carNo) {
        CarAction carAction = new CarAction();

        int tryNo = tryNoInput();
        if (!validationCheck(tryNo)) return null;

        return carAction.moveCar(carNo, tryNo);
    }

    public static int tryNoInput() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


    public boolean validationCheck(int input) {
        if (input < RACING_CAR_MIN_NO ){
            throw new IllegalArgumentException("1 이상의 숫자를 입력하세요");
        }
        return true;
    }

}