//2020117898 황효성

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Vector;

public class SimpleGrep {

	public static void option_n(File[] subfiles,File resultFile,String searchWord) throws IOException
	{
		int i;
		int lineCount;
		int count=0;
		
		Vector<String> vector=new Vector<String>();
		
			
			try 
			{
				for(i=0; i<subfiles.length; i++)
				{ 
					lineCount=0;
					
					FileReader freader = new FileReader(subfiles[i]); // 파일을 open함.
					BufferedReader breader= new BufferedReader(freader);
					
					PrintWriter fwriter = new PrintWriter(resultFile);
					
					String line="";


					while((line=breader.readLine())!=null)
					{
						lineCount++;
						for (int j = 0; (j = line.indexOf(searchWord, j)) != -1; j+=searchWord.length())
						{
							System.out.printf("%s :%d:",subfiles[i].getName(),lineCount);
							System.out.printf("%s\n",line);
							// 검색 단어를 포함하고 있는 파일을 발견하면, 해당 파일에 몇개의 검색어가 포함 되어있는지 출력함.
							vector.add(subfiles[i].getName()+" :"+lineCount+line); // Vector 에 저장함.
							count++;
						}	
					}
					
					if(count!=0) // 검색 단어 발견하지 못하면 파일 저장 하지 않음.
					{
						for (int j=0;j<vector.size();j++)
						{
							fwriter.println(vector.get(j));
						}
					}
					
					freader.close(); // 파일을 close 함.
					breader.close();
					fwriter.close();
					
				}
				
				if(count==0) // 검색 단어 수.
				{
					System.out.printf("%s not found!\n",searchWord); // 검색 단어를 하나도 발견하지 못한 경우.
				}
				else {
					System.out.println("Result.txt saved.");
				}
				
				
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
			
		System.out.println();
	}
	public static void option_c(File[] subfiles,File resultFile,String searchWord) throws IOException
	{
		int i;
		int count;
		
		Vector<String> vector=new Vector<String>();
		
			try 
			{
				for(i=0; i<subfiles.length; i++)
				{ 
					count=0;
					
					if(!resultFile.exists())
					{
						resultFile.createNewFile();
					}
					
					FileReader freader = new FileReader(subfiles[i]);
					BufferedReader breader= new BufferedReader(freader);
					
					PrintWriter fwriter = new PrintWriter(resultFile);
					
					String line="";
					
					System.out.printf("%s :",subfiles[i].getName());

					while((line=breader.readLine())!=null)
					{
						for (int j = 0; (j = line.indexOf(searchWord, j)) != -1; j+=searchWord.length())
						{
						    count++;
						    // 검색 단어를 포함하고 있는 파일을 발하면, 해당 파일에 몇개의 검색어가 포함 되어 있는지 출력함.
						}
					}
					
					System.out.printf("%d\n",count);
					vector.add(subfiles[i].getName()+" :"+count);
					
					for(int j=0;j<vector.size();j++)
					{
						fwriter.println(vector.get(j));
					}
									
					breader.close();
					fwriter.close();
					
				}
				
				System.out.println("Result.txt saved.");
				
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		System.out.println();
	}
	public static void option_i(File[] subfiles,File resultFile,String searchWord) throws IOException
	{
		int i;
		int count=0;
		int lineCount;
		
		Vector<String> vector=new Vector<String>();
		
		String tempString;
		String tempSearchString;
		
		tempSearchString=searchWord.toLowerCase(); // 대소문자 구분없이 입력된 검색어를 파일에서 찾음.
		
			try 
			{
					lineCount=0; 
					
					FileReader freader=null;
					BufferedReader breader=null;
					
					String line="";
					
					for(i=0; i<subfiles.length; i++)
					{ 
						lineCount=0;
						freader=new FileReader(subfiles[i]);
						breader=new BufferedReader(freader);
						
						PrintWriter fwriter = new PrintWriter(resultFile);
										
						while((line=breader.readLine())!=null)
						{

							tempString=line.toLowerCase();
							lineCount++;
							
							
							if(tempString.indexOf(tempSearchString)!=-1) // 대소문자 구분없이 입력된 검색어를 파일에서 찾음.
							{
								System.out.printf("%s :%d:",subfiles[i].getName(),lineCount);
								System.out.printf("%s\n",line);
								vector.add(subfiles[i].getName()+" :"+lineCount+line);
								count++;
							}
						}
						
						if(count!=0)
						{
							for(int j=0;j<vector.size();j++)
							{
								fwriter.println(vector.get(j));
							}
						}
					
						
						breader.close();
						fwriter.close();
						
					}
					if(count==0)
					{
						System.out.printf("%s not found!\n",searchWord); // 검색 단어를 하나도 발견하지 못한 경우 검색어 no found 출ㄱ.
					}
					else {
						System.out.println("Result.txt saved.");
						
					}
		
				} 
				catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
			System.out.println();
					

	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String option;
		String searchWord;
		String dir;
		
		
		if(args.length!=3)
		{
			System.out.println("Usage: SimpleGrep [option] [searchword] [dir]");
		}
		else {
			option=args[0];
			searchWord=args[1];
			dir=args[2];
			
			File f = new File(dir); // 실행시 지정한 디렉토리명에 존재하는 파일 및 디렉토리 목록 가져옴.
			File[] subfiles = f.listFiles(); // 해당디렉토리의 모든 파일을 File[]에 저장
			Arrays.sort(subfiles); // 파일 객체를 오름차순으로 정렬
			File resultFile= new File(".txt");
			
			
			System.out.println("-------------------------------------------");
			System.out.printf("Working dir: %s\n",dir);
			System.out.printf("Search Result: option: %s, keyword: %s\n",option,searchWord);
			System.out.println("-------------------------------------------");
			
			
			
			if(option.equals("-n"))
			{
				option_n(subfiles, resultFile, searchWord);
			}
			else if(option.equals("-c"))
			{
				option_c(subfiles,resultFile,searchWord);
			}
			else if(option.equals("-i"))
			{
				option_i(subfiles,resultFile,searchWord);
			}
			else
			{
				System.out.println("Usage: SimpleGrep [option] [searchword] [dir]");
			}
			
			
		}
		
	}

}
