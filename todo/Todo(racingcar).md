- [X] 랜덤 값이 4이상이면 자동차는 전진한다(5 -> 위치 1증가)
- [X] 랜덤 값이 4보다 작으면 자동차는 이동하지 않는다(3 -> 위치 그대로)
- [X] 자동차 개수를 입력하면 개수에 맞는 자동차가 생성된다.(3 -> 자동차 3개 생성)
- [X] 시도 횟수가 0 또는 음수이면 IllegalArgumentException 예외가 발생한다.(0은 요구사항에 없어서 내가 정한 규칙)
- [X] 시도 횟수가 문자이면 IllegalArgumentException 예외가 발생한다.(시도 입력 -> ";")
- [X] 자동차 개수가 문자이면 IllegalArgumentException 예외가 발생한다.(자동차 개수 입력 -> ";")
- [X] 자동차 개수가 0 또는 음수이면 IllegalArgumentException 예외가 발생한다.(0은 요구사항에 없어서 내가 정한 규칙)





### 4단계 추가 Todo


- [ ] 자동차 이름이 5자가 초과되면 IllegalArgumentException 예외가 발생한다.
- [ ] pobi, honux 의 이동거리가 각각 4, 3 이면 최종 우승자는 pobi이다.
- [ ] pobi, honux, crong 의 이동거리가 각각 4, 4, 3 이면 최종 우승자는 pobi, honux이다.(우승자 한명이상 가능)