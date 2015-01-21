import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class FindData 
{
	public static void main(String[] ar) throws IOException
	{
		BufferedReader exbr = new BufferedReader(new FileReader("E:\\Aritra\\Exceptions.txt"));
		String str= "";
		ArrayList<String> exceptionList = new ArrayList<>();
		while((str = exbr.readLine()) != null)
		{
			StringTokenizer st = new StringTokenizer(str,", ");
			while(st.hasMoreTokens())
			{
				String temp = st.nextToken();
				//System.out.println(temp);
				exceptionList.add(temp);
			}
		}
		
		exbr.close();
		
		
		long start = System.currentTimeMillis();
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("E:\\Aritra\\normalized post\\norm.txt"));
		FileWriter fw = new FileWriter("E:\\Aritra\\report.txt");
		str = "";
		int line = 0;
		int []hit = new int[50];
		
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
			
			if(str.contains("java bufferoverflowexception") || str.contains("bufferoverflowexception") || str.contains("BufferOverflowException") 
					|| str.contains("buffer overflow exception") || str.contains("Buffer Overflow Exception") || str.contains("java.nio.BufferOverflowException"))
				
						hit[5]++;
		
			
			if(str.contains("java bufferunderflowexception") || str.contains("bufferunderflowexception") || str.contains("BufferUnderflowException") 
					|| str.contains("buffer underflow exception") || str.contains("Buffer Underflow Exception") || str.contains("java.nio.BufferUnderflowException"))
		
						hit[6]++;
			
			if(str.contains("java domexception") || str.contains("domexception") || str.contains("DOMException") 
					|| str.contains("dom exception") || str.contains("DOM Exception") || str.contains("org.w3c.dom.DOMException"))
		
						hit[7]++;
			
			if(str.contains("java nosuchelementexception") || str.contains("nosuchelementexception") || str.contains("NoSuchElementException") 
					|| str.contains("no such element exception") || str.contains("No Such Element Exception") || str.contains("java.util.NoSuchElementException"))
		
						hit[8]++;
			
			if(str.contains("java classcastexception") || str.contains("classcastexception") || str.contains("ClassCastException") 
					|| str.contains("class cast exception") || str.contains("Class Cast Exception") || str.contains("java.lang.ClassCastException"))
		
						hit[9]++;
			
			if(str.contains("java filesystemalreadyexistsexception") || str.contains("filesystemalreadyexistsexception") 
					|| str.contains("FileSystemAlreadyExistsException") || str.contains("file system already exists exception") 
					|| str.contains("File System Already Exists Exception") || str.contains("java.nio.file.FileSystemAlreadyExistsException"))
		
						hit[10]++;
			
			if(str.contains("java filesystemnotfoundexception") || str.contains("filesystemnotfoundexception") 
					|| str.contains("FileSystemNotFoundException") || str.contains("file system not found exception") 
					|| str.contains("File System Not Found Exception") || str.contains("java.nio.file.FileSystemNotFoundException"))
		
						hit[11]++;
			
			if(str.contains("java lsexception") || str.contains("lsexception") 
					|| str.contains("ls exception") || str.contains("LS Exception") 
					|| str.contains("LSException") || str.contains("org.w3c.dom.ls.LSException"))
		
						hit[12]++;
			
			if(str.contains("java malformedparameterizedtypeexception") || str.contains("malformedparameterizedtypeexception") 
					|| str.contains("MalformedParameterizedTypeException") || str.contains("Malformed Parameterized Type Exception") 
					|| str.contains("malformed parameterized type exception") || str.contains("java.lang.reflect.MalformedParameterizedTypeException"))
		
						hit[13]++;
			
			if(str.contains("java mirroredtypesexception") || str.contains("mirroredtypesexception") 
					|| str.contains("MirroredTypesException") || str.contains("Mirrored Types Exception") 
					|| str.contains("mirrored types exception") || str.contains("javax.lang.model.type.MirroredTypesException"))
		
						hit[14]++;
			
			if(str.contains("java missingresourceexception") || str.contains("missingresourceexception") 
					|| str.contains("MissingResourceException") || str.contains("Missing Resource Exception") 
					|| str.contains("missing resource exception") || str.contains("java.util.MissingResourceException"))
		
						hit[15]++;
			
			if(str.contains("java nosuchmechanismexception") || str.contains("nosuchmechanismexception") 
					|| str.contains("NoSuchMechanismException") || str.contains("No Such Mechanism Exception") 
					|| str.contains("no such mechanism exception") || str.contains("javax.xml.crypto.NoSuchMechanismException"))
		
						hit[16]++;
			
			if(str.contains("java securityexception") || str.contains("securityexception") 
					|| str.contains("SecurityException") || str.contains("Security Exception") 
					|| str.contains("security exception") || str.contains("java.lang.SecurityException"))
		
						hit[17]++;
			
			if(str.contains("java cmmexception") || str.contains("cmmexception") 
					|| str.contains("CMMException") || str.contains("CMM Exception") 
					|| str.contains("cmm exception") || str.contains("java.awt.color.CMMException"))
		
						hit[18]++;
			
			if(str.contains("java arraystoreexception") || str.contains("arraystorerxception") 
					|| str.contains("ArrayStoreException") || str.contains("Array Store Exception") 
					|| str.contains("array store exception") || str.contains("java.lang.ArrayStoreException"))
		
						hit[19]++;
			
			if(str.contains("java string exception") || str.contains("java String exception") 
					|| str.contains("java String error") || str.contains("java String error") 
					|| str.contains("java string failure") || str.contains("java String failure") ||
					str.contains("string exception") || str.contains("String exception") 
					|| str.contains("String error") || str.contains("String error") 
					|| str.contains("string failure") || str.contains("String failure"))
		
						hit[20]++;
			
				if(line%1000000 == 0)
				System.out.println(line);
		}
		
		long end = System.currentTimeMillis();
		long t = end - start;
		fw.append("NullPointerException :"+hit[0]+"\n");
		fw.append("ConcurrentModificationException :"+hit[1]+"\n");
		fw.append("NegativeArraySizeException :"+hit[2]+"\n");
		fw.append("IndexOutOfBoundsException :"+hit[3] +"\n");
		fw.append("ArithmeticException :"+hit[4]+"\n");
		fw.append("BufferOverFlowException :"+hit[5]+"\n");
		fw.append("BufferUnderFlowException :"+hit[6]+"\n");
		fw.append("DOMException :"+hit[7]+"\n");
		fw.append("NoSuchElementException :"+hit[8]+"\n");
		fw.append("ClassCastException :"+hit[9]+"\n");
		fw.append("FileSystemAlreadyExistsException :"+hit[10]+"\n");
		fw.append("FileSystemNotFoundException :"+hit[11]+"\n");
		fw.append("LSException :"+hit[12]+"\n");
		fw.append("MalformedParameterizedTypeException :"+hit[13]+"\n");
		fw.append("MirroredTypesException :"+hit[14]+"\n");
		fw.append("MissingResourceException :"+hit[15]+"\n");
		fw.append("NoSuchMechanismException :"+hit[16]+"\n");
		fw.append("SecurityException :"+hit[17]+"\n");
		fw.append("CMMException :"+hit[18]+"\n");
		fw.append("ArrayStoreException :"+hit[19]+"\n");
		fw.append("String failure count :"+hit[20]+"\n");
		
		fw.append("Total record parsed :"+line+"\n");
		fw.append("time taken :"+t+" ms\n");
		fw.close();
		br.close();
	}
}
