package step3.racingCar;

import java.util.ArrayList;

public class Game {
    public static final String[] strs = {"자동차 대수는 몇 대 인가요?", "시도할 회수는 몇 회 인가요?"};
    private final Cars racingCars;
    private final int tryNum;

    public Game(){
        ArrayList<Integer> inputArr = InputView.input(strs);
        racingCars = GameFactory.cars(inputArr.get(0));
        tryNum = inputArr.get(1);
    }

    public void play(){
        System.out.println("실행 결과");
        if(tryNum == 0){
            System.out.println("아무런 시도를 하지 않았습니다.");
        }
        for(int i=0; i<tryNum; i++){
            racingCars.tryForward();
            ResultView.printResult(racingCars.checkForward());
            if(i != tryNum){
                System.out.println("**********"+i+"번째 시도");
            }
        }
    }
}
