import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FindDataGeneric 
{
	public static void main(String[] ar) throws IOException
	{
		long start = System.currentTimeMillis();
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("E:\\Aritra\\normalized post\\norm.txt"));
		FileWriter fw = new FileWriter("E:\\Aritra\\report.txt");
		String str = "";
		int line = 0;
		int []hit = new int[5];
		
		while((str = br.readLine()) != null)
		{
			line++;
			//if(line>100000)
			//break;
			
			
			if(str.contains("java nullpointerexception") || str.contains("nullpointerexception") || str.contains("NullPointerException") 
			|| str.contains("null pointer exception") || str.contains("Null Pointer Exception") || str.contains("java.lang.NullPointerException"))
				
			{
				hit[0]++;
				//System.out.println(hit[0]);
			}
			
			if(str.contains("java concurrentmodificationexception") || str.contains("concurrentmodificationexception") || str.contains("ConcurrentModificationException") 
					|| str.contains("concurrent modification exception") || str.contains("Concurrent Modification Exception") || 
					str.contains("java.util.ConcurrentModificationException"))
			{		
						hit[1]++;
						//System.out.println(hit[1]);
			}
			
			if(str.contains("java negativearraysizeexception") || str.contains("negativesrraysizewxception") || str.contains("NegativeArraySizeException") 
					|| str.contains("negative array size exception") || str.contains("Negative Array Size Exception") || 
					str.contains("java.lang.NegativeArraySizeException"))
			{			
						hit[2]++;
						//System.out.println(hit[2]);
			}
			
			if(str.contains("java indexoutofboundsexception") || str.contains("indexoutofboundsexception") || str.contains("IndexOutOfBoundsException") 
					|| str.contains("index out of bounds exception") || str.contains("Index Out Of Bounds Exception") || 
					str.contains("java.lang.IndexOutOfBoundsException"))
			{			
						hit[3]++;
						//System.out.println(hit[3]);
			}
			
			if(str.contains("java arithmeticexception") || str.contains("arithmeticexception") || str.contains("ArithmeticException") 
					|| str.contains("arithmetic exception") || str.contains("Arithmetic Exception") || str.contains("java.lang.ArithmeticException") 
					|| str.contains("divide by zero") || str.contains("divide-by-zero"))
			{			
						hit[4]++;
						//System.out.println(hit[4]);
			}
			
			
				if(line%1000000 == 0)
				System.out.println(line);
		}
		
		long end = System.currentTimeMillis();
		long t = end - start;
		fw.append("nullpointerexception :"+hit[0]+"\n");
		fw.append("concurrentmodificationexception :"+hit[1]+"\n");
		fw.append("negativearraysizeexception :"+hit[2]+"\n");
		fw.append("indexoutofboundsexception :"+hit[3] +"\n");
		fw.append("arithmeticexception :"+hit[4]+"\n");
		
		fw.append("Total record parsed :"+line+"\n");
		fw.append("time taken :"+t+" ms\n");
		fw.close();
	}
}
