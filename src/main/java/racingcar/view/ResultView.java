package racingcar.view;

import java.util.List;

public class ResultView {

    public void racingResult(List<String> list){

        for(int i = 0; i < list.size(); i++){
            String[] temp = list.get(0).split(" : ");
            printMove(list.get(i));
            System.out.println();
        }
        System.out.println();
    }

    public void printMove(String board){
        if(!board.equals("")){
            String[] temp = board.split(" : ");
            System.out.print(temp[0] + " : ");
            int move = Integer.valueOf(temp[1]);
            for(int j = 0; j < move; j++){
                System.out.print("-");
            }
        }
    }

}