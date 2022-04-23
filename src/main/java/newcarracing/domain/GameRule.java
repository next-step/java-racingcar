package newcarracing.domain;

public class GameRule {
    private RuleCondition ruleCondition;

    public boolean checkCondition() {
        return ruleCondition.checkCondition();
    }

    public void setRuleCondition(RuleCondition ruleCondition) {
        this.ruleCondition = ruleCondition;
    }
}
