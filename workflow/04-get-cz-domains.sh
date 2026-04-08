#!/usr/bin/env bash
set -e
. "$(cd "$(dirname "$0")" && pwd)/00-env.sh"

jshell  --class-path "$CC_WEBGRAPH_JAR" \
        -R-Dgraph="$GRAPH_DIR/$GRAPH_NAME" \
        -R-Dpath="$CC_WEBGRAPH_DIR/output/domains.csv" \
        -R-Dlinkingpath="$CC_WEBGRAPH_DIR/output/linking.csv" \
        -R-Dlinkpath="$CC_WEBGRAPH_DIR/output/links.csv" \
        -R-Dtld="cz" \
        --startup "$CC_WEBGRAPH_DIR/src/script/webgraph_ranking/graph_explore_load_graph.jsh" \
        "$(cd "$(dirname "$0")" && pwd)/jsh/04-get-domains.jsh"
