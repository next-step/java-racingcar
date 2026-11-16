---
name: angular-commit
description: AngularJS 커밋 컨벤션(type(scope): subject)을 따라 변경사항을 커밋하고 GitHub에 push한다. 사용자가 "커밋해줘", "AngularJS 컨벤션으로 커밋", "커밋하고 푸시해줘", "/angular-commit" 등으로 요청할 때 사용한다.
---

# AngularJS 커밋 컨벤션 커밋

변경사항을 AngularJS(Conventional Commits) 규칙에 맞춰 커밋하고, 요청 시 GitHub에 push한다.

## 커밋 메시지 형식

```
<type>(<scope>): <subject>
<빈 줄>
<body>
<빈 줄>
<footer>
```

- **type**: 필수. 아래 목록 중 하나(영문 소문자).
- **scope**: 선택. 변경이 영향을 준 범위(예: `calculator`, `racingcar`). 소괄호로 감싼다.
- **subject**: 필수. 50자 이내, 명령형 현재시제, 끝에 마침표 없음. **한국어로 작성**.
- **body**: 선택. 무엇을·왜 바꿨는지. 한 줄 72자 권장. **한국어로 작성**.
- **footer**: 선택. Breaking Change(`BREAKING CHANGE:`)나 이슈 참조(`Closes #123`).

### type 종류

| type | 용도 |
|------|------|
| `feat` | 새로운 기능 추가 |
| `fix` | 버그 수정 |
| `docs` | 문서 변경 |
| `style` | 포맷팅·세미콜론 등 코드 동작에 영향 없는 변경 |
| `refactor` | 기능 변화 없는 코드 구조 개선 |
| `perf` | 성능 개선 |
| `test` | 테스트 추가·수정 |
| `chore` | 빌드·설정·패키지 등 기타 작업 |
| `build` | 빌드 시스템·의존성 변경 |
| `ci` | CI 설정 변경 |
| `revert` | 이전 커밋 되돌리기 |

## 수행 절차

1. **변경 확인**: `git status`와 `git diff`(스테이징 안 된 것), `git diff --staged`를 실행해 무엇이 바뀌었는지 파악한다. 최근 커밋 메시지 스타일도 `git log --oneline -10`으로 참고한다.
2. **스테이징**: 사용자가 특정 파일만 지정하지 않았으면 관련 변경을 `git add`로 스테이징한다. 관련 없는 변경이 섞여 있으면 사용자에게 분리 커밋을 제안한다.
3. **type/scope 결정**: diff 내용을 보고 적절한 type과 scope를 고른다. 서로 다른 성격의 변경이면 커밋을 나눈다.
4. **메시지 작성**: 위 형식으로 subject(한국어)를 쓰고, 변경 이유가 자명하지 않으면 body를 덧붙인다.
5. **커밋**: HEREDOC으로 커밋한다.
   ```bash
   git commit -m "$(cat <<'EOF'
   feat(racingcar): 자동차 전진 조건 추가

   4 이상의 난수가 나오면 전진하도록 구현
   EOF
   )"
   ```
6. **push (요청 시)**: 사용자가 push를 원하면 현재 브랜치를 확인한다. 기본 브랜치(main/master)라면 먼저 작업 브랜치를 만들 것을 제안한다. 그 외에는 `git push -u origin <브랜치>`로 올린다.

## 주의

- 커밋·push는 되돌리기 어려운 작업이므로, 커밋 전에 작성한 메시지를 사용자에게 보여주고 확인받는다. 사용자가 "바로 커밋해"라고 명시하면 건너뛴다.
- 사용자가 요청하지 않았으면 push하지 않는다.
- Co-Authored-By 등 서명이 프로젝트 관례로 필요하면 footer에 추가한다. 불확실하면 넣지 않는다.
- 한 커밋에는 하나의 논리적 변경만 담는다.