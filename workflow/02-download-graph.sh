#!/usr/bin/env bash
set -e
. "$(cd "$(dirname "$0")" && pwd)/00-env.sh"

mkdir -p "$GRAPH_DIR"
cd "$GRAPH_DIR"

"$CC_WEBGRAPH_DIR"/src/script/webgraph_ranking/graph_explore_download_webgraph.sh \
  "$GRAPH_NAME"

echo "Download complete."
