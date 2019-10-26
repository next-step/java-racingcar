package step1;

public class Calculator {

    public int calculateSentence(String sentence){

        String[] dataArr = makeDataArr(sentence);
        return calculateDataArrCurr(dataArr, dataArr.length-1);

    }


    private String[] makeDataArr(String sentence){

        if(isNull(sentence)) throw new IllegalArgumentException();

        String[] dataArr = sentence.split(" ");

        if(isBlank(dataArr)) throw new IllegalArgumentException();
        if(isInvalid(dataArr)) throw new IllegalArgumentException();

        return dataArr;
    }

    private boolean isNull(String sentence) {
        if(sentence == null) return true;
        return false;
    }

    private boolean isBlank(String[] dataArr) {
        if(dataArr == null) return true;
        if(dataArr.length == 0) return true;
        return false;
    }

    private boolean isInvalid(String[] dataArr) {
        if(isEvenLength(dataArr)) return true;
        if(isOddDataButNotNumber(dataArr)) return true;
        if(isEvenDataButNotSymbol(dataArr)) return true;
        return false;
    }

    private boolean isEvenLength(String[] dataArr){
        return (dataArr.length%2 == 0);
    }

    private boolean isOddDataButNotNumber(String[] dataArr){
        for(int i=0; i<dataArr.length; i+=2){
            if(!dataArr[i].matches( "^[0-9]+$")) return true;
        }
        return false;
    }

    private boolean isEvenDataButNotSymbol(String[] dataArr){
        for(int i=1; i<dataArr.length-1; i+=2){
            if(!dataArr[i].matches( "^[*\\-+\\/]{1}+$")) return true;
        }
        return false;
    }

    private int calculateDataArrCurr(String[] dataArr, int pointer){
        if(pointer == 0) return Integer.parseInt(dataArr[0]);

        String symbol = dataArr[pointer-1];
        int beforeResult = calculateDataArrCurr(dataArr, pointer-2);
        int newInt = Integer.parseInt(dataArr[pointer]);
        return symbolCalculator(symbol, beforeResult, newInt);
    }

    private int symbolCalculator(String symbol, int a, int b){
        switch (symbol) {
            case "+": return plus(a, b);
            case "-": return minus(a, b);
            case "*": return multiple(a, b);
            default: return division(a, b);
        }
    }

    private int plus(int a, int b){
        return a+b;
    }

    private int minus(int a, int b){
        return a-b;
    }

    private int multiple(int a, int b){
        return a*b;
    }

    private int division(int a, int b){
        return a/b;
    }

}
