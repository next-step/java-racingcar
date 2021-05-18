package racing;

import java.util.Arrays;

public class Cal {

    private static String[] array = {"+","-","*","/"};

    public String[] calsachicInput(String[] splitresult){
        System.out.println("*****************************");
        System.out.println("사칙연산저장");
        String[] result = new String[splitresult.length];
        for(int i = 0 ;i<splitresult.length;i++) {
            if (splitresult[i].equals("+")) {
                result[i] = "+";
                System.out.println(result[i]);
            }
            else if(splitresult[i].equals("-")){
                result[i] = "-";
                System.out.println(result[i]);
            }
            else if(splitresult[i].equals("*")){
                result[i] = "*";
                System.out.println(result[i]);
            }
            else if(splitresult[i].equals("/")){
                result[i] = "/";
                System.out.println(result[i]);
            }
        }
        result = getoutNull(result);
        return result;
    }

  //  String sampleword ="2 + 3 * 4 / 2";

    public String[] splitWord(String sampleword){
        sampleword =  sampleword.replaceAll(" ", "");
        String[] arr = new String[sampleword.length()];

        for (int i = 0; i < sampleword.length(); i++) {
            arr[i] = sampleword.substring(i,i+1);

        }


        return arr;
    }

    public String[] extraction(String[] splitresult) {
        System.out.println("*****************************");
        String[] result = new String[splitresult.length];
        for(int i = 0 ;i<splitresult.length;i++) {
            if (!splitresult[i].equals("+") && !splitresult[i].equals("-") &&
                    !splitresult[i].equals("*")  && !splitresult[i].equals("/") ){
                result[i] = splitresult[i];
            }

        }
        result =  getoutNull(result);

        for (int i = 0; i < result.length; i++) {
            System.err.println(result[i]);
        }
        return result;
    }


    public String docal(String[] sachicresult, String[] numberresult) {
        String result = null;
        int donum = 0;
        int []number = new int[numberresult.length];
        for (int i = 0; i < numberresult.length; i++) {
            number[i] = Integer.parseInt(numberresult[i]);
        }

        for (int i = 0; i < sachicresult.length; i++) {
            if(sachicresult[i].equals("+")){
               number[i+1] = add(number[i],number[i+1]);
            }else if(sachicresult[i].equals("-")){
                number[i+1] = sub(number[i],number[i+1]);
            }else if(sachicresult[i].equals("*")){
                number[i+1] = mul(number[i],number[i+1]);
            }else if(sachicresult[i].equals("/")){
                number[i+1] = mol(number[i],number[i+1]);
            }
        }
        donum = number[sachicresult.length];
        return String.valueOf(donum);
    }


    public int add(int a, int b) {
        int result = a + b;
        return result;
    }

    public int sub(int a, int b) {
        int result = a - b;
        return result;
    }

    public int mul(int a, int b) {
        int result = a * b;
        return result;
    }

    public int mol(int a, int b) {
        int result = a / b;
        return result;
    }

    public String[] getoutNull(String[] result){
        result = Arrays.stream(result)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);
        return result;
    }
}
