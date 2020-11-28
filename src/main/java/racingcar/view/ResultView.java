package racingcar.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Scoreboard;

public class ResultView {

    public void racingResult(Scoreboard result){
        int move = result.getMove();
        System.out.println("실행 결과");
        for(int i = 0; i < move; i++){
            printMove(result.getRacingCar().getCars(), result.getHistory().getRacingResult().get(i));
            System.out.println();
        }
        System.out.println("");
        printWinner(result.getRacingCar().getCars());
    }

    public void printMove(List<Car> cars, List<Integer> result){
        for(int j = 0; j < cars.size(); j++){
            System.out.print(cars.get(j).getCar() + " : ");
            printLoacation(result.get(j));
        }
    }

    public void printLoacation(int move){
        for(int j = 0; j < move; j++){
            System.out.print("-");
        }
        System.out.println("");
    }

    public void printWinner(List<Car> cars){
        List<Integer> tempList = new ArrayList<>();
        for(int k = 0; k < cars.size(); k++){
            tempList.add(cars.get(k).getLocation());
        }
        
        HashSet<String> winer = getWinner(cars, tempList);
        System.out.println(winer + " 가 최종 우승했습니다.");
    }

    public HashSet<String> getWinner(List<Car> cars, List<Integer> tempList){
        int max = Collections.max(tempList);
        List<String> winnerList = new ArrayList<>(); 
        for(int l = 0; l < cars.size(); l++){
            winnerList.add(chooseWinner(cars.get(l), max));
        }
        while (winnerList.remove(null));
        HashSet<String> dedupl = new HashSet<String>(winnerList);
        return dedupl;
    }

    public String chooseWinner(Car racer, int score){
        String winner = null;
        if(racer.getLocation() == score){
            winner = racer.getCar();
        }
        return winner;
    }

}
