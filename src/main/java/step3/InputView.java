package step3;

import java.util.Scanner;

public class InputView {

    private String sc = new Scanner(System.in).nextLine();
    /*TODO : 각각의 메소드에서 스캐너로 사용자의 값을 입력받고 리턴하면 불필요한 변수임.
    */

    public void viewCountCarInputMessage(){
        System.out.println("자동차 대수는 몇 대인가요?");
    }

    public void viewCountCar(int carsSize){
        System.out.println(carsSize);
    }

    public void viewCountRoundInputMessage(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void viewCountRound(int roundCount){
        System.out.println(roundCount);
    }

    public int inputScanner(){
        return Integer.parseInt(sc);
    }

    public void inputScanUn(){
        System.out.println("자동차 대수는 몇 대 인가요?");
        Cars cars = new Cars(inputScanner());
        System.out.println("시도할 회수는 몇 회 인가요?");
        Game game = new Game(inputScanner());
    }

}