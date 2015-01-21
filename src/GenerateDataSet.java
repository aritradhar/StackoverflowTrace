import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hit;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;

class GenerateDataSet {

	public static final String FILES_TO_INDEX_DIRECTORY = "C:\\Users\\aritra1204\\Desktop\\Stackdata";
	public static final String INDEX_DIRECTORY = "C:\\Users\\aritra1204\\Desktop\\Index";

	public static final String FIELD_PATH = "path";
	public static final String FIELD_CONTENTS = "contents";

	public static void main(String[] args) throws Exception {

		createIndex();
		/*
		searchIndex("java");
		searchIndex("exception");
		searchIndex("java exception");
		searchIndex("runtime exception");
		searchIndex("java runtime exception");
		searchIndex("RuntimeException");
		searchIndex("java RuntimeException");
		searchIndex("unchecked exception");
		searchIndex("java unchecked exception");
		*/
		
		searchIndex("java ArithmeticException");
		searchIndex("java Arithmetic Exception");
		searchIndex("Arithmetic Exception");
		System.out.println("--------------------------------------------");
		searchIndex("java NullPointerException");
		searchIndex("java Null Pointer Exception");
		searchIndex("Null Pointer Exception");
		System.out.println("--------------------------------------------");
		searchIndex("java IndexOutOfBoundsException");
		searchIndex("java Index Out OfBounds Exception");
		searchIndex("Index Out Of Bounds Exception");
		System.out.println("--------------------------------------------");
		searchIndex("java NegativeArraySizeException");
		searchIndex("java Negative Array SizeException");
		searchIndex("Negative ArraySize Exception");
		System.out.println("--------------------------------------------");
		searchIndex("java ArrayStoreException");
		searchIndex("java ArrayStore Exception");
		searchIndex("ArrayStore Exception");
		System.out.println("--------------------------------------------");
		searchIndex("java IllegalArgumentException");
		searchIndex("java Illegal ArgumentException");
		searchIndex("Illegal ArgumentException");
		
	}

	public static void createIndex() throws CorruptIndexException, LockObtainFailedException, IOException 
	{
		Analyzer analyzer = new StandardAnalyzer();
		boolean recreateIndexIfExists = true;
		IndexWriter indexWriter = new IndexWriter(INDEX_DIRECTORY, analyzer, recreateIndexIfExists);
		File dir = new File(FILES_TO_INDEX_DIRECTORY);
		File[] files = dir.listFiles();
		File[] files_ = new File[files.length];
		
		int i = 0;
		
		for (File file : files)
		{
			if(file.isDirectory())
			{
				File[] tempfiles_ = file.listFiles();
				for (File file1 : tempfiles_) 
				{
					if(file1.toString().contains("Posts"))
						files_[i++] = file1;
				}
				
			}
		}
		for (File file : files) {
			Document document = new Document();

			String path = file.getCanonicalPath();
			document.add(new Field(FIELD_PATH, path, Field.Store.YES, Field.Index.UN_TOKENIZED));

			Reader reader = new FileReader(file);
			document.add(new Field(FIELD_CONTENTS, reader));

			indexWriter.addDocument(document);
		}
		indexWriter.optimize();
		indexWriter.close();
	}
	

	public static void searchIndex(String searchString) throws IOException, ParseException {
		System.out.println("Searching for '" + searchString + "'");
		Directory directory = FSDirectory.getDirectory(INDEX_DIRECTORY);
		IndexReader indexReader = IndexReader.open(directory);
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);

		Analyzer analyzer = new StandardAnalyzer();
		QueryParser queryParser = new QueryParser(FIELD_CONTENTS, analyzer);
		Query query = queryParser.parse(searchString);
		Hits hits = indexSearcher.search(query);
		System.out.println("Number of hits: " + hits.length());

		/*
		Iterator<Hit> it = hits.iterator();
		while (it.hasNext()) {
			Hit hit = it.next();
			Document document = hit.getDocument();
			String path = document.get(FIELD_PATH);
			System.out.println("Hit: " + path);
		}*/

	}

}