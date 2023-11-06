package me.namuhuchutong.step4;

import static java.util.Collections.*;

import java.util.List;

public class UserInputInterceptor {

    public UserInputInformation handleUserInput(UserRequest request) {
        List<String> names = StringParser.parse(request.getNames());
        CarNames carNames = CarNames.from(unmodifiableList(names));
        return new UserInputInformation(carNames, request.getTimes());
    }
}
