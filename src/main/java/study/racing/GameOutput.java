package study.racing;

import java.util.List;

public class GameOutput {

    public void printResult(){
        System.out.println("실행 결과");

    }
    public void printRound(List<Integer> positions){
        //TODO 추후 구현
        for (Integer position : positions){
            printPosition(position);
        }

    }

    private void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
