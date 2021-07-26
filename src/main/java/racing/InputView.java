package racing;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int readCarCount(){
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        try{
            Validator.validateCarCount(carCount);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readCarCount();
        }
        return carCount;
    }

    public int readMoveCount(){
        System.out.println("시도할 회수는 몇 회 인가요?");
        int moveCount = scanner.nextInt();
        try{
            Validator.validateMoveCount(moveCount);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readMoveCount();
        }
        return moveCount;
    }
}
