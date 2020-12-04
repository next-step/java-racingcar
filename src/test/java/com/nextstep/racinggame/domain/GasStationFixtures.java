package com.nextstep.racinggame.domain;

public class GasStationFixtures {
    public static final MovePolicy FOUR_FUEL_GAS_STATION = new ForceMovePolicy();
    public static final MovePolicy THREE_FUEL_GAS_STATION = new ForceNotMovePolicy();
}
