package calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.LinkedList;
import java.util.Queue;

public  class Calculator {
    private static Queue<String> numberQ  = new LinkedList<>();
    private static Queue<String> stringQ = new LinkedList<>();
    private static String  tmpNumber =  "0";
    private static final ScriptEngineManager manager = new ScriptEngineManager();

    private static void init(){
        numberQ  = new LinkedList<>();
        stringQ = new LinkedList<>();
        tmpNumber =  "0";
    }
    public static String excute(String strings) throws Exception  {
        init();
        strings.chars().filter( value ->  !Character.toString(value).equals(" ") ).forEach(value -> step1((char)value ) );
        strings.chars().filter( value ->  !Character.toString(value).equals(" ") ).forEach(value -> step2((char)value ) );
        calcute();
        return tmpNumber;
    }
    private static void  step1(char chars ){

        if(Character.isDigit(chars)){
            tmpNumber = tmpNumber.concat(Character.toString(chars));
        }else {
            numberQ.add(tmpNumber);
            tmpNumber = "";
        }
    }
    private static void  step2(char chars ){
        if(!Character.isDigit(chars)){
            stringQ.add(Character.toString(chars));
        }
    }

    private static void calcute () throws ScriptException {
        numberQ.add(tmpNumber);
        tmpNumber = numberQ.poll();
        numberQ.stream().forEach(Calculator::accept);
    }

    private static void eval(String number, String cal) throws ScriptException {
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        tmpNumber =  String.valueOf(engine.eval(tmpNumber+cal+number));
    }

    private static void eval2(String number, String cal) throws ScriptException {
        switch (cal){
            case("+"):
                tmpNumber = String.valueOf(add(tmpNumber,number));
                break;
            case("-"):
                tmpNumber = String.valueOf(subtract(tmpNumber,number));
                break;
            case("*"):
                tmpNumber = String.valueOf(multiply(tmpNumber,number));
                break;
            case("/"):
                tmpNumber = String.valueOf(divide(tmpNumber,number));
                break;
        }
    }

    private static void accept(String value)  {
        try {
            eval2(value, stringQ.poll());
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
    }

   private static int add(String a, String b) {
        return Integer.parseInt(a) + Integer.parseInt(b);
   }

   private static int subtract(String a, String b) {
       return Integer.parseInt(a) -Integer.parseInt(b);
   }

   private static int multiply(String a, String b) {
      return Integer.parseInt(a) *  Integer.parseInt(b);
   }

   private static int divide(String a, String b) {
      return Integer.parseInt(a) /  Integer.parseInt(b);
   }
}

