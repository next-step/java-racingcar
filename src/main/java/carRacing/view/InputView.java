package carRacing.view;

import java.util.Scanner;

public class InputView {

    private int CAR_COUNT;
    private int MOVE_COUNT ;

    private static Scanner scanner = new Scanner(System.in);

    public InputView() {}

    // 테스트용 생성자
    public InputView(int carCount, int moveCount) {
        CAR_COUNT = carCount;
        MOVE_COUNT = moveCount;
    }

    public void setCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        setCarCount(isPassNumber(scanner.nextInt()));
    }

    public void setMoveCount(){
        System.out.println("시도할 회수는 몇 회 인가요?");
        setMoveCount(isPassNumber(scanner.nextInt()));
    }

    public void closeScanner(){
        scanner.close();
    }


    private void setMoveCount(int i) {
        MOVE_COUNT = i;
        System.out.println("시도할 회수 : " + MOVE_COUNT + "회"); //Test Method에서 실제 입력이 아닌 Method를 통한 입력을 하고 있어 확인하기 위한 문구
    }

    private void setCarCount(int i) {
        CAR_COUNT = i;
        System.out.println("차량 대수 : " + CAR_COUNT + "대"); //Test Method에서 실제 입력이 아닌 Method를 통한 입력을 하고 있어 확인하기 위한 문구
    }

    public int getCarCount() {
        return CAR_COUNT;
    }

    public int getMoveCount() {
        return MOVE_COUNT;
    }

    private static int isPassNumber(int number){
        if(number<0){
            throw new IllegalArgumentException(String.format("허용되지 않은 숫자입니다. 입력 값 :[%s]", number));
        }
        return number;
    }
}
