#!/usr/bin/env bash
set -e
. "$(cd "$(dirname "$0")" && pwd)/00-env.sh"

jshell  --class-path "$CC_WEBGRAPH_JAR" \
        -R-Dgraph="$GRAPH_DIR/$GRAPH_NAME" \
        -R-Dpath="$CC_WEBGRAPH_DIR/output/cz-domains.txt" \
        -R-Dtld="cz" \
        --startup DEFAULT \
        jsh/04-get-domains.jsh
