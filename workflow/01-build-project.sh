#!/usr/bin/env bash
set -e
. "$(cd "$(dirname "$0")" && pwd)/00-env.sh"

cd "$CC_WEBGRAPH_DIR"

mvn clean package

echo "Build finished."
