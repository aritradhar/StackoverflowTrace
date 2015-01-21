import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class Data 
{
	
	public static void main(String[] ar) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("E:\\Aritra\\Posts.xml"));
		String str = "";
		int line = 0, part = 0;
		ArrayList<BufferedWriter> fwl = new ArrayList<>();
		while((str = br.readLine()) != null)
		{
			if(line%100000 == 0)
			{
				if(part>0)
				{
					fwl.get(part-1).append("</posts>");
					fwl.get(part-1).close();
				}
				
				//FileWriter fw = new FileWriter("E:\\Aritra\\stackoverflow.com-Posts\\"+part+".xml", "UTF-8");
				BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\Aritra\\stackoverflow.com-Posts\\"+part+".xml"), "UTF-8"));
				
				if(part!=0)
					fw.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>"+"\n"+"<posts>\n");
				fwl.add(part,fw);
				System.out.println(line);
				part++;
			}
			fwl.get(part-1).append(str+"\n");
			line++;
		}
		
		System.out.println(line);
		br.close();
		//fw.close();
	}
}
