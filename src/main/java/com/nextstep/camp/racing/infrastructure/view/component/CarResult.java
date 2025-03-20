package com.nextstep.camp.racing.infrastructure.view.component;

import java.util.List;

import com.nextstep.camp.racing.domain.exception.ViewDataNotFoundException;
import com.nextstep.camp.racing.infrastructure.view.ViewData;

public class CarResult extends AbstractResult {

    private final MovesResult movesResult;

    private CarResult(ViewData viewData) {
        super(DEFAULT_VALUE);
        validate(viewData);
        List<Boolean> moves = (List<Boolean>) viewData.get("moves");
        this.movesResult = MovesResult.of(moves);
    }

    private static void validate(ViewData viewData) {
        if (viewData == null) {
            throw new ViewDataNotFoundException();
        }
        if (viewData.get("moves") == null) {
            throw new ViewDataNotFoundException();
        }
        if (!(viewData.get("moves") instanceof List<?>)) {
            throw new ViewDataNotFoundException();
        }
    }

    public static CarResult of(ViewData viewData) {
        return new CarResult(viewData);
    }

    @Override
    public String getName() {
        return "carResult";
    }

    @Override
    public String getLabel() {
        return "";
    }

    public List<String> getLabHistory() {
        return movesResult.getLabHistory();
    }

    @Override
    public void action() {
        // No action needed for CarResult
    }
}
