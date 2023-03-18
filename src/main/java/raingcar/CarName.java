package raingcar;

public class CarName {
    final String name;
    public CarName (String carName) {
        name = carName.trim();
        if (name.length() > 5)
            throw new RuntimeException("자동차 이름은 5자 이하 입니다.");
    }

    public String getName() {
        return  name;
    }
}
