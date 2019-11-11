import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.store.SimpleFSDirectory;
import pl.poznan.put.cie.Item;
import pl.poznan.put.cie.ItemProvider;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        StandardAnalyzer analyzer = new StandardAnalyzer();
        Directory index = new SimpleFSDirectory(Paths.get("itemsIndex"));
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter w = new IndexWriter(index, config);

        try (ItemProvider provider = new ItemProvider("items.xml")) {
            while (provider.hasNext()) {
                Item item = provider.next();
                // TODO index item
                addDoc(w, item.getId(), item.getName(), item.getPrice(), item.getCategory(), item.getDescription());
            }
            w.close();
        } catch (IOException | XMLStreamException ex) {
            ex.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        String querystr = scanner.nextLine();
        Query q = new QueryParser("name", analyzer).parse(querystr);


        int hitsPerPage = 10;
        IndexReader reader = DirectoryReader.open(index);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs docs = searcher.search(q, hitsPerPage);
        ScoreDoc[] hits = docs.scoreDocs;


        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i+1) + ". " + d.get("id") + "\t" + d.get("name")  + "\t" + d.get("price"));
        }
    }

        public static void przykład(String[] args) throws IOException, ParseException {
        StandardAnalyzer analyzer = new StandardAnalyzer();
        Directory index = new RAMDirectory();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter w = new IndexWriter(index, config);
        addDoc(w, "Lucene in Action", "193398817");
        addDoc(w, "Lucene for Dummies", "55320055Z");
        addDoc(w, "Managing Gigabytes", "55063554A");
        addDoc(w, "The Art of Computer Science", "9900333X");
        w.close();


        Scanner scanner = new Scanner(System.in);
        String querystr = scanner.nextLine();
        Query q = new QueryParser("title", analyzer).parse(querystr);


        int hitsPerPage = 10;
        IndexReader reader = DirectoryReader.open(index);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs docs = searcher.search(q, hitsPerPage);
        ScoreDoc[] hits = docs.scoreDocs;


        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i+1) + ". " + d.get("isbn") + "\t" + d.get("title"));
        }

    }

    private static void addDoc(IndexWriter w, String title, String isbn)
            throws IOException {
        Document doc = new Document();
        doc.add(new TextField("title", title, Field.Store.YES));
        doc.add(new StringField("isbn", isbn, Field.Store.YES));
        w.addDocument(doc);
    }

        private static void addDoc(IndexWriter w, int id, String name, double price, String category, String description)
            throws IOException {
        Document doc = new Document();
        doc.add(new StringField("id", String.valueOf(id), Field.Store.YES));
        doc.add(new TextField("name", name, Field.Store.YES));
        doc.add(new StringField("price", String.valueOf(price), Field.Store.YES));
        doc.add(new TextField("category", category, Field.Store.YES));
        doc.add(new TextField("description", description, Field.Store.YES));
        w.addDocument(doc);
    }

}
