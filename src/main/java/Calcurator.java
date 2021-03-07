import java.util.ArrayList;

public class Calcurator {


    //더하기
    private int _sum(int a , int b){
        return a+b;
    }
    //뺄셈
    private int _minus(int a , int b){
        return a-b;
    }
    //곱셈
    private int _multiply(int a , int b){
        return a*b;
    }
    //나눗셈
    private int _divide(int a , int b){
        return (int)(a/b);
    }

    void inspect(){

    }


    void execute(String expression){

        String numStr = "";
        String numStr2 = "";
        int num =0;
        int num2 = 0;
        ArrayList<String> saveExp = new ArrayList<>();
        String sign = null;
        int result = 0;
        for(int i=0;i<expression.length();i++){
            char ch = expression.charAt(i);

            if('0'<= ch && ch <= '9'){
                numStr += ch;
            }

            if(ch == ' '){
                saveExp.add(numStr);
                if("+".equals(sign)){
                    result += _sum(Integer.parseInt(saveExp.get(0)), Integer.parseInt(saveExp.get(1)));
                }else if("-".equals(sign)){
                    result += _minus(Integer.parseInt(saveExp.get(0)), Integer.parseInt(saveExp.get(1)));
                }else if("*".equals(sign)){
                    result += _multiply(Integer.parseInt(saveExp.get(0)), Integer.parseInt(saveExp.get(1)));
                }else if("/".equals(sign)){
                    result +=_divide(Integer.parseInt(saveExp.get(0)), Integer.parseInt(saveExp.get(1)));
                }
                saveExp.clear();
                numStr = "";
            }
            if(ch=='+' || ch=='-' || ch=='*' || ch =='/'){
                sign = String.valueOf(ch);
            }
        }
        System.out.println("result == " + result);
    }



    public static void main(String[] args) {
        String expression = "2 + 4";
        new Calcurator().execute(expression);
    }
}
