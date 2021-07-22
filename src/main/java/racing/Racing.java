package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    private final int RANDOM_VALUE = 10;
    private List<Car> carModelList;

    public Racing() {
        this.carModelList = new ArrayList<>();
    }

    public List<Car> createCarByRacing(String totalCarNumber) {
        int toalCarSize = intValueByScanner(totalCarNumber);
        for (int i = 0; i < toalCarSize; i++) {
            Car carModel = new Car(i + 1);
            carModelList.add(carModel);
        }
        return carModelList;
    }

    public int intValueByScanner(String scannerValue) {
        int intValue = toInt(scannerValue);
        System.out.println(scannerValue);
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


    public void tryRacingByCar(int tryraceNumber) {
        System.out.println("실행 결과");
        for (int i = 0; i < tryraceNumber; i++) {
            racing();
        }
    }

    public void racing() {
        for (Car carModel : carModelList) {
            carModel.carRacingAct(RANDOM_VALUE);
        }
        System.out.println();
    }

    public int randomValue() {
        return new Random().nextInt(RANDOM_VALUE);
    }
}
