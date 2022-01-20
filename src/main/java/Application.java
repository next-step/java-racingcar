import calculatorFunction.Calculator;
import calculatorFunction.GetInput;
import racingcar.IOclass;
import java.util.Scanner;
import racingcar.Race;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열 계산기를 사용하시려면 1, 자동차 경주를 사용하시려면 2를 눌러주세요.");
        int flag=sc.nextInt();
        if(flag==1) {
            System.out.println("수식을 입력하시오: ");
            String str = GetInput.inputString();
            str = str.replace(" ", "");
            String[] stringArray = GetInput.parsing(str);
            Calculator calculator = new Calculator();
            calculator.calculate(stringArray);
        }
        if(flag==2){
            String[] carNames = IOclass.getName();
            if(!IOclass.checkCarName(carNames)){
                System.out.println("자동차 이름은 5자를 초과할 수 없습니다.");
                return ;
            }
            Race race = new Race();
            int[] cars = new int[carNames.length];
            int times = IOclass.getTimes();
            while((times--)>0){
                for(int i=0; i< cars.length; i++){
                    int randomNumber=race.getRandomNumber();
                    race.compareWithFour(cars,i,randomNumber);
                }
                IOclass.printCurrent(carNames, cars);
                System.out.println();
            }
            IOclass.printWinners(carNames, cars);
        }
    }
}
