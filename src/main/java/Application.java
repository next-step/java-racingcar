import calculatorFunction.GetInput;

public class Application {
    public static void main(String[] args) {
        System.out.println("수식을 입력하시오: ");
        String str = GetInput.inputString();
        String[] stringArray = str.split(" ");
        for(int i=0; i< stringArray.length; i++){
            System.out.println(stringArray[i]);
        }
        //int result = calculate(stringArray);
    }
}
