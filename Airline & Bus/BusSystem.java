package 과제2;


import java.util.Scanner;


public class BusSystem extends ReservationSystem { // ReservationSystem 클래스를 상속받아서 버스 예약 시스템 기능 구현
	
	int Bus[][];
	int busMenunum;
	
	Scanner scanner;
	
	String busSeat;
	int busSeatnum;
	char busSeatstr;
	
	
	public BusSystem(Scanner scanner) {
		// TODO Auto-generated constructor stub
		this.scanner=scanner;
	}
	
	public void set_busMenunum()

	
	{
		this.busMenunum=scanner.nextInt();
	}
	
	public void set_busSeat() {
		this.busSeat=scanner.next();
	}
	
	public String get_busSeat() {
		return this.busSeat;
	}
	
	@Override
	public void makeSeats(int row, int col) {
		// TODO Auto-generated method stub
		
		this.Bus=new int[row][col];
		this.row=row;
		this.col=col;
		
		super.makeSeats(row, col);
	}
	
	@Override
	public int reserveSeat(String seatName) {
		// TODO Auto-generated method stub
		
		
		this.busSeatnum=seatName.charAt(0)-'0';
		this.busSeatstr=seatName.charAt(1);
		
		if(this.Bus[67-busSeatstr][busSeatnum-1]==0)
		{
			this.Bus[67-busSeatstr][busSeatnum-1]=1;
			System.out.printf("[예약 성공] %s\n",seatName);
			this.count++;
			return 1;
		}
		else
		{
			System.out.printf("[예약 실패] %s: 이미 예약된 좌석입니다.\n",seatName);
			return 0;
		}
		
		
	}
	
	@Override
	public int cancelSeat(String seatName) {
		// TODO Auto-generated method stub
		return super.cancelSeat(seatName);
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
				System.out.printf("[%2d%c]",j+1,67-i);
			}
			System.out.println("");
			for(j=0;j<this.col;j++)
			{
				System.out.printf("%5d",this.Bus[i][j]);
			}
			System.out.println("");
			
		}
		super.displaySeat(systemTitle);
	}
	

   
}

