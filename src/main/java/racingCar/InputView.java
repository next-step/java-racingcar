package racingCar;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static Cars start() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();

        Cars carList = new Cars();
        for(int i=0; i<carCount; i++){
            carList.add(new Car());
        }

        System.out.println("시도할 회수는 몇 회 인가요?");
        int playCount = scanner.nextInt();
        carList.setPlayCount(playCount);

        System.out.println("\n실행 결과");
        return carList;
    }
}
