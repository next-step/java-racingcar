package camp.nextstep.edu.nextstep8.stub;

import camp.nextstep.edu.nextstep8.racing.rule.ForwardingRule;

public class NotMoveForwardingRuleStub implements ForwardingRule {
    @Override
    public boolean canForward() {
        return false;
    }
}
