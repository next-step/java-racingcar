#!/bin/bash

echo "🔧 Setting up..."

# 1. .git/hooks 디렉토리가 없으면 생성
mkdir -p .git/hooks

# 2. pre-commit 복사
cp scripts/setup/git-hooks/pre-commit .git/hooks/pre-commit

# 3. 실행 권한 부여
chmod +x .git/hooks/pre-commit
chmod +x scripts/validation/validate.sh

echo "✅ Complete!"
