import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;

import javax.xml.stream.*;

public class ExtractData 
{
    public static void main(String argv[]) throws Exception 
    {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        File []flist =new File("E:\\Aritra\\stackoverflow.com-Posts").listFiles();
        FileWriter fwrite = new FileWriter("E:\\Aritra\\normalized post\\norm.txt");
        
        int counter = 0;
        
        for(File fl : flist)
        {
        
        	InputStream in = new FileInputStream(fl);
        	XMLStreamReader streamReader = inputFactory.createXMLStreamReader(in);
        	streamReader.nextTag(); //posts
      
        	
        	while (streamReader.hasNext()) 
        	{
        		if (streamReader.isStartElement()) 
        		{
        			counter++;
        			fwrite.append(streamReader.getAttributeValue(5) + "\n");
        			//System.out.println(streamReader.getAttributeValue(5));
        		}
        		
        		if(counter%100000 ==0)
        			System.out.println(counter);
        		
        		streamReader.next();
        	} 
        	
        	
        }
        
        fwrite.close();
        

    }

}

