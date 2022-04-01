//2020117898 황효성
public class VarRange {

	public static void main(String[] args) {
		
		final long year=365*24*3600;
		final long day=24*3600;
		final long hour=3600;
		//1년 , 1일, 1시간을 각 몇초인지 나타낸것.
		//final을 사용해서 상수로 지정해줌.
		
		short totalCount1=Short.MAX_VALUE;
		
		long Cyear=totalCount1/(year);
	    long Cday=(totalCount1%year)/(day);
		long Chour=(totalCount1%day)/hour;
		
		System.out.println("short max :"+totalCount1);
		System.out.println("short 변수 사용 :"+Cyear+"년 "+Cday+"일 "+Chour+"시 ");
		//Short 형의 최대 값, 그리고 최대값인 32767로 환산한 각 년,일,시
		
		int totalCount2=Integer.MAX_VALUE;

		Cyear=totalCount2/year;
	    Cday=(totalCount2%year)/day;
		Chour=(totalCount2%day)/hour;
		
		System.out.println("int max :"+totalCount2);
		System.out.println("int 변수 사용 :"+Cyear+"년 "+Cday+"일 "+Chour+"시 ");
		//Int 형의 최대 값, 그리고 환산한 각 년,일,시
		
		long totalCount3=Long.MAX_VALUE;
		Cyear=totalCount3/year;
	    Cday=(totalCount3%year)/day;
		Chour=(totalCount3%day)/hour;
		System.out.println("long max :"+totalCount3);
		System.out.println("long 변수 사용 :"+Cyear+"년 "+Cday+"일 "+Chour+"시 ");
		//Long 형의 최대 값, 그리고 환산한 각 년,일,시
		
	}
		
	
		


}
