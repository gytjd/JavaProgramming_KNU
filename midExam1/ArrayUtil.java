package 중간고사;

public class ArrayUtil {
	
	
	void fill(int[] a) // 랜덤값(1~99 사이)을 생성하고, 크기가 10인 배열을 생성된 랜덤값으로 저장
	{
		int i;
		for(i=0;i<10;i++)
		{
			a[i]=(int) (Math.random()*99+1);
		}
	}
	
	int[] concat(int[]a,int[] b) // 두 배열(a, b)를 합쳐서 새로운 배열을 생성하고 새롭게 생성된 배열을 리턴

	{
		int i;
		int c[]=new int[20];
		for(i=0;i<10;i++)
		{
			c[i]=a[i];
			c[10+i]=b[i];
		}
		
		return c;
	}
	
	void print(int []a) // 배열의인덱스 및 원소를 포맷에 맞게 화면에 출력
	{
		int i;
		for(i=0;i<10;i++)
		{
			System.out.printf("  %d ",i);
		}
		System.out.println("");
		System.out.print("[");
		for(i=0;i<10;i++)
		{
			
			if(i==9)
			{
				System.out.printf("%2d", a[i]);
			}
			else
			{
				System.out.printf("%2d, ", a[i]);
			}
		
		}
		System.out.print("]");
	}
	
	void print1(int []a)
	{
		int i;
		for(i=0;i<20;i++)
		{
			System.out.printf(" %2d ",i);
		}
		System.out.println("");
		System.out.print("[");
		for(i=0;i<20;i++)
		{
			
			if(i==19)
			{
				System.out.printf("%2d", a[i]);
			}
			else
			{
				System.out.printf("%2d, ", a[i]);
			}
		
		}
		System.out.print("]");
	}
	
	int compare(int a[],int b[]) // 두 배열의 최대값을 계산하고, 최대값을 비교하여 아래 결과를 리턴
	{
		int i;
		int maxA=a[0];
		int maxB=b[0];
		for(i=1;i<10;i++)
		{
			if(maxA<a[i])
			{
				maxA=a[i];
			}
		}
		
		for(i=1;i<10;i++)
		{
			if(maxB<b[i])
			{
				maxB=b[i];
			}
		}
		
		System.out.printf("a의 최대값: %2d, b의 최대값: %2d\n",maxA,maxB);
		
		if(maxA>maxB)
		{
			return 1;
		}
		else if(maxA<maxB)
		{
			return -1;
		}
		else 
		{
			return 0;
		}
		
		/*
		 * - 1:a의 최대값>b의 최대값
           - 0:a의 최대값==b의 최대값
            - -1:a의 최대값<b의 최대값
		 */
	}
}
