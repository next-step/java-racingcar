#!/bin/bash

branch_name=$(git rev-parse --abbrev-ref HEAD | tr '/' '_')
timestamp=$(date +"%Y%m%d_%H%M%S")
output_file="diff/commit/${branch_name}_${timestamp}.patch"

mkdir -p "$(dirname "$output_file")"

git diff --staged > "$output_file"

echo "Staged diff saved to $output_file"