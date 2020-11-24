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
            count = branch(i, list, move, count);
        }
        System.out.println();
    }

    public int branch(int i ,List<String> list, int move, int count){
        int result = count;
        if(list.get(i).equals("")){
            result++;
        }
        if(result == move){
            printWinner(list);
        }
        return result;
    }

    public void printMove(String board){
        if(!board.equals("")){
            String[] temp = board.split(" : ");
            System.out.print(temp[0] + " : ");
            int move = Integer.valueOf(temp[1]);
            printLoacation(move);
        }
    }

    public void printLoacation(int move){
        for(int j = 0; j < move; j++){
            System.out.print("-");
        }
    }

    public void printWinner(List<String> list){
        List<Integer> tempList = new ArrayList<>();
        for(int k = 0; k < list.size(); k++){
            tempList.add(Integer.valueOf(checkScore(list.get(k))));
        }
        HashSet<String> winer = getWinner(list, tempList);
        System.out.println(winer + " 가 최종 우승했습니다.");
    }

    public String checkScore(String score){
        String temp = null;
        if(!score.equals("")){
            temp = score.split(" : ")[1];
        }
        if(score.equals("")){
            temp = "0";
        }
        return temp;
    }

    public HashSet<String> getWinner(List<String> list, List<Integer> tempList){
        int max = Collections.max(tempList);
        List<String> winnerList = new ArrayList<>(); 
        for(int l = 0; l < list.size(); l++){
            winnerList.add(chooseWinner(list.get(l), max));
        }
        while (winnerList.remove(null));
        HashSet<String> dedupl = new HashSet<String>(winnerList);
        return dedupl;
    }

    public String chooseWinner(String racer, int score){
        String winner = null;
        if(!racer.equals("") && racer.split(" : ")[1].contains(String.valueOf(score))){
            winner = racer.split(" : ")[0];
        }
        return winner;
    }

}
