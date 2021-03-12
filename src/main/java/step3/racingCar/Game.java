/*
 * 자동차 경주의 실행(입력)과 출력 및 종료를 담당하는 클래스
 *
 * @author hj-woo
 * @version 1.0
 * */
package step3.racingCar;

import step3.racingCar.domain.Cars;
import step3.racingCar.ui.InputView;
import step3.racingCar.ui.ResultView;

import java.util.ArrayList;

public class Game {
    public static final String[] strs = {"자동차 대수는 몇 대 인가요?", "시도할 회수는 몇 회 인가요?"};
    private final Cars racingCars;
    private final int tryNum;

    /*
     * 게임 생성과 동시에 자동차 대수와 시도할 횟수를 확인하고,
     * GameFactory로부터 자동차 대수만큼의 자동차를 넘겨받는다.
     * */
    public Game(){
        ArrayList<Integer> inputArr = InputView.input(strs);
        racingCars = GameFactory.cars(inputArr.get(0));
        tryNum = inputArr.get(1);
    }

    /*
     * 생성한 자동차들과 시도 횟수를 바탕으로 게임을 진행하고 결과를 출력한다.
     * */
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
