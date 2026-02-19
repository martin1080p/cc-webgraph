#!/usr/bin/env bash
set -e
. "$(cd "$(dirname "$0")" && pwd)/00-env.sh"

cd "$GRAPH_DIR"

"$CC_WEBGRAPH_DIR"/src/script/webgraph_ranking/graph_explore_build_vertex_map.sh \
  "$GRAPH_NAME" \
  "$GRAPH_NAME-vertices.txt.gz"

echo "Vertex map built."
