#!/usr/bin/env bash
set -e

# ----------------------------------------
# Project configuration
# ----------------------------------------

export WORKFLOW_DIR="$(cd "$(dirname "$0")" && pwd)"
export CC_WEBGRAPH_DIR="$(dirname "$WORKFLOW_DIR")"
export GRAPH_NAME="cc-main-2025-26-nov-dec-jan-domain"
export GRAPH_DIR="$CC_WEBGRAPH_DIR/graphs/$GRAPH_NAME"

# ----------------------------------------
# Derived variables
# ----------------------------------------

export CC_WEBGRAPH_JAR=$(ls "$CC_WEBGRAPH_DIR"/target/cc-webgraph-*-jar-with-dependencies.jar)

echo "Configuration loaded:"
echo "  CC_WEBGRAPH_JAR=$CC_WEBGRAPH_JAR"
echo "  CC_WEBGRAPH_DIR=$CC_WEBGRAPH_DIR"
echo "  GRAPH_NAME=$GRAPH_NAME"
echo "  GRAPH_DIR=$GRAPH_DIR"
