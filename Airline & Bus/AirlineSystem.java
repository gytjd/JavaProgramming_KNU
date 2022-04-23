//2020117898 황효성
package 과제2;

import java.util.Scanner;


public class AirlineSystem extends ReservationSystem  { // ReservationSystem 클래스를 상속받아서 항공사 예약 시스템 기능 구현
	
	int Airline[][];
	
	Scanner scanner;
	
	int airlineMenunum;
	
	String airlineSeat;
	int airlineSeatnum;
	int airlineSeatnum2;
	char airlineSeatstr;
	
	public AirlineSystem(Scanner scanner) {
		// TODO Auto-generated constructor stub
		this.scanner=scanner;
	}
	
	public void set_airlineMenunum()
	{
		this.airlineMenunum=scanner.nextInt();
	}
	
	public void set_airlineSeat()
	{
		this.airlineSeat=scanner.next();
	}
	
	public String get_airlineString()
	{
		return airlineSeat;
	}
	
	@Override
	public void makeSeats(int row, int col) { // 예약 시스템의 좌석을 2차원 배열로 생성 (rowxcol 개)
		// TODO Auto-generated method stub
		
		Airline=new int[row][col]; 
		this.row=row; //// 행은 E,D,C,B,A 형태로 문자열로 구성
		this.col=col; //  열은 1,2,3,... 형태로 숫자로 구성
		
		super.makeSeats(row, col);
	}
	
	@Override
	public int reserveSeat(String seatName) { // 사용자가 화면상에서 입력한 문자열을 가지고 행과 열의 숫자로 구분
		// TODO Auto-generated method stub
		
		int n=seatName.length(); // 문자열의 길이 계산: String.length() 함수 이용
		
		if(n==3)
		{
			airlineSeatnum=seatName.charAt(n-3)-'0'; // String.charAt(index): index번째 문자 리턴
			airlineSeatnum2=seatName.charAt(n-2)-'0';
			
			
			airlineSeatnum=(airlineSeatnum*10)+airlineSeatnum2;

			airlineSeatstr=seatName.charAt(n-1);
		}
		else if(n==2){
			
			airlineSeatnum=seatName.charAt(n-2)-'0';
			airlineSeatstr=seatName.charAt(n-1);
			
			if(airlineSeatnum>=10)
			{
				System.out.printf("%s: 숫자가 아닌 잘못된 좌석 이름입니다.\n",seatName);
				System.out.println("[예약 실패]: 잘못된 좌석 이름입니다.");
				return 0;
			}
			
		
		}
		else {
			System.out.println("[예약 실패]: 잘못된 좌석 이름입니다."); // 좌석 이름이 잘못된 경우, “[예약 실패]: 잘못된 좌석 이름입니다” 출력
			return 0;
		}
		
		try {
			
			 
			if(this.Airline[68-airlineSeatstr][airlineSeatnum-1]==0) // seatName이 "10D"인 경우, (10: 10열, D: 0행)
			{
				this.Airline[68-airlineSeatstr][airlineSeatnum-1]=1; //예약 성공인 경우, “[예약 성공] 좌석 번호 출력”을 하고 변경된 좌석 현황을 화면에 출력함
				System.out.printf("[예약 성공] %s\n",seatName);// 예약된 좌석은 배열의 위치에 1(OCCUPIED)로 표시함
				this.count++;
				return 1; // 리턴값: (0: 성공, -1: 실패)
			}
			else
			{
				System.out.printf("[예약 실패] %s: 이미 예약된 좌석입니다.\n",seatName); // 이미 예약된 좌석인 경우, “[예약 실패] 좌석번호: 이미 예약된 좌석입니다.”를 화면에 출력

			}
			
			
		} catch (Exception e) { 
			// TODO: handle exception
			System.out.printf("%s: 좌석의 범위를 넘은 잘못된 좌석 이름입니다.\n",seatName);
			System.out.println("[예약 실패]: 잘못된 좌석 이름입니다.");
		}
		return 0; // 리턴값: (0: 성공, -1: 실패)

		
	}
	
	@Override
	public int cancelSeat(String seatName) {  //사용자가 화면상에서 입력한 문자열에 해당하는 좌석을 취소
		// TODO Auto-generated method stub
		int n=seatName.length();
		
		if(n==3)
		{
			airlineSeatnum=seatName.charAt(n-3)-'0';
			airlineSeatnum2=seatName.charAt(n-2)-'0';
			
			
			airlineSeatnum=(airlineSeatnum*10)+airlineSeatnum2;

			airlineSeatstr=seatName.charAt(n-1);
		}
		else if(n==2){
			
			airlineSeatnum=seatName.charAt(n-2)-'0';
			airlineSeatstr=seatName.charAt(n-1);
			
			if(airlineSeatnum>=10)
			{
				System.out.printf("%s: 숫자가 아닌 잘못된 좌석 이름입니다.\n",seatName);
				System.out.println("[예약 실패]: 잘못된 좌석 이름입니다.");
				return 0;
			}
			
		
		}
		else {
			System.out.println("[예약 실패]: 잘못된 좌석 이름입니다."); // 좌석 이름이 잘못된 경우, “[예약 취소 실패]: 잘못된 좌석 이름입니다” 출력
			return 0;
		}
		
		try {
			
			
			if(this.Airline[68-airlineSeatstr][airlineSeatnum-1]==1)
			{
				this.Airline[68-airlineSeatstr][airlineSeatnum-1]=0;
				System.out.printf("[예약 취소 성공] %s\n",seatName); // 예약된 좌석을 취소한 경우, “[예약 취소 성공] 좌석번호” 출력
				this.count--;
				return 1;
			}
			else
			{
				System.out.printf("[예약 취소 실패] %s: 예약 되지 않은 좌석입니다.\n",seatName); // 예약이 되지 않은 좌석을 취소하는 경우, “[예약 취소 실패] 좌석번호: 예약 되지 않은 좌석입니다.”를 화면에 출력
  
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.printf("%s: 좌석의 범위를 넘은 잘못된 좌석 이름입니다.\n",seatName);
			System.out.println("[예약 실패]: 잘못된 좌석 이름입니다."); // 좌석 이름이 잘못된 경우, “[예약 취소 실패]: 잘못된 좌석 이름입니다” 출력
		}
		return 0;
		
		
	}
	
	@Override
	public void displaySeat(String systemTitle) { // 현재 좌석 현황을 출력 (실행 결과 내용 참고)
		// TODO Auto-generated method stub
		
		int i,j;
		System.out.printf("[%s 예약 현황] 예약 좌석: %d/ 총 좌석: %d\n\n",systemTitle,reserveNum(),totalNum());
		
		for(i=0;i<this.row;i++)
		{
			for(j=0;j<this.col;j++)
			{
				System.out.printf("[%2d%c]",j+1,68-i);
			}
			System.out.println("");
			
			
			for(j=0;j<this.col;j++)
			{
				if(Airline[i][j]==1)
				{
					System.out.print("    X");
				}
				else
				{
					System.out.printf("%5d",this.Airline[i][j]);
				}
			}
			System.out.println("");
			
			if(i==1)
			{
				System.out.println("--------------------------------------------------");
				System.out.println(" 앞                     통로                       뒤");
				System.out.println("--------------------------------------------------");
			}
			
		}
		super.displaySeat(systemTitle);
	}
	
	
	
	
	
}
