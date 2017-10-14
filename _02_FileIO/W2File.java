package _02_FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class W2File {
	public static void main(String[] args) throws IOException {
		
		File f1 = new File("E:/file1/file1.txt");
		File f2 = new File("lol.exe");
		
		f1.getParentFile().mkdirs();
		
		
		try {

			PrintWriter output = new PrintWriter(f1);
			
			output.append("这是第一行的append");
			output.append("这是第二行的append\r\n");
			output.print("这是print");
			output.println("这是println");
			output.print("这是最后一行");
			output.close();
			
			Scanner input = new Scanner(f1);
			
			while (input.hasNext()){
				System.out.println(input.next());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("f1 是否存在:" + f1.exists());
		
		System.out.println("f1 父目录:" + f1.getParentFile());
		
		System.out.println("f1 父目录:" + f1.getParent());
		
		System.out.println("f2 是否存在:" + f2.exists());
		
		if (!f2.exists()){
			f2.createNewFile();
			System.out.println("创建f2成功");
		}
		
		System.out.println("f1 的绝对目录:" + f1.getAbsolutePath());
		
		System.out.println("f2 的绝对目录:" + f2.getAbsolutePath());
		
	}
}
