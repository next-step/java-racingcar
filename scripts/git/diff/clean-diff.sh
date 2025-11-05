#!/bin/bash

DIFF_DIR="./diff"

if [ -d "$DIFF_DIR/commit" ]; then
  echo "Cleaning commit patches..."
  rm -f "$DIFF_DIR/commit"/*
fi

echo "Diff directories cleaned."