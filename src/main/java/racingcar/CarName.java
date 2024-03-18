package racingcar;

public class CarName {
    private String name;

    public CarName(String name) throws Exception{
        if (name.length() > 5) {
            throw new Exception("자동차 이름은 5글자 이내여야 합니다.");
        }
    }
}
