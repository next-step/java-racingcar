package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    private final List<Car> carModelList;
    private final Random random;
    private MessageBox messageBox;

    public Racing(MessageBox messageBox) {
        this.carModelList = new ArrayList<>();
        this.random = new Random();
        this.messageBox = messageBox;
    }

    public List<Car> createCarByRacing(String totalCarNumber) {
        int totalCarSize = intValueByScanner(totalCarNumber);
        for (int i = 0; i < totalCarSize; i++) {
            Car carModel = new Car(i + 1);
            carModelList.add(carModel);
        }
        return carModelList;
    }

    public void tryRacingByCar(String tryraceNumber) {
        int tryRacingCount = intValueByScanner(tryraceNumber);
        messageBox.commonMessageBox("실행 결과");
        for (int i = 0; i < tryRacingCount; i++) {
            racing();
        }
    }

    public void racing() {
        for (Car carModel : carModelList) {
            int resultRacing = carModel.carRacingAct(randomValue());
            messageBox.racingResultMessage(resultRacing);
        }
        messageBox.commonMessageBox("");
    }

    public int intValueByScanner(String scannerValue) {
        int intValue = toInt(scannerValue);
        messageBox.commonMessageBox(scannerValue);
        return intValue;
    }

    public int toInt(String inputValue) {
        validByNumberCheck(inputValue);
        return Integer.parseInt(inputValue);
    }

    public void validByNumberCheck(String inputValue) {
        String regExp = "^\\d+$";
        if (!inputValue.matches(regExp)) {
            throw new IllegalArgumentException("해당 문자는 숫자만 사용 가능합니다.");
        }
    }

    public int randomValue() {
        int RANDOM_VALUE = 10;
        return random.nextInt(RANDOM_VALUE);
    }
}
