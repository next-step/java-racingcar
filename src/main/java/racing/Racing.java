package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    private final int RANDOM_VALUE = 10;
    private List<Car> carModelList;
    private Random random;

    public Racing() {
        this.carModelList = new ArrayList<>();
        this.random = new Random();
    }

    public List<Car> createCarByRacing(String totalCarNumber) {
        int toalCarSize = intValueByScanner(totalCarNumber);
        for (int i = 0; i < toalCarSize; i++) {
            Car carModel = new Car(i + 1);
            carModelList.add(carModel);
        }
        return carModelList;
    }

    public void tryRacingByCar(String tryraceNumber) {
        int tryRacingCount = intValueByScanner(tryraceNumber);
        System.out.println("실행 결과");
        for (int i = 0; i < tryRacingCount; i++) {
            racing();
        }
    }

    public void racing() {
        for (Car carModel : carModelList) {
            carModel.carRacingAct(RANDOM_VALUE);
        }
        System.out.println();
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

    public int randomValue() {
        return random.nextInt(RANDOM_VALUE);
    }
}
