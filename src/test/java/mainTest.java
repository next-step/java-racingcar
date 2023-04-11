import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class mainTest {

    static InputView inputView = new InputView();
    static ResultView resultView = new ResultView();
    @Test
    @DisplayName("레이싱게임 테스트 자동차대수: 3 시도한 회수 : 5")
    void startRacingCar(){
        inputView.howManyCar();
        int carNumber = 3;
        System.out.println(carNumber);

        inputView.howCountCar();
        int count = 5;
        System.out.println(count);

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

