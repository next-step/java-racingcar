package racinggame.controller;

import racinggame.domain.Racing;

import java.util.ArrayList;
import java.util.List;

import static racinggame.dto.WebGameDto.*;

public class RacingWebGame {

    public static void main(String[] args) {
        List<Racing> racings = new ArrayList<>();

        inputNameByGet();

        inputTryGameByPost(racings);

        playGameByGet(racings);
    }
}
