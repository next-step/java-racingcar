package step2;

import java.util.*;

public class Calculator {
    private Deque<Object> express = new LinkedList<>();

    public Calculator(String s) {
        this.splitData(s);
    }

    private void splitData(String s) {
        String[] lines = s.split(" ");
        this.saveData(lines);
    }

    private void saveData(String[] lines) {
        for(String line : lines){
            if(isNum(line)){
                express.add(Integer.valueOf(line));
            }else{
                express.add(Operation.of(line));
            }
        }
    }

    private boolean isNum(String line) {
        try{
            Integer.valueOf(line);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }

    public int calculate(){
        int result=0;
        return result;
    }

    public boolean isPossibleCal(){

        return true;
    }
}
