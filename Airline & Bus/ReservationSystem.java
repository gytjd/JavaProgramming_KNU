package 과제2;


public class ReservationSystem implements ReservationInterface {
	
	public int seat[][];
	public int ROW;
	public int COL;
	
	
	@Override
	public void makeSeats(int row, int col) {
		int i,j;
		this.ROW=row;
		this.COL=col;
		
		seat=new int[row][col];
		
		for(i=0;i<row;i++)
		{
			for(j=0;j<col;j++)
			{
				this.seat[i][j]=0; //예약 시스템의 좌석을 2차원 배열로 생성 (rowxcol 개)
			}
		}
	}

	@Override
	public int reserveSeat(String seatName) { // 사용자가 화면상에서 입력한 문자열을 가지고 행과 열의 숫자로 구분
		
		
		return 0;
	}

	@Override
	public int cancelSeat(String seatName) { // 사용자가 화면상에서 입력한 문자열에 해당하는 좌석을 취소
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void displaySeat(String systemTitle) { // 현재 좌석 현황을 출력
		// TODO Auto-generated method stub
		
	}
	
	public int reservationNum(int row,int col) // 현재 좌석을 에약한 인원 
	{
		int i,j;
		int count=0;
		
		for(i=0;i<row;i++)
		{
			for(j=0;j<col;j++)
			{
				if(seat[i][j]!=0)
				{
					count++;
				}
			}
		}
		
		return count;
	}
	
	public int totalNum(int row,int col) // 전체 좌석의 자
	{
		return row*col;
	}

	
}
