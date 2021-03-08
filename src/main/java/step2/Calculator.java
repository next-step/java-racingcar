package step2;

public class Calculator {
    public static int calculator(String data) {
        String[] arr = data.split(" ");
        int result = Integer.parseInt(arr[0]);
        if(hasNotNullOrNotEmpty(arr)){
            result = getResult(arr);
        }
        return result;
    }

    public static int getResult(String[] arr){
        int result = Integer.parseInt(arr[0]);
        for (int i = 1; i < arr.length; i=i+2) {
            if(arr[i].equals("+")) result = add(result, arr[i+1]);
            if(arr[i].equals("-")) result = minus(result, arr[i+1]);
            if(arr[i].equals("*")) result = multiple(result, arr[i+1]);
            if(arr[i].equals("/")) result = divide(result, arr[i+1]);
        }
        return result;
    }

    public static boolean hasNotNullOrNotEmpty(String[] arr){
        for (String s : arr) {
            if(s==null || s.equals(" ")) throw new IllegalArgumentException("Null 값 또는 빈 값을 갖고있습니다.");
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
