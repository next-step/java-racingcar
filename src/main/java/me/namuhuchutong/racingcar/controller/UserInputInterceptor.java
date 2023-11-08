package me.namuhuchutong.racingcar.controller;

import static java.util.Collections.*;

import java.util.List;
import me.namuhuchutong.racingcar.domain.CarNames;
import me.namuhuchutong.racingcar.dto.UserInputInformation;
import me.namuhuchutong.racingcar.dto.UserRequest;
import me.namuhuchutong.racingcar.util.StringParser;

public class UserInputInterceptor {

    public UserInputInformation handleUserInput(UserRequest request) {
        List<String> names = StringParser.parse(request.getNames());
        CarNames carNames = CarNames.from(unmodifiableList(names));
        return new UserInputInformation(carNames, request.getTimes());
    }
}
