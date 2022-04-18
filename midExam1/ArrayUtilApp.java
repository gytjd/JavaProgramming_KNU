package 중간고사;

public class ArrayUtilApp {
	
	public void print_menu()
	{
		ArrayUtil arrayUtil=new ArrayUtil();
		int a[]=new int[10]; // 크기가10인 두 개의 배열 생성
		int b[]=new int[10]; // 크기가10인 두 개의 배열 생성
		
		int c[]=new int[20];
		int result;
		
		
		System.out.println("fill(a) 수행");
		arrayUtil.fill(a);
		System.out.println("< 배열 a 인덱스 및 내용 출력 >");
		arrayUtil.print(a);
		System.out.println("\n");
		
		System.out.println("fill(b) 수행");
		arrayUtil.fill(b);
		System.out.println("< 배열 b 인덱스 및 내용 출력 >");
		arrayUtil.print(b);
		
		System.out.println("\n");
		System.out.println("concat(a, b) 수행 및 배열 c 생성");
		System.out.println("< 배열 c 인덱스 및 내용 출력 >");
		c=arrayUtil.concat(a, b);
		arrayUtil.print1(c);
		
		System.out.println("\n");
		System.out.println("compare(a, b) 수행");
		result=arrayUtil.compare(a, b);
		
		if(result==1)
		{
			System.out.println("a>b");
		}
		else if(result==-1)
		{
			System.out.println("a<b");
		}
		else {
			System.out.println("a=b");
		}

	}
	public static void main(String[] args) {
		ArrayUtilApp arrayUtilApp=new ArrayUtilApp();
		arrayUtilApp.print_menu();

	}

}
