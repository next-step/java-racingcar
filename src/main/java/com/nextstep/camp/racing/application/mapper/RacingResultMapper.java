package com.nextstep.camp.racing.application.mapper;

import java.util.concurrent.atomic.AtomicInteger;

import com.nextstep.camp.racing.application.dto.*;

public class RacingResultMapper {

    public static String mapToDisplayFormat(RacingResponse racing) {
        StringBuilder result = new StringBuilder();
        result.append("실행 결과\n");

        racing.getCars()
            .getValues()
            .forEach(
                car -> {
                    String carMoves = mapCarMoves(car.getMoves());
                    result.append(carMoves).append("\n\n");
                });

        return result.toString();
    }

    private static String mapCarMoves(MovesResponse movesResponse) {
        StringBuilder track = new StringBuilder();
        AtomicInteger position = new AtomicInteger(0);

        movesResponse.getValues().stream()
            .map(MoveResponse::isMove)
            .forEach(move -> {
                if (move) {
                    position.getAndIncrement();
                }
                track.append("-".repeat(position.get())).append("\n");
            });
        return track.toString().trim();
    }
}
