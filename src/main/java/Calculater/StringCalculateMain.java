package Calculater;

public class StringCalculateMain {

    public static StringCalculaterExcuteClass stringCalculaterExcuteClass = new StringCalculaterExcuteClass();

    public static void main(String[] args) {

        String [] numberAndOperator = "2 + 3 * 4 / 2".split(" ");

        int result =0;

        for(int i=0 ; i<=numberAndOperator.length/2+2; i+=2){
            if(result == 0){
                result = stringCalculaterExcuteClass.result(numberAndOperator[i+1] , Integer.parseInt(numberAndOperator[i]), Integer.parseInt(numberAndOperator[i+2]));
            }else{
                result = stringCalculaterExcuteClass.result(numberAndOperator[i+1] ,result, Integer.parseInt(numberAndOperator[i+2]));
            }
        }

        System.out.println("결과값:"+result);
    }

}
