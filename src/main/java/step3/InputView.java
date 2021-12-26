package step3;

import java.util.Scanner;

public class InputView {

    private static String sc = new Scanner(System.in).nextLine();
    private Cars cars = new Cars();
    private Game game = new Game();
    /*TODO : 각각의 메소드에서 스캐너로 사용자의 값을 입력받고 리턴하면 불필요한 변수임.
        Game game = new Game(5);

        public static int carCount;
        public static int roundCount;*/


    public void viewCountCar(){
        System.out.println(cars.getSize());
    }


    public void viewCountRound(){
        System.out.println(game.roundCount);
    }

    public void inputCarCount(){
        Cars cars = new Cars(Integer.parseInt(sc));
    }

    public void inputRoundCount(){
        Game game = new Game(Integer.parseInt(sc));
    }

    public void inputScanUn(){
        System.out.println("자동차 대수는 몇 대 인가요?");
        inputCarCount();
        System.out.println("시도할 회수는 몇 회 인가요?");
        inputRoundCount();
    }

}