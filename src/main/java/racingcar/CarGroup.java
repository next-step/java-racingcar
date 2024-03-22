package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarGroup {

    static final private Random random = new Random();
    private final List<Car> carGroup;

    public CarGroup(String names) {
        String[] splitNames = SplitNames(names);
        carGroup = new ArrayList<>();
        for (String name : splitNames) {
            carGroup.add(new Car(name));
        }
    }

    /* 이름 분리에 관한 메서드가 CarGroup에 있는게 찝찝하다.
     * 왜냐면 Name 클래스의 입력 제한을 CarGroup이 판단하기 때문이다.
     * 하지만 split함수를 사용해야 하기 때문에 Name 안에 해당 로직을 넣는 것은 불가능하다.
     * 그렇다고 NameGroup을 만들면 CarGroup이 NameGroup까지 의존하게 되고
     * 그럼 CarGroup의 클라이언트가 알아야 하는 게 너무 많아지는 것 같다.
     * 따라서 CarGroup 내에 이를 구현하였다.
     */

    public String[] SplitNames(String names) {
        String[] splitNames = names.split(",");

        int countDelimiter = names.length() - names.replace(",", "").length();
        if (splitNames.length <= countDelimiter) {
            throw new IllegalArgumentException("자동차의 이름은 빈칸일 수 없습니다.");
        }

        return splitNames;
    }

    public Car car(int carIndex) {
        return carGroup.get(carIndex);
    }

    public int size() {
        return carGroup.size();
    }

    public int position(int carIndex) {
        return carGroup.get(carIndex).position();
    }

    public String carName(int carIndex) {
        return carGroup.get(carIndex).name();
    }

    public void updateCarGroupPosition() {
        int randomValueBound = 10;
        for (Car car : carGroup) {
            int randomValue = random.nextInt(randomValueBound);
            car.updatePosition(randomValue);
        }
    }

    /*
    * Indent 제한에 맞추기 위해 WinnerNames를 구하는 함수를
    * 아래와 같이 쪼개게 되었는데 좋은 코드는 아닌 거 같습니다.
    * addCarToListIfThisPositionIsMatch의 매개변수가 3개나 되고,
    * 오로지 findWinners 함수에서만 쓰이기 때문입니다.
    * 하지만 이외의 방법이 떠오르지 않아 그냥 push하였습니다.
     */
    public void addCarToListIfThisPositionIsMatch(Car car, int position, List<String> winnerNames) {
        if (car.isMatch(position)) {
            winnerNames.add(car.name());
        }
    }

    public List<String> findWinners() {
        int maxPosition = 0;
        for (Car car : carGroup) {
            maxPosition = car.max(maxPosition);
        }

        List<String> winnerNames = new ArrayList<>();
        for (Car car : carGroup) {
            addCarToListIfThisPositionIsMatch(car, maxPosition, winnerNames);
        }

        return winnerNames;
    }
}
