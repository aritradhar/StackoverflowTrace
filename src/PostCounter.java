import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;



 
public class PostCounter 
{
    public static void main(String[] args) throws IOException 
    {
    	File file = new File("E:\\Aritra\\Posts.xml");
    	BufferedReader br = new BufferedReader(new FileReader(file));
    	
		String str = "";
		int line = 0;
		long start1 = System.nanoTime();
		while((str = br.readLine()) != null)
		{
			if(line%500000 == 0)
				System.out.println(line);
			line++;
		}
		br.close();
		
		long time1 = System.nanoTime() - start1;
		System.out.println(line);
		  System.out.printf("Took %.3f seconds to read a %d MB, file rate: %.1f MB/s%n",
		            time1 / 1e9, file.length() >> 20, file.length() * 1000.0 / time1);
		
    }
}