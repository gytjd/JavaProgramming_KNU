package 과제2;

import java.util.Scanner;


public class ReservationApp {
	
	
	public void print_menu()
	{
		Scanner scanner=new Scanner(System.in);
		
		
		AirlineSystem airline=new AirlineSystem(scanner); // 화면 입력을 위해 생성한 Scanner 객체는 AirlineSystem 클래스와 BusSystem 클래스의 생성자의 파라미터로 전달하여 하나의 Scanner 객체를 공유함
		
		airline.makeSeats(4, 10);
		
		
		BusSystem bus=new BusSystem(scanner);
		bus.makeSeats(3, 10); // “0번 통합 예약 시스템 종료” 메뉴를 선택하기 전까지는 기존 예약된 현황을 유지하고 있어야 됨
		
		
		
		while(true)
		{
			String menuNum;
			int menuNumber;
			char menuchar;
			
			System.out.println("--------------------------------------------"); // 메인 메뉴를 화면에 출력하고, 사용자 입력 처리(오류 처리 기능 추가 )
			System.out.println("K-Startup의 통합 예약 시스템을 방문해 주서 감사합니다.");
			System.out.println("   1. 항공사 예약 시스템");
			System.out.println("   2. 버스 예약 시스템");
			System.out.println("   0. 통합 예약 시스템 종료");
			System.out.println("--------------------------------------------");
			System.out.print("메뉴를 선택해주세요 : ");
			
			menuNum=scanner.next();
			menuNumber=menuNum.charAt(0)-'0'; // 사용자의 선택에 따라 항공사 예약 시스템 또는 버스 예약 시스템 기능을 실행시킴
			menuchar=menuNum.charAt(0);
	
			if(menuNumber==1)
			{
				int n;
				while(true)
				{
					System.out.println("-------------------");
					System.out.println("항공사 예약 시스템");
					System.out.println("1. 좌석 예약");
					System.out.println("2. 예약 취소");
					System.out.println("3. 예약 현황 조회");
					System.out.println("4. 메인 메뉴로 돌아가기");
					System.out.println("-------------------");
					System.out.print("번호를 선택해주세요 : ");
					
					airline.set_airlineNum();
					airline.set_airlen();
					airline.set_airlineNumber();
					airline.set_aritlineChar();
					
					if(airline.airlen==1)
					{
						if(airline.airlineNumber==1)
						{
							System.out.print("예약할 좌석 이름을 입력하세요 : ");
							airline.set_airlineReserve();
							
							if(airline.reserveSeat(airline.airlineReserve)==0)
							{
								airline.displaySeat("항공사 예약 시스템");
							}
						}
						else if(airline.airlineNumber==2)
						{
							System.out.print("취소할 좌석 이름을 입력하세요 : ");
							airline.set_airlineCancel();
							if(airline.cancelSeat(airline.airlineCancel)==0)
							{
								airline.displaySeat("항공사 예약 시스템");
							}
						}
						else if(airline.airlineNumber==3)
						{
							airline.displaySeat("항공사 예약 시스템");
						}
						else if(airline.airlineNumber==4)
						{
							System.out.println("항공사 예약 시스템을 종료하고 메인 메뉴로 돌아갑니다.");
							break;
						}
						else 
						{
							if((airline.airlineChar>='a' && airline.airlineChar<='z')||(airline.airlineChar>='A'&& airline.airlineChar<='Z'))
							{
								System.out.println("잘못된 메뉴 선택입니다.숫자를 다시 입력하세요(1~4).");
							}
							else
							{
								System.out.println("잘못된 메뉴 선택입니다. 다시 입력하세요(1~4).");
							}
						}
					}
					else
					{
						if((airline.airlineChar>='a' && airline.airlineChar<='z')||(airline.airlineChar>='A'&& airline.airlineChar<='Z'))
						{
							System.out.println("잘못된 메뉴 선택입니다.숫자를 다시 입력하세요(1~4).");
						}
						else
						{
							System.out.println("잘못된 메뉴 선택입니다. 다시 입력하세요(1~4).");
						}
					}
				}
			
			}
			else if(menuNumber==2)
			{
				
				
				while(true)
				{
					System.out.println("-------------------");
					System.out.println("버스 예약 시스템");
					System.out.println("1. 좌석 예약");
					System.out.println("2. 예약 취소");
					System.out.println("3. 예약 현황 조회");
					System.out.println("4. 메인 메뉴로 돌아가기");
					System.out.println("-------------------");
					System.out.print("번호를 선택해주세요 : ");
					bus.set_busNum();
					bus.set_buslen();
					bus.set_busNumber();
					bus.set_busChar();

					
					if(bus.buslen==1)
					{
						if(bus.busNumber==1)
						{
							
							System.out.print("예약할 좌석 이름을 입력하세요 : ");
							bus.set_busReserve();
							
							if(bus.reserveSeat(bus.busReserve)==0)
							{
								bus.displaySeat("버스 예약 시스템");
							}
							
							
						}
						else if(bus.busNumber==2)
						{
							System.out.print("취소할 좌석 이름을 입력하세요 : ");
						    bus.set_busCancel();
						    
							if(bus.cancelSeat(bus.busCancel)==0)
							{
								bus.displaySeat("버스 예약 시스템");
							}
							
						}
						else if(bus.busNumber==3)
						{
							bus.displaySeat("버스 예약 시스템");
						}
						else if(bus.busNumber==4)
						{
							System.out.println("버스 예약 시스템을 종료하고 메인 메뉴로 돌아갑니다.");
							break;
						}
						else 
						{
							if((bus.busChar>='a' && bus.busChar<='z')||(bus.busChar>='A'&& bus.busChar<='Z'))
							{
								System.out.println("잘못된 메뉴 선택입니다.숫자를 다시 입력하세요(1~4).");
							}
							else
							{
								System.out.println("잘못된 메뉴 선택입니다. 다시 입력하세요(1~4).");
							}
						}
					}
					else
					{
						if((bus.busChar>='a' && bus.busChar<='z')||(bus.busChar>='A'&& bus.busChar<='Z'))
						{
							System.out.println("잘못된 메뉴 선택입니다.숫자를 다시 입력하세요(1~4).");
						}
						else
						{
							System.out.println("잘못된 메뉴 선택입니다. 다시 입력하세요(1~4).");
						}
					}
				}
			}
			else if(menuNumber==0)
			{
				System.out.println("K-Startup 통합 예약 시스템을 종료합니다.");
				break;
			}
			else
			{	
				if((menuchar>='a' && menuchar<='z')||(menuchar>='A'&& menuchar<='Z'))
				{
					System.out.println("잘못된 메뉴 선택입니다.숫자를 다시 입력하세요(0~2).");
				}
				else
				{
					System.out.println("잘못된 메뉴 선택입니다. 다시 입력하세요(0~2).");
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReservationApp app=new ReservationApp();
		app.print_menu();
	}

}
