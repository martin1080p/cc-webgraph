/open ./../src/script/webgraph_ranking/graph_explore_load_graph.jsh

import it.unimi.dsi.webgraph.NodeIterator;
import org.commoncrawl.webgraph.explore.Graph;


System.out.println("Graph loaded");

String outputPath = System.getProperty("path")
System.out.println("Output path: " + outputPath)

String tld = System.getProperty("tld")
System.out.println("TLD: " + tld)

// First .cz domain cz.0 at id 71998781
NodeIterator iterator = g.graph.nodeIterator(71998781);

try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

    while (iterator.hasNext()) {
        int node = iterator.nextInt();
        String reversedDomain = g.vertexIdToLabel(node);
        
        if(!reversedDomain.startsWith(tld + ".")){
            break;
        }

        String domain = Graph.reverseDomainName(reversedDomain);

        System.out.println(domain);

        // Collect successors into one comma-separated string
        String successors = g.successorStream(reversedDomain)
                                .map(d -> Graph.reverseDomainName(d))
                                .collect(Collectors.joining(" "));

        // Write everything on one line
        writer.write(domain + "; " + successors);
        writer.newLine();
        
    }

} catch (IOException e) {
    e.printStackTrace();
}

/exit

