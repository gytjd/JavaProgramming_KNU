//2020117898 황효성 

import java.util.Scanner;

public class LottoGeneration {
	
	public static void init_ary(int ary[],int n)
	{
		int i;
		for(i=0;i<n;i++)
		{
			ary[i]=0;
		}
	}
	// 배열 초기화 함
	
	public static int is_reapted(int ary[],int n)
	{
		int i;
		for(i=0;i<n;i++)
		{
			if(ary[i]==ary[n])
			{
				return 0;
			}
		}
		return 1;
	}
	// 배열 내 중복된 값이 있나 검사함수
	
	public static void display_Lottoary(int ary[])
	{
		int i;
		for(i=0;i<6;i++)
		{
			System.out.printf("%3d",ary[i]);
		}
		System.out.println("");
	}
	
	public static void display_asterisk(int n)
	{
		int i;
		for(i=0;i<n;i++)
		{
			System.out.print("*");
		}
		System.out.println("");
	}
	
	public static void display_totalAry(int ary[])
	{
		int i;
		for(i=1;i<46;i++)
		{
			if(ary[i]!=0)
			{
				System.out.print(i+":");
				display_asterisk(ary[i]); //생성된 로또 번호의 빈도수가 0보다 큰 경우, 숫자의 개수를 "*"로 화면에 출력함
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int lottoary[]=new int[6]; // 한회당 로또번호를 나타낼 배
		int tryCount;
		int i,j;
		
		int totalAry[]=new int[46]; //전체 카운트를 세는 배열
		init_ary(totalAry,46);

		while(true)
		{
			System.out.println("Lotto 수행 회수를 입력하세요 (1~5) : ");
			tryCount=scanner.nextInt();
		
			if(tryCount<0 || tryCount>5)
			{
				System.out.println("1에서 5사이의 숫자를 다시 입력하세요. ");
			}
			else
			{
				break;
			}
			
		}//실행 횟수 입력시 양의 정수값만 입력 받도록 에러 체크 기능 구현
			
		for(i=0;i<tryCount;i++)
		{
			init_ary(lottoary,6); // 1회 생성 후 배열의 값은 초기화 시킴
			for(j=0;j<6;j++)
			{
				lottoary[j]=((int)(Math.random()*45 + 1));
				if(is_reapted(lottoary,j)==0)
				{
					j--;
					continue;
				};
				 //배열에 중복되는 값이 있는지 검사 기능을 함수로 구현
				
				
				totalAry[lottoary[j]]++;  //입력된 실행 횟수에 맞게 일차원 배열에 로또 번호 저장 및 반복 기능
			}
			System.out.print("Lotto ["+(i+1)+"] : ");
			display_Lottoary(lottoary); //랜덤 생성된 일차원 배열 출력 함수 구현
			
		}
		
		display_totalAry(totalAry);
		
	scanner.close();

	}

}
