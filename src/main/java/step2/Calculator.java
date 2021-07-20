package step2;


import java.util.*;

public class Calculator {
    private Deque<Object> express = new LinkedList<>();

    public Calculator(String s) {
        this.splitData(s);
    }

    private void splitData(String s) {
        if(s == null || " ".equals(s) || "".equals(s)){
            throw new IllegalArgumentException("입력 문자 공백 or null 에러");
        }
        String[] lines = s.split(" ");
        this.saveData(lines);
    }

    private void saveData(String[] lines) {
        for(String line : lines){
            if(isNum(line)){
                express.add(Integer.valueOf(line));
            }else{
                express.add(line);
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
        int result = 0;

        isCollectSyntax(express);

        while(express.size() > 2){

            Integer num1 = (Integer)express.poll();
            Operation operator = Operation.of(express.poll().toString());
            Integer num2 = (Integer)express.poll();


            express.addFirst(operator.calcuate(num1,num2));
        }

        if(express.size()==1 && express.getFirst() instanceof Integer){
            result = (Integer)express.getFirst();
        }

        return result;
    }
    public void isCollectSyntax(Deque express){
        if(express.size() < 2 || express.size() % 2 == 0){
            throw new IllegalArgumentException("잘못된 수식");
        }
    }
    public Deque<Object> getExpress() {
        return express;
    }
}
