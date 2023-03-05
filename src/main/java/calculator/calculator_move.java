package calculator;

public class calculator_move extends calucator_abstract{

    public int caculate(String text){

        int result=0;
        int a,b = 0;
        String[] sub_text = text.split("");

        //입력 받은 문자식이 null 이거나 "" 이면 error
        if("".equals(text) ||text==null){
            throw new IllegalArgumentException("입력값이 null이거나 빈 공백 문자일 경우");
        }

        for(int i=0 ; i<text.length(); i++){

            //System.out.println(sub_text[i]+":"+sub_text[i].matches("[0-9]") +" "+ sub_text[i].matches("[+\\-*/]"));
            // 숫자와 사칙연산이 아닌경우 error
            if( sub_text[i].matches("[^0-9]") && !sub_text[i].matches("[+\\-*/]") ){
                throw new IllegalArgumentException("사칙연산 기호가 아닌 경우.");
            }

            if(i==0) result = Integer.parseInt(sub_text[i]);
            if(sub_text[i].matches("[+\\-*/]")){
                b=Integer.parseInt(sub_text[i+1]);
                if("+".equals(sub_text[i])) result=add(result,b);
                if("-".equals(sub_text[i])) result=subtract(result,b);
                if("*".equals(sub_text[i])) result=multiply(result,b);
                if("/".equals(sub_text[i])) result=divide(result,b);
            }
        }
        return result;
    }


    //더하기(+)
    public int add(int a, int b){
        return a+b;
    }

    //뻬기(-)
    public int subtract(int a, int b){
        return a-b;
    }

    //곱하기(*)
    public int multiply(int a, int b){
        return a*b;
    }

    //나누기(/)
    public int divide(int a, int b){
        return a/b;
    }
}
