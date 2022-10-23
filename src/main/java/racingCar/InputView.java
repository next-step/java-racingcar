package racingCar;

import java.util.Scanner;

public class InputView {
    Scanner scan = new Scanner(System.in);

    public int carInput(){
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNum = Integer.parseInt(scan.nextLine());
        return carNum;
    }

    public int tryInput(){
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryNum = scan.nextInt();
        return tryNum;
    }
}
