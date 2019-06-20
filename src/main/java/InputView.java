import java.util.List;
import java.util.Scanner;

public class InputView {
    public static RacingGame userInput(List<CarInfo> carInfo) {
        Scanner scanner = new Scanner(System.in);
        String inputCarList;
        String[] carList;
        CarInfo inputCarInfo;

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        inputCarList = scanner.nextLine();
        carList = inputCarList.split(",");

        for (int i = 0; i < carList.length; i++) { //입력받은 자동차 이름을 이용하여 List carInfo에 추가
            inputCarInfo = new CarInfo(carList[i]);
            carInfo.add(inputCarInfo);
        }
        System.out.println("시도할 회수는 몇 회 인가요?");
        int timeofRace = scanner.nextInt();

        return new RacingGame(timeofRace);
    }
}
