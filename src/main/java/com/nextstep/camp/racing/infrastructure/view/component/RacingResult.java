package com.nextstep.camp.racing.infrastructure.view.component;

import java.util.List;
import java.util.stream.Collectors;

import com.nextstep.camp.racing.domain.exception.ViewDataNotFoundException;
import com.nextstep.camp.racing.infrastructure.view.ViewData;

public class RacingResult extends AbstractResult {

    private final LapHistoryResult lapHistoryResult;

    private static final String RACING_HEADER = "실행 결과";
    private static final String LAB_DELIMITER = "\n";

    private RacingResult(ViewData viewData) {
        super(DEFAULT_VALUE);
        validate(viewData);
        List<?> cars = (List<?>) viewData.get("cars");
        List<CarResult> carResults = cars.stream()
            .filter(obj -> obj instanceof ViewData)
            .map(obj -> CarResult.of((ViewData) obj))
            .collect(Collectors.toList());
        this.lapHistoryResult = LapHistoryResult.of(carResults);
    }

    private static void validate(ViewData viewData) {
        if (viewData == null) {
            throw new ViewDataNotFoundException();
        }
        if (viewData.get("cars") == null) {
            throw new ViewDataNotFoundException();
        }
        if (!(viewData.get("cars") instanceof List<?>)) {
            throw new ViewDataNotFoundException();
        }
    }

    public static RacingResult create(ViewData viewData) {
        return new RacingResult(viewData);
    }

    public String getDisplay() {
        StringBuilder display = new StringBuilder(RACING_HEADER);
        for (List<String> lab : lapHistoryResult.getLaps()) {
            display.append(LAB_DELIMITER);
            for (String car : lab) {
                display.append(car).append("\n");
            }
        }
        return display.toString();
    }

    @Override
    public String getName() {
        return "racingResult";
    }

    @Override
    public String getLabel() {
        return "";
    }

    @Override
    public void action() {
        System.out.println(getDisplay());
    }
}
