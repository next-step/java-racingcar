#!/bin/bash

set -e

echo "🧹 Running spotlessApply..."
./gradlew spotlessApply

echo "✅ Verifying spotlessCheck..."
./gradlew spotlessCheck || ./gradlew spotlessDiagnose

echo "🛠️ Building project…"
./gradlew clean build

echo "🎉 All checks passed!"