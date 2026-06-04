# 2026-06-04 길드 가입 시퀀스 다이어그램 정리

## Task summary
- 프로젝트의 길드 가입 흐름을 읽고 GitHub Markdown에서 렌더링 가능한 Mermaid 시퀀스 다이어그램으로 정리했다.

## Scope
- `joinGuild.jsp`의 세션 초기화, 폼 표시, POST 가입 처리 흐름을 문서화했다.
- `길드.길드가입()`의 정원 확인, 길드원 추가, 캐릭터의 가입길드 설정 흐름을 문서화했다.
- 코드 동작 변경은 하지 않았다.

## Changed files
- `joinguild.md`
- `docs/worklogs/_index.md`
- `docs/worklogs/2026-06-04_guild-join-sequence-diagram.md`

## Verification result
- 문서 파일의 Mermaid 코드 블록 형식을 확인했다.
- 저장소 상태 확인으로 변경 파일을 확인했다.

## Decisions made
- 기존 루트 문서 배치에 맞춰 `joinguild.md`를 갱신했다.
- 실제 JSP 조건 분기 순서에 맞춰 플레이어 확인, 캐릭터 확인, 길드 확인, 정원 확인 순서로 다이어그램을 구성했다.

## Issues
- 기존 `docs/worklogs/` 디렉터리와 `_index.md`가 없어 새로 생성했다.
- 테스트 실행이 필요한 코드 변경은 없었다.

## Next steps
- GitHub에서 `joinguild.md`를 열어 Mermaid 그래프 렌더링을 확인한다.
