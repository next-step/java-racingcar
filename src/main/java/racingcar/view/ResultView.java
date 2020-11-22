package racingcar.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ResultView {

    public void racingResult(List<String> list){
        int count = 0;
        int move = Integer.valueOf(list.get(0).split(" : ")[2]);
        System.out.println("실행 결과");
        for(int i = 0; i < list.size(); i++){
            printMove(list.get(i));
            System.out.println();
            if(list.get(i).equals("")){
                count++;
            }
            if(count == move){
                printWinner(list);
            }
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

    public void printWinner(List<String> list){
        List<Integer> tempList = new ArrayList<>();
        for(int k = 0; k < list.size(); k++){
            if((!list.get(k).equals(""))){
                String[] temp = list.get(k).split(" : ");
                tempList.add(Integer.valueOf(temp[1]));
            }
        }
        HashSet<String> winer = getWinner(list, tempList);
        System.out.println(winer + " 가 최종 우승했습니다.");
    }

    public HashSet<String> getWinner(List<String> list, List<Integer> tempList){
        int temp = Collections.max(tempList);
        List<String> winnerList = new ArrayList<>(); 
        for(int l = 0; l < list.size(); l++){
            if(!list.get(l).equals("") && list.get(l).split(" : ")[1].contains(String.valueOf(temp))){
                winnerList.add(list.get(l).split(" : ")[0]);
            }
        }
        HashSet<String> dedupl = new HashSet<String>(winnerList);
        return dedupl;
    }

}