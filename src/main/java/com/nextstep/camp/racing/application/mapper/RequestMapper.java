package com.nextstep.camp.racing.application.mapper;

import com.nextstep.camp.racing.application.dto.RacingRequest;
import com.nextstep.camp.racing.common.vo.PositiveInteger;
import com.nextstep.camp.racing.domain.exception.UtilInstantiationException;
import com.nextstep.camp.racing.infrastructure.view.ViewData;

public class RequestMapper {

    private static final String QUANTITY_FIELD_NAME = "quantity";
    private static final String MAX_POSITION_FIELD_NAME = "maxPosition";

    private RequestMapper() {
        throw new UtilInstantiationException();
    }

    public static RacingRequest toRacingRequest(ViewData viewData) {
        PositiveInteger quantity = PositiveInteger.of(viewData.get(QUANTITY_FIELD_NAME));
        PositiveInteger maxPosition = PositiveInteger.of(viewData.get(MAX_POSITION_FIELD_NAME));
        return RacingRequest.of(quantity, maxPosition);
    }
}
