package me.namuhuchutong.step4.controller;

import static java.util.Collections.*;

import java.util.List;
import me.namuhuchutong.step4.domain.CarNames;
import me.namuhuchutong.step4.dto.UserInputInformation;
import me.namuhuchutong.step4.dto.UserRequest;
import me.namuhuchutong.step4.util.StringParser;

public class UserInputInterceptor {

    public UserInputInformation handleUserInput(UserRequest request) {
        List<String> names = StringParser.parse(request.getNames());
        CarNames carNames = CarNames.from(unmodifiableList(names));
        return new UserInputInformation(carNames, request.getTimes());
    }
}
