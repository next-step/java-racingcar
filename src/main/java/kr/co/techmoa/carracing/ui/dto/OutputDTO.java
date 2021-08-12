package kr.co.techmoa.carracing.ui.dto;

import kr.co.techmoa.carracing.model.Car;

import java.util.List;

public class OutputDTO {

    private List<List<Car>> rounds;
    private List<Integer> winList;

    public List<List<Car>> getRounds() {
        return rounds;
    }

    public OutputDTO(List<List<Car>> rounds , List<Integer> winList) {
        this.rounds = rounds;
        this.winList = winList;
    }

    public List<Integer> getWinList() {
        return winList;
    }
}
