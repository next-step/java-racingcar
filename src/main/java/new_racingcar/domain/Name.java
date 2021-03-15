package new_racingcar.domain;

import new_racingcar.constant.MsgConstants;

public class Name {
    private String name;

    public Name(String name) {
        isNameValid(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void isNameValid(String name) {
        if (name.length() > 5
                || name.trim().isEmpty()) {
            throw new IllegalArgumentException(MsgConstants.CAR_NAME_ERROR_MESSAGE);
        }
    }
}
