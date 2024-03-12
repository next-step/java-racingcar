package carRacing.view;

import java.util.Scanner;

public class InputView {

    private int CAR_COUNT;
    private int MOVE_COUNT;

    public InputView() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        setCarCount(scanner);
        System.out.println("시도할 회수는 몇 회 인가요?");
        setMoveCount(scanner);
        scanner.close();
    }

    private void setMoveCount(Scanner scanner) {
        MOVE_COUNT = scanner.nextInt();
        System.out.println("시도할 회수 : " + MOVE_COUNT + "회"); //Test Method에서 실제 입력이 아닌 Method를 통한 입력을 하고 있어 확인하기 위한 문구
    }

    private void setCarCount(Scanner scanner) {
        CAR_COUNT = scanner.nextInt();
        System.out.println("차량 대수 : " + CAR_COUNT + "대"); //Test Method에서 실제 입력이 아닌 Method를 통한 입력을 하고 있어 확인하기 위한 문구
    }

    public int getCarCount() {
        return CAR_COUNT;
    }

    public int getMoveCount() {
        return MOVE_COUNT;
    }
}
