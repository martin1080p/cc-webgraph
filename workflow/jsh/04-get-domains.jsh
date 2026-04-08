import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;
import it.unimi.dsi.webgraph.NodeIterator;
import org.commoncrawl.webgraph.explore.Graph;

System.out.println("Graph loaded");

String outputPath = System.getProperty("path");
System.out.println("Domains output path: " + outputPath);

String linkingPath = System.getProperty("linkingpath");
System.out.println("Linking output path: " + linkingPath);

String linkPath = System.getProperty("linkpath");
System.out.println("Links output path: " + linkPath);

String tld = System.getProperty("tld");
System.out.println("TLD: " + tld);

// First .cz domain cz.0 at id 71998781
NodeIterator iterator = g.graph.nodeIterator(71998781);

try (BufferedWriter domainWriter = new BufferedWriter(new FileWriter(outputPath))) {
    domainWriter.write("domain");
    domainWriter.newLine();

    try (BufferedWriter linkingWriter = new BufferedWriter(new FileWriter(linkingPath))) {

        try (BufferedWriter linkWriter = new BufferedWriter(new FileWriter(linkPath))) {
            linkWriter.write("source,target");
            linkWriter.newLine();

            while (iterator.hasNext()) {
                int node = iterator.nextInt();
                String reversedDomain = g.vertexIdToLabel(node);
                
                if(!reversedDomain.startsWith(tld + ".")){
                    break;
                }

                String domain = Graph.reverseDomainName(reversedDomain);

                System.out.println(domain);

                boolean hasLinks = false;

                for (String successor : g.successorStream(reversedDomain)
                            .map(Graph::reverseDomainName)
                            .toList()) {
                    hasLinks = true;
                    linkWriter.write(domain + "," + successor);
                    linkWriter.newLine();
                }

                if(hasLinks){
                    linkingWriter.write(domain);
                    linkingWriter.newLine();
                }

                // Write everything on one line
                domainWriter.write(domain);
                domainWriter.newLine();
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

} catch (IOException e) {
    e.printStackTrace();
}

/exit
