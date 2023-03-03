package calculator;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public  class SecondCalculator {
    private static Queue<Integer> numberQ  = new LinkedList<>();
    private static Queue<String> stringQ = new LinkedList<>();
    private static int  tmpNumber =  0;

    private static void init(){
        numberQ  = new LinkedList<>();
        stringQ = new LinkedList<>();
        tmpNumber =  0;
    }
    public static int excute(String strings) throws Exception  {
        init();
        String[] stringLst = strings.split(" ");
        Arrays.stream(stringLst).forEach( SecondCalculator::step1 );
        Arrays.stream(stringLst).forEach( SecondCalculator::step2 );

        calcute();
        return tmpNumber;
    }
    private static boolean isNumberic(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
    private static void  step1(String  chars ){
        if(isNumberic(chars)){
            numberQ.add(Integer.parseInt(chars));
        }
    }
    private static void  step2(String chars ){
        if(!isNumberic(chars)){
            stringQ.add(chars);
        }
    }

    private static void calcute ()  {
        tmpNumber = numberQ.poll();
        numberQ.forEach(SecondCalculator::accept);
    }

    private static void eval2(int number, String cal) {
        switch (cal){
            case("+"):
                tmpNumber = add(tmpNumber,number);
                break;
            case("-"):
                tmpNumber = subtract(tmpNumber,number);
                break;
            case("*"):
                tmpNumber = multiply(tmpNumber,number);
                break;
            case("/"):
                tmpNumber = divide(tmpNumber,number);
                break;
        }
    }

    private static void accept(int value)  {
        eval2(value, Objects.requireNonNull(stringQ.poll()));
    }

   private static int add(int a, int b) {
        return a + b;
   }

   private static int subtract(int a, int b) {
       return a -b;
   }

   private static int multiply(int a, int b) {
      return a * b;
   }

   private static int divide(int a, int b) {
      return a /  b;
   }
}

