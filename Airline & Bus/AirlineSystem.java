package 과제2;

import java.util.Scanner;

public class AirlineSystem extends ReservationSystem  { // ReservationSystem 클래스를 상속받아서 항공사 예약 시스템 기능 구현
	
	public Scanner aScanner;
	
	public int airlen;
	public String airlineNum;
	public int airlineNumber;
	public char airlineChar;
	public String airlineReserve;
	public String airlineCancel;
	
	
	public AirlineSystem(Scanner scanner)
	{
		this.aScanner=scanner;
	}
	
	public void set_airlineNum()
	{
		this.airlineNum=aScanner.next();
	}
	
	public void set_airlen()
	{
		this.airlen=airlineNum.length();
	}
	
	public void set_airlineNumber()
	{
		this.airlineNumber=this.airlineNum.charAt(0)-'0';
	}
	
	public void set_aritlineChar()
	{
		this.airlineChar=this.airlineNum.charAt(0);
	}
	
	public void set_airlineReserve()
	{
		this.airlineReserve=aScanner.next();
	}
	
	public void set_airlineCancel()
	{
		this.airlineCancel=aScanner.next();
	}

	
	
	
	public void displaySeat(String systemTitle) {
		// TODO Auto-generated method stub
		int i,j;
		System.out.printf("[%s 예약 현황] 예약 좌석: %d/ 총 좌석 :%d\n\n",systemTitle,reservationNum(ROW,COL),totalNum(ROW, COL));
		
		for(i=0;i<ROW;i++)			
		{
			for(j=0;j<COL;j++)
			{
				if(i==0)
				{
					System.out.printf("[%2dD]",j+1);
				}
				else if(i==1)
				{
					System.out.printf("[%2dC]",j+1);
				}
				else if(i==2)
				{
					System.out.printf("[%2dB]",j+1);
				}
				else 
				{
					System.out.printf("[%2dA]",j+1);
				}
			}
			System.out.println("");
			for(j=0;j<COL;j++)
			{
				if(seat[i][j]==1)
				{
					System.out.print("   X ");
				}
				else
				{
					System.out.printf("  %2d ",seat[i][j]);
				}
				
			}
			if(i==1&&j==COL)
			{
				System.out.println("");
				System.out.println("--------------------------------------------------");
				System.out.println("앞                      통로                      뒤");
			    System.out.println("--------------------------------------------------");
			}
			System.out.println("");
		}
		
	}
	
	public int reserveSeat(String seatName) {
		
		
		int n=seatName.length(); // 문자열의 길이 계산: String.length() 함수 이용
		int seatNum=seatName.charAt(0)-'0';
		
	
		if(n==3)
		{
			char a=seatName.charAt(0); // String.charAt(index): index번째 문자 리턴
			char b=seatName.charAt(1);
			char c=seatName.charAt(2);
			
			if(a=='0')
			{
				int bz=b-'0';
				
				if(bz>0 && bz<=9)
				{
					if(seatName.charAt(2)=='A' || seatName.charAt(2)=='B' || seatName.charAt(2)=='C' || seatName.charAt(2)=='D')
					{
						if(seatName.charAt(2)=='A')
						{
							if(seat[3][bz-1]==0)
							{
								System.out.printf("[예약 성공] %s\n",seatName); // 예약 성공인 경우, “[예약 성공] 좌석 번호 출력”을 하고 변경된 좌석 현황을 화면에 출력함
								seat[3][bz-1]=1; // 예약된 좌석은 배열의 위치에 1(OCCUPIED)로 표시함
								return 0; // 리턴값: (0: 성공, -1: 실패)
							}
							else
							{
								System.out.printf("[예약 실패] %s :이미 예약된 좌석입니다.\n",seatName); // 이미 예약된 좌석인 경우, “[예약 실패] 좌석번호: 이미 예약된 좌석입니다.”를 화면에 출력
								return -1; // 리턴값: (0: 성공, -1: 실패)
							}
						}
						else if(seatName.charAt(2)=='B')
						{
							if(seat[2][bz-1]==0)
							{
								System.out.printf("[예약 성공] %s\n",seatName);
								seat[2][bz-1]=1;
								return 0;
							}
							else
							{
								System.out.printf("[예약 실패] %s :이미 예약된 좌석입니다.\n",seatName);
								return -1;
							}
							
						}
						else if(seatName.charAt(2)=='C')
						{
							if(seat[1][bz-1]==0)
							{
								System.out.printf("[예약 성공] %s\n",seatName);
								seat[1][bz-1]=1;
								return 0;
							}
							else
							{
								System.out.printf("[예약 실패] %s :이미 예약된 좌석입니다.\n",seatName);
								return -1;
							}
						}
						else 
						{
							if(seat[0][bz-1]==0)
							{
								System.out.printf("[예약 성공] %s\n",seatName);
								seat[0][bz-1]=1;
								return 0;
							}
							else
							{
								System.out.printf("[예약 실패] %s :이미 예약된 좌석입니다.\n",seatName);
								return -1;
							}
						}
					}
					else
					{
						System.out.println("[예약 실패] : 잘못된 좌석 이름입니다."); // 좌석 이름이 잘못된 경우, “[예약 실패]: 잘못된 좌석 이름입니다” 출력
						return -1;
					}
				}
				else
				{
					System.out.printf("%s: 숫자가 아닌 잘못된 좌석 이름입니다.\n",seatName);
					System.out.println("[예약 실패] : 잘못된 좌석 이름입니다.");
					return -1;
				}
			}
			else 
			{
				if(a=='1'&&b=='0')
				{
					if(seatName.charAt(2)=='A' || seatName.charAt(2)=='B' || seatName.charAt(2)=='C' || seatName.charAt(2)=='D')
					{
						if(seatName.charAt(2)=='A')
						{
							if(seat[3][9]==0)
							{
								System.out.printf("[예약 성공] %s\n",seatName);
								seat[3][9]=1;
								return 0;
							}
							else
							{
								System.out.printf("[예약 실패] %s :이미 예약된 좌석입니다.\n",seatName);
								return -1;
							}
						}
						else if(seatName.charAt(2)=='B')
						{
							if(seat[2][9]==0)
							{
								System.out.printf("[예약 성공] %s\n",seatName);
								seat[2][9]=1;
								return 0;
							}
							else
							{
								System.out.printf("[예약 실패] %s :이미 예약된 좌석입니다.\n",seatName);
								return -1;
							}
						}
						else if(seatName.charAt(2)=='C')
						{
							if(seat[1][9]==0)
							{
								System.out.printf("[예약 성공] %s\n",seatName);
								seat[1][9]=1;
								return 0;
							}
							else
							{
								System.out.printf("[예약 실패] %s :이미 예약된 좌석입니다.\n",seatName);
								return -1;
							}
						}
						else
						{
							if(seat[0][9]==0)
							{
								System.out.printf("[예약 성공] %s\n",seatName);
								seat[0][9]=1;
								return 0;
							}
							else
							{
								System.out.printf("[예약 실패] %s :이미 예약된 좌석입니다.\n",seatName);
								return -1;
							}
						}
					}
					else 
					{
						System.out.printf("%s: 좌석의 범위를 넘은 잘못된 좌석 이름입니다.\n",seatName);
						System.out.println("[예약 실패] : 잘못된 좌석 이름입니다.");
						return -1;
					}
				}
				else
				{
					System.out.printf("%s: 좌석의 범위를 넘은 잘못된 좌석 이름입니다.\n",seatName);
					System.out.println("[예약 실패] : 잘못된 좌석 이름입니다.");
					return -1;
				}
			}

			
		}
		else
		{
			if(seatNum>0 && seatNum<=9)
			{
				if(seatName.charAt(1)=='A' || seatName.charAt(1)=='B' || seatName.charAt(1)=='C' || seatName.charAt(1)=='D')
				{
					if(seatName.charAt(1)=='A')
					{
						if(seat[3][seatNum-1]==0)
						{
							System.out.printf("[예약 성공] %s\n",seatName);
							seat[3][seatNum-1]=1;
							return 0;
						}
						else
						{
							System.out.printf("[예약 실패] %s :이미 예약된 좌석입니다.\n",seatName);
							return -1;
						}
					}
					else if(seatName.charAt(1)=='B')
					{
						if(seat[2][seatNum-1]==0)
						{
							System.out.printf("[예약 성공] %s\n",seatName);
							seat[2][seatNum-1]=1;
							return 0;
						}
						else
						{
							System.out.printf("[예약 실패] %s :이미 예약된 좌석입니다.\n",seatName);
							return -1;
						}
						
					}
					else if(seatName.charAt(1)=='C')
					{
						if(seat[1][seatNum-1]==0)
						{
							System.out.printf("[예약 성공] %s\n",seatName);
							seat[1][seatNum-1]=1;
							return 0;
						}
						else
						{
							System.out.printf("[예약 실패] %s :이미 예약된 좌석입니다.\n",seatName);
							return -1;
						}
					}
					else 
					{
						if(seat[0][seatNum-1]==0)
						{
							System.out.printf("[예약 성공] %s\n",seatName);
							seat[0][seatNum-1]=1;
							return 0;
						}
						else
						{
							System.out.printf("[예약 실패] %s :이미 예약된 좌석입니다.\n",seatName);
							return -1;
						}
					}
				}
				else
				{
					System.out.println("[예약 실패] : 잘못된 좌석 이름입니다.");
					return -1;
				}
			}
			else
			{
				System.out.printf("%s: 숫자가 아닌 잘못된 좌석 이름입니다.\n",seatName);
				System.out.println("[예약 실패] : 잘못된 좌석 이름입니다.");
				return -1;
			}
		}
	}
	
	
	public int cancelSeat(String seatName) {
		
		int n=seatName.length();
		int seatNum=seatName.charAt(0)-'0';
		
	
		if(n==3)
		{
			char a=seatName.charAt(0);
			char b=seatName.charAt(1);
			char c=seatName.charAt(2);
			
			if(a=='0')
			{
				int bz=b-'0';
				
				if(bz>0 && bz<=9)
				{
					if(seatName.charAt(2)=='A' || seatName.charAt(2)=='B' || seatName.charAt(2)=='C' || seatName.charAt(2)=='D')
					{
						if(seatName.charAt(2)=='A')
						{
							if(seat[3][bz-1]==1)
							{
								System.out.printf("[예약 취소 성공] %s\n",seatName); // 예약된 좌석을 취소한 경우, “[예약 취소 성공] 좌석번호” 출력
								seat[3][bz-1]=0;
								return 0;
							}
							else
							{
								System.out.printf("[예약 실패] %s :예약 되지 않은 좌석입니다.\n",seatName); //
								return -1;
							}
						}
						else if(seatName.charAt(2)=='B')
						{
							if(seat[2][bz-1]==1)
							{
								System.out.printf("[예약 취소 성공] %s\n",seatName);
								seat[2][bz-1]=0;
								return 0;
							}
							else
							{
								System.out.printf("[예약 실패] %s :예약 되지 않은 좌석입니다.\n",seatName);
								return -1;
							}
							
						}
						else if(seatName.charAt(2)=='C')
						{
							if(seat[1][bz-1]==1)
							{
								System.out.printf("[예약 취소 성공] %s\n",seatName);
								seat[1][bz-1]=0;
								return 0;
							}
							else
							{
								System.out.printf("[예약 실패] %s :예약 되지 않은 좌석입니다.\n",seatName);
								return -1;
							}
						}
						else 
						{
							if(seat[0][bz-1]==1)
							{
								System.out.printf("[예약 취소 성공] %s\n",seatName);
								seat[0][bz-1]=0;
								return 0;
							}
							else
							{
								System.out.printf("[예약 실패] %s :예약 되지 않은 좌석입니다.\n",seatName);
								return -1;
							}
						}
					}
					else
					{
						System.out.println("[예약 실패] : 잘못된 좌석 이름입니다.");
						return -1;
					}
				}
				else
				{
					System.out.println("[예약 실패] : 잘못된 좌석 이름입니다.");
					return -1;
				}
			}
			else 
			{
				if(a=='1'&&b=='0')
				{
					if(seatName.charAt(2)=='A' || seatName.charAt(2)=='B' || seatName.charAt(2)=='C' || seatName.charAt(2)=='D')
					{
						if(seatName.charAt(2)=='A')
						{
							if(seat[3][9]==1)
							{
								System.out.printf("[예약 취소 성공] %s\n",seatName);
								seat[3][9]=0;
								return 0;
							}
							else
							{
								System.out.printf("[예약 실패] %s :예약 되지 않은 좌석입니다.\n",seatName);
								return -1;
							}
						}
						else if(seatName.charAt(2)=='B')
						{
							if(seat[2][9]==1)
							{
								System.out.printf("[예약 취소 성공] %s\n",seatName);
								seat[2][9]=0;
								return 0;
							}
							else
							{
								System.out.printf("[예약 실패] %s :예약 되지 않은 좌석입니다.\n",seatName);
								return -1;
							}
						}
						else if(seatName.charAt(2)=='C')
						{
							if(seat[1][9]==1)
							{
								System.out.printf("[예약 취소 성공] %s\n",seatName);
								seat[1][9]=0;
								return 0;
							}
							else
							{
								System.out.printf("[예약 실패] %s :예약 되지 않은 좌석입니다.\n",seatName);
								return -1;
							}
						}
						else
						{
							if(seat[0][9]==1)
							{
								System.out.printf("[예약 취소 성공] %s\n",seatName);
								seat[0][9]=0;
								return 0;
							}
							else
							{
								System.out.printf("[예약 실패] %s :예약 되지 않은 좌석입니다.\n",seatName);
								return -1;
							}
						}
					}
					else 
					{
						System.out.println("[예약 실패] : 잘못된 좌석 이름입니다.");
						return -1;
					}
				}
				else
				{
					System.out.println("[예약 실패] : 잘못된 좌석 이름입니다.");
					return -1;
				}

				
			}
		}
		else
		{
			if(seatNum>0 && seatNum<=9)
			{
				if(seatName.charAt(1)=='A' || seatName.charAt(1)=='B' || seatName.charAt(1)=='C' || seatName.charAt(1)=='D')
				{
					if(seatName.charAt(1)=='A')
					{
						if(seat[3][seatNum-1]==1)
						{
							System.out.printf("[예약 취소 성공] %s\n",seatName);
							seat[3][seatNum-1]=0;
							return 0;
						}
						else
						{
							System.out.printf("[예약 실패] %s :예약 되지 않은 좌석입니다.\n",seatName);
							return -1;
						}
					}
					else if(seatName.charAt(1)=='B')
					{
						if(seat[2][seatNum-1]==1)
						{
							System.out.printf("[예약 취소 성공] %s\n",seatName);
							seat[2][seatNum-1]=0;
							return 0;
						}
						else
						{
							System.out.printf("[예약 실패] %s :예약 되지 않은 좌석입니다.\n",seatName);
							return -1;
						}
						
					}
					else if(seatName.charAt(1)=='C')
					{
						if(seat[1][seatNum-1]==1)
						{
							System.out.printf("[예약 취소 성공] %s\n",seatName);
							seat[1][seatNum-1]=0;
							return 0;
						}
						else
						{
							System.out.printf("[예약 실패] %s :예약 되지 않은 좌석입니다.\n",seatName);
							return -1;
						}
					}
					else 
					{
						if(seat[0][seatNum-1]==1)
						{
							System.out.printf("[예약 취소 성공] %s\n",seatName);
							seat[0][seatNum-1]=0;
							return 0;
						}
						else
						{
							System.out.printf("[예약 실패] %s :예약 되지 않은 좌석입니다.\n",seatName);
							return -1;
						}
					}
				}
				else
				{
					System.out.printf("%s: 좌석의 범위를 넘은 잘못된 좌석 이름입니다.\n",seatName);
					System.out.println("[예약 실패] : 잘못된 좌석 이름입니다.");
					return -1;
				}
			}
			else
			{
				System.out.printf("%s: 좌석의 범위를 넘은 잘못된 좌석 이름입니다.\n",seatName);
				System.out.println("[예약 실패] : 잘못된 좌석 이름입니다.");
				return -1;
			}
		}
	}
}
