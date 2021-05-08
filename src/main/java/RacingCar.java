import java.util.Scanner;
import java.util.Random;

public class RacingCar {

    Scanner scanner = new Scanner(System.in);

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public int inputRoundNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextInt();
    }

    public String makeResult(String carNames, int roundNumber) {
        String[] carList = splitByComma(carNames);
        int carNumber = carList.length;
        int[] carStep = new int[carNumber];

        outputResult(roundNumber, carNumber, carList, carStep);

        String winnerList = outputWinners(carList, carStep);
        return winnerList;
    }

    private String[] splitByComma(String str) {
        return str.split(",");
    }

    private void outputResult(int roundNumber, int carNumber, String[] carList, int[] carStep) {
        System.out.println("실행 결과");
        for (int i = 0; i < roundNumber; i++) {
            for (int j = 0; j < carNumber; j++) {
                outputStep(j, carList, carStep);
            }
        }
    }

    private void outputStep(int j, String[] carList, int[] carStep) {
        System.out.print(carList[j] + " : ");
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        if (randomNumber >= 4) {
            carStep[j] += 1;
        }
        for (int k = 0; k < carStep[j]; k += 1) {
            System.out.print("-");
        }
    }

    private String outputWinners(String[] carList, int[] carStep) {
        System.out.print("최종 우승자: ");
        int maxScore = 0;
        for (int i = 0; i < carStep.length; i++) {
            if (maxScore < carStep[i]) {
                maxScore = carStep[i];
            }
        }
        String winnerList = "";
        for (int j = 0; j < carStep.length; j += 1) {
            if (carStep[j] == maxScore) {
                //System.out.print(carList[j] + " ");
                winnerList += carList[j] + " ";
            }
        }
        return winnerList;
    }
}
