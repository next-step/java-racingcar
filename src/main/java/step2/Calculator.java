package step2;

// TODO 사칙연산 수행하는 계산기 구현
/*
 - 반드시 빈 공객 문자열있다고 가정
 - 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정
 - 문자열 계산기는 계산 우선순위가 아닌 입력값에 따라 계산순서가 결정
 - 사칙연산의 계산 우선순위가 아니라 입력값에 따라 계산 순서가 결정되는것으로 결정
 */
public class Calculator {
    public static void main(String[] args) {
        String data = "2 + 3 * 4 / 2";
        System.out.println(calculator(data));
    }

    public static int calculator(String data) {
        String[] arr = data.split(" ");
        int result = Integer.parseInt(arr[0]);
        if(hasNotNullOrNotEmpty(arr)){
            for (int i = 1; i < arr.length; i=i+2) {
                switch(arr[i]){
                    case "+":
                        result = add(result, arr[i+1]);
                        break;
                    case "-":
                        result = minus(result, arr[i+1]);
                        break;
                    case "*":
                        result = multiple(result, arr[i+1]);
                        break;
                    case "/":
                        result = divide(result, arr[i+1]);
                        break;
                    default:
                        throw new IllegalArgumentException(i+"번째 요소가 기호가 아닙니다.");
                }
            }
        }
        return result;
    }

    public static boolean hasNotNullOrNotEmpty(String[] arr){
        for (String s : arr) {
            if(s==null || s.equals(" ")){
                throw new IllegalArgumentException("Null 값 또는 빈 값을 갖고있습니다.");
            }
        }
        return true;
    }

    public static int add(int num1, String num2){
        return num1+Integer.parseInt(num2);
    }

    public static int minus(int num1, String num2){
        return num1-Integer.parseInt(num2);
    }

    public static int multiple(int num1, String num2){
        return num1*Integer.parseInt(num2);
    }

    public static int divide(int num1, String num2){
        return num1/Integer.parseInt(num2);
    }

}
