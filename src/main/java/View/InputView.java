package View;

import Domain.CarInfo;
import Domain.RacingGame;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public static RacingGame userInput(List<CarInfo> carInfo) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputCarList = scanner.nextLine();
        String[] carList = inputCarList.split(",");
        checkNameOfCar(carList); // 자동차 이름 입력값 정상여부 확인

        CarInfo inputCarInfo;
        for (int i = 0; i < carList.length; i++) { //입력받은 자동차 이름을 이용하여 List carInfo에 추가
            inputCarInfo = new CarInfo(carList[i]);
            carInfo.add(inputCarInfo);
        }
        System.out.println("시도할 회수는 몇 회 인가요?");
        int timeofRace = scanner.nextInt();

        return new RacingGame(timeofRace);
    }

    // 사용자가 입력한 공백 문자 혹은 개행문자가 포함되었는지 체크하는 함수
    public static void checkNameOfCar(String[] inputStrings) {
        for (int i = 0; i < inputStrings.length; ++i)
            if (inputStrings[i].isEmpty() || inputStrings[i].equals(" ") || inputStrings[i].equals("\n"))
                throw new IllegalArgumentException("입력값이 잘못되었습니다. 자동차 이름을 다시 한번 입력해주세요.");
    }
}

