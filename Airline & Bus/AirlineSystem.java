package 과제2;

import java.util.Scanner;


public class AirlineSystem extends ReservationSystem  { 
	
	int Airline[][];
	
	Scanner scanner;
	
	int airlineMenunum;
	String airlineSeat;
	int airlineSeatnum;
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
	public void makeSeats(int row, int col) {
		// TODO Auto-generated method stub
		
		Airline=new int[row][col];
		this.row=row;
		this.col=col;
		
		super.makeSeats(row, col);
	}
	
	@Override
	public int reserveSeat(String seatName) {
		// TODO Auto-generated method stub
		
		this.airlineSeatnum=seatName.charAt(0)-'0';
		this.airlineSeatstr=seatName.charAt(1);
		
		try {
			
			
			if(this.Airline[68-airlineSeatstr][airlineSeatnum-1]==0)
			{
				this.Airline[68-airlineSeatstr][airlineSeatnum-1]=1;
				System.out.printf("[예약 성공] %s\n",seatName);
				this.count++;
				return 1;
			}
			else
			{
				System.out.printf("[예약 실패] %s: 이미 예약된 좌석입니다.\n",seatName);

			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.printf("%s: 좌석의 범위를 넘은 잘못된 좌석 이름입니다.\n",seatName);
			System.out.println("[예약 실패]: 잘못된 좌석 이름입니다.");
		}
		
		return 0;

		
	}
	
	@Override
	public int cancelSeat(String seatName) {
		// TODO Auto-generated method stub
		
		this.airlineSeatnum=seatName.charAt(0)-'0';
		this.airlineSeatstr=seatName.charAt(1);
		
		if(this.Airline[68-airlineSeatstr][airlineSeatnum-1]==1)
		{
			this.Airline[68-airlineSeatstr][airlineSeatnum-1]=0;
			System.out.printf("[예약 취소 성공] %s\n",seatName);
			this.count--;
			return 1;
		}
		else
		{
			System.out.printf("[예약 취소 실패] %s: 예약 되지 않은 좌석입니다.\n",seatName);
			return 0;
		}
		
		
	}
	
	@Override
	public void displaySeat(String systemTitle) {
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
				System.out.printf("%5d",this.Airline[i][j]);
			}
			System.out.println("");
			
		}
		super.displaySeat(systemTitle);
	}
	
	
	
	
	
}
