package racing.domain;

import java.util.List;
import racing.vo.CarResultVO;

public class RoundResult {

    private final List<CarResultVO> resultVOS;

    public RoundResult(List<CarResultVO> resultVOS) {
        this.resultVOS = resultVOS;
    }

    public List<CarResultVO> getResultVOS() {
        return resultVOS;
    }
}
