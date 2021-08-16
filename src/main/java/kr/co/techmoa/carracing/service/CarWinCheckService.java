package kr.co.techmoa.carracing.service;

import java.util.ArrayList;
import java.util.List;

public class CarWinCheckService {

    public List<Integer> checkGameResult(int[] totalCarResult) {
        int max = totalCarResult[0];
        for(int i= 1; i < totalCarResult.length; i++) {
            max = maxExtract(totalCarResult , i , max);
        }
        return checkMax(totalCarResult, max);
    }

    private int maxExtract(int[] totalCarResult, int order , int max) {
        int current= totalCarResult[order];
        if(current>= max){
            return current;
        }
        return max;
    }

    private List<Integer> checkMax(int[] totalCarResult , int max) {
        List<Integer> winList = new ArrayList<>();
        for(int i= 0; i < totalCarResult.length; i++) {
            if(totalCarResult[i] == max) {
                winList.add(i);
            }
        }
        return winList;
    }

    private int insertTotalCarResult(int position, int max) {
        if(position == max) {

        }
        return position;
    }
}
