package calculator;

public class Calculator {
    boolean isStringDouble(String toString) {
        try {
            Double.parseDouble(toString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private static String[] array = {"+","-","*","/"};
    int calculatorInput(String sentence){
        int idx = 0;
        for (int i = 0; i <array.length ; i++) {
          if(array[i].equals(sentence)){
              idx = i;
          };
        }/*
        boolean actualValue = numbers.contains(input);
        org.assertj.core.api.Assertions.assertThatCode(() -> {
            assertEquals(false,actualValue);
        });
        */
        return idx;
    }

    String plus (int gubun, int a, int b){
        if(gubun==0){
            return String.valueOf(a+b);
        }
        return null;
    }
    String minus (int gubun, int a, int b){
        if(gubun==1){
            return String.valueOf(a-b);
        }
        return null;
    }
    String multiply (int gubun,int a, int b){
        if(gubun==2){
            return String.valueOf(a*b);
        }
        return null;
    }
    String divide (int gubun,int a, int b){
        if(gubun==3){
            return String.valueOf(a/b);
        }
        return null;
    }

}
