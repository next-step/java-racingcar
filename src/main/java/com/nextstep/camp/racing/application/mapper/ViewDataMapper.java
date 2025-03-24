package com.nextstep.camp.racing.application.mapper;

import java.util.*;
import java.util.stream.Collectors;

import com.nextstep.camp.racing.application.dto.*;
import com.nextstep.camp.racing.common.vo.PositiveInteger;
import com.nextstep.camp.racing.domain.exception.InvalidTypeException;
import com.nextstep.camp.racing.domain.exception.UtilInstantiationException;
import com.nextstep.camp.racing.infrastructure.view.ViewData;

public class ViewDataMapper {

    private static final String QUANTITY_FIELD_NAME = "quantity";
    private static final String MAX_POSITION_FIELD_NAME = "maxPosition";

    private ViewDataMapper() {
        throw new UtilInstantiationException();
    }

    public static RacingRequest toRacingRequest(ViewData viewData) {
        if (viewData.get(QUANTITY_FIELD_NAME).getClass() != String.class || viewData.get(MAX_POSITION_FIELD_NAME).getClass() != String.class) {
            throw new InvalidTypeException();
        }
        PositiveInteger quantity = PositiveInteger.of((String) viewData.get(QUANTITY_FIELD_NAME));
        PositiveInteger maxPosition = PositiveInteger.of((String) viewData.get(MAX_POSITION_FIELD_NAME));
        return RacingRequest.of(quantity, maxPosition);
    }

    public static ViewData toViewData(RacingResponse racingResponse) {
        Map<String, Object> data = new HashMap<>();

        List<ViewData> carDataList = racingResponse.getCars().stream()
            .map(ViewDataMapper::toViewData)
            .collect(Collectors.toList());

        data.put("cars", carDataList);
        return ViewData.of(data);
    }

    private static ViewData toViewData(CarResponse carResponse) {
        Map<String, Object> data = new HashMap<>();

        List<Boolean> moves = carResponse.getMoves().stream()
            .map(MoveResponse::isMove)
            .collect(Collectors.toList());

        data.put("moves", moves);
        return ViewData.of(data);
    }
}
