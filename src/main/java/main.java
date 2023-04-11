import java.util.Random;
import java.util.Scanner;

public class main {
    static InputView inputView = new InputView();
    static ResultView resultView = new ResultView();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        inputView.howManyCar();
        int carNumber = scanner.nextInt();

        inputView.howCountCar();
        int count = scanner.nextInt();

        resultView.resultMessage();

        //초기화 및 선언
        StringBuffer[] currentCar = new StringBuffer[carNumber];
        for (int i=0; i<carNumber; i++)
            currentCar[i] = new StringBuffer("-");


        for(int i=0; i<count; i++){
            carMove(carNumber, currentCar);

            resultView.printSpace();
        }

    }

    private static void carMove(int carNumber, StringBuffer[] currentCar) {
        for (int j = 0; j< carNumber; j++){
            int randomNumber = getRandomNumber();

            currentCar[j].append(appendCurrentCarOver(4,randomNumber));

            resultView.printCar(currentCar[j]);
        }
    }

    private static String appendCurrentCarOver(int standardNum, int randomNumber) {
        if (standardNum >= 4 )
           return "-";

        return "";
    }

    private static int getRandomNumber() {
        Random random = new Random();

        return random.nextInt(10);
    }
}