#!/bin/bash

DIFF_DIR="./diff"

if [ -d "$DIFF_DIR/commit" ]; then
  echo "Cleaning commit patches..."
  rm -f "$DIFF_DIR/commit"/*
fi

if [ -d "$DIFF_DIR/pr" ]; then
  echo "Cleaning pr patches..."
  rm -f "$DIFF_DIR/pr"/*
fi

echo "Diff directories cleaned."