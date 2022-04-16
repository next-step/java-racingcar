package racing.module;

import exception.CustomException;

public class CarName {
    private static int LENGTH_LIMIT = 5;
    private String name;

    private CarName() throws CustomException {
        throw new CustomException("자동차의 이름없이 생성이 불가능합니다.");
    }

    public CarName(String name) {
        try {
            validName(name);
        } catch(Exception ignored){

        }
        this.name = name;
    }

    private void validName(String name) throws CustomException {
        if (name.isEmpty()) {
            throw new CustomException("공백 자동차 이름은 허용하지 않습니다.");
        }
        if (name.length() > LENGTH_LIMIT) {
            throw new CustomException("자동차 이름이 적합하지 않습니다. 이름 : " + name);
        }
    }

    public String getName() {
        return name;
    }
}
