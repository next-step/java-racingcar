package study.racingcar;

import java.util.List;

public class OutputView {

    public void printRequestTextInitCar(){
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public void printRequestTextInitRound(){
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public void printRoundResult(){
        System.out.println("실행 결과");
    }

    public void printCharListOut(List<Character> characterList){
        characterList.forEach(System.out::print);
        printEnter();
    }

    public void printEnter(){
        System.out.println();
    }
}
