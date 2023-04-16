# next-step cleancode 16기 김동훈
- 개요 : 코드리뷰사항 정리

## PR 링크 정리
- step1 : https://github.com/next-step/java-racingcar/pull/4253
- step2 : https://github.com/next-step/java-racingcar/pull/4284
- step3 : https://github.com/next-step/java-racingcar/pull/4323
- step4 : 
- step5 : undefined

## 리뷰사항 정리 (step3)

### 1차 리뷰사항
```text
몇 가지 의견 드립니다. 👍 당부말씀도 함께 드리겠습니다.

미션을 접근하시는 방식이 너무 복잡하고, 어렵습니다. AutomobileFederation 과 같은 클래스는 설계의 의도를 쉽게 이해하기 어렵습니다.
쉽고 단순하게 접근하는 것을 추천드립니다. 우리가 설계하는 자동차 경주에는 "자동차" 와 "경주" 만 있으면 됩니다. 그게 답니다. 그 이상의 무언가가 필요없습니다.
메소드의 리턴 타입이 Map 인 것 치고 좋은 설계인 경우를 거의 못 보긴 했습니다. 클래스 분리를 두려워 마시고 적극적으로 시도해 보시기 바랍니다.
질문에 대한 답변은 별도 댓글로 드리겠습니다. 🙇
```

### 과도하게 복잡한 자료구조

```
public Map<Round, List<Score>> racingStart(int participate, int iterations) {
```

- Round 가 List<Score> 도 관리하면 안 되나요? 이 메소드의 리턴 타입을 보고, 그런 생각이 들었습니다.
  - Round가 결정되면 그에 해당하는 List 가 결정되도록 하는 구조를 가져가고 싶은데요, Round가 결정되면 그에 해당하는 List 를 관리하는 책임을 외부에 노출시켜서 복잡도가 올라간거같습니다.
  - List 를 관리하는 책임을 Round 내부로 이동시키는 방향으로 수정

### Model(혹은 Domain) 간의 관계 정리 필요

```text
private final Map<Round, List<Score>> roundToScoreListMap;
private final Map<Round, Record> roundToRecordMap;
```
- Round -> Record -> Score 간의 관계 정립이 좀 되어야 할 것 같다는 생각이 듭니다.
- 제가 보기엔, Record Score 모두 Round 가 관리하면 되는 정보들입니다.
  - 네 맞습니다 Round가 결정되면 Score, Record 모두 결정되므로 Round 의 책임으로 괸리하는 방향이 맞는듯 합니다
  - Round 가 관리하는 정보들로 수정

### 데이터의 저장과 출력형태표현 의 구분
```text
public class Record {
    private final List<String> recordStringList;
```
- 자동차 경주의 기록이라는 "데이터"가 처음부터 문자열일 수 있나요? 요게 좀 마음에 걸립니다.
- 문자열은 "표현"의 형태일 것 같은데 어떻게 생각하시나요?
- (해설1) : 자동차 경주기록은 어디까지 움직였는지 숫자로 저장되어야 함. 
- (해설2) : 문자열로 경주기록이 표현되는거라고 해서, 꼭 데이터 저장을 문자로 할필요 없음
- (해결3) : 모델에서는 >> 데이터는 어떻게 자료를 저장해야하는지만 고민하고, 표현에서는 저장된 데이터를 어떻게 표시할지만 고민하면 된다





### 이외
- 괄호 안에서 tab size가 8로 들어가는 것 같아서 해당 부분 수정함 : 인텔리제이 기본값에서 4로 수정
- 메소드의 정확한 기능과, public 이라는 노출 수준이 맞는지 고민필요함
- 빈 문자열의 의미없는 추출
```
public class AutomobileFederation {
    private static final String INITIAL_RACING_RECODE = "";
```
- 만약 View 자체에 대한 테스트를 시도하신 거라면, 그 레이어에 대한 테스트는 무의미합니다. 비즈니스 로직에 대한 테스트에 집중하면 됩니다.
```text
출력레이어 테스트 무의미함 (presentation 혹은 view 라는 것들) >> 순수하게 출력만 해라
비지니스 로직 테스트에 집중하기
```