package kr.co.techmoa.carracing.ui;

import kr.co.techmoa.carracing.model.OutputDTO;

import java.util.List;

public class ResultView {

    public void printResult(List<OutputDTO> outputDTOs) {
        for(OutputDTO outputDTO1 : outputDTOs){
            outputDTO1.getMove();
        }
    }
}
