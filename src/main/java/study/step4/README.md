## 4단계 - 자동차 경주(우승자)

### 기능 요구사항
* 각 자동차에 이름을 부여, 자동차 이름은 **<span style="color:red">*5자*</span>** 를 초과할 수 없음
* 전진하는 자동차를 출력할 때 ***자동차 이름***을 같이 **<span style="color:blue">*출력*</span>**
* 자동차 이름은 쉼표(,)를 기준으로 구분
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. **<span style="color:blue">*우승자는 한명 이상일 수 있음*</span>**


> 실행결과
* 위 요구사항에 따라 3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.
```text
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
crong : -
honux : -

pobi : --
crong : -
honux : --

pobi : ---
crong : --
honux : ---

pobi : ----
crong : ---
honux : ----

pobi : -----
crong : ----
honux : -----

pobi : -----
crong : ----
honux : -----

pobi, honux가 최종 우승했습니다.
```

---
### 이외의 요구사항은 step3와 동일
