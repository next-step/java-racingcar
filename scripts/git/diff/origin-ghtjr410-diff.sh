#!/bin/bash

branch_name=$(git rev-parse --abbrev-ref HEAD | tr '/' '_')
timestamp=$(date +"%Y%m%d_%H%M%S")
output_file="diff/commit/${branch_name}_vs_origin_ghtjr410_${timestamp}.patch"

mkdir -p "$(dirname "$output_file")"
git fetch origin ghtjr410 --quiet
git diff origin/ghtjr410...HEAD > "$output_file"

echo "Diff between current branch and origin/ghtjr410 saved to $output_file"