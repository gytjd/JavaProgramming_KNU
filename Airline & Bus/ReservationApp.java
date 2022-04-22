package 과제2;

import java.util.Scanner;




public class ReservationApp {
	
	public void print_menu()
	{
		Scanner scanner=new Scanner(System.in);
		int menuNum;
		
		while(true)
		{
			System.out.println("------------------------------------");
			System.out.println("K-Startup의 통합 예약 시스템을 방문해 주셔서 감사합니다.");
			System.out.println("  1. 항공사 예약 시스템");
			System.out.println("  2. 버스 예약 시스템");
			System.out.println("  0. 통합 예약 시스템 종료");
			System.out.println("------------------------------------");
			
		try {
			System.out.print("메뉴를 선택해주세요: ");
			menuNum=scanner.nextInt();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("잘못된 메뉴 선택입니다. 다시 입력해주세요 (0~2)");
			scanner.nextLine();
			continue;
		}
			
			if(menuNum==1)
			{
				AirlineSystem airlineSystem=new AirlineSystem(scanner);
				airlineSystem.makeSeats(4, 10);
				
				
				while(true)
				{
					System.out.println("--------------------");
					System.out.println("항공기 예약 시스템");
					System.out.println("1. 좌석 예약");
					System.out.println("2. 예약 취소");
					System.out.println("3. 예약 현황 조회");
					System.out.println("4. 메인 메뉴로 돌아가기");
					System.out.println("--------------------");
					
					
					try {
						System.out.print("번호를 선택해주세요: ");
						airlineSystem.set_airlineMenunum();
						
					} catch (Exception e) {
						// TODO: handle exception
						
						System.out.println("잘못된 메뉴 선택입니다. 숫자를 다시 입력해주세요 (1~4)");
						scanner.nextLine();
						continue;
					}
					
					if(airlineSystem.airlineMenunum==1)
					{
						System.out.print("예약할 좌석 이를을 입력하세요: ");
						airlineSystem.set_airlineSeat();
						if(airlineSystem.reserveSeat(airlineSystem.airlineSeat)==1)
						{
							airlineSystem.displaySeat("항공기 예약 시스템");
						}
					}
					else if(airlineSystem.airlineMenunum==2)
					{
						System.out.print("취소할 좌석 이를을 입력하세요: ");
						airlineSystem.set_airlineSeat();
						if(airlineSystem.cancelSeat(airlineSystem.airlineSeat)==1)
						{
							airlineSystem.displaySeat("항공기 예약 시스템");
						}
					}
					else if(airlineSystem.airlineMenunum==3)
					{
						airlineSystem.displaySeat("항공기 예약 시스템");
					}
					else if(airlineSystem.airlineMenunum==4)
					{
						System.out.println("항공기 예약 시스템을 종료하고 메인 메뉴로 돌아갑니다.");
						break;
					}
					else
					{
						System.out.println("잘못된 메뉴 선택입니다. 다시 입력하세요(1~4).");
					}
				}
			}
			else if(menuNum==2)
			{
				BusSystem busSystem=new BusSystem(scanner);
				
				busSystem.makeSeats(3, 10);
				
				int busNum;
				
				while(true)
				{
					System.out.println("--------------------");
					System.out.println("버스 예약 시스템");
					System.out.println("1. 좌석 예약");
					System.out.println("2. 예약 취소");
					System.out.println("3. 예약 현황 조회");
					System.out.println("4. 메인 메뉴로 돌아가기");
					System.out.println("--------------------");
					
					
					try {
						System.out.print("번호를 선택해주세요: ");
						busSystem.set_busMenunum();
						
					} catch (Exception e) {
						// TODO: handle exception
						
						System.out.println("잘못된 메뉴 선택입니다. 숫자를 다시 입력해주세요 (1~4)");
						scanner.nextLine();
						continue;
					}
					
					if(busSystem.busMenunum==1)
					{
						System.out.print("예약할 좌석 이름을 입력하세요: ");
						busSystem.set_busSeat();
						if(busSystem.reserveSeat(busSystem.busSeat)==1)
						{
							busSystem.displaySeat("버스 예약 시스템");
						}
					}
					else if(busSystem.busMenunum==2)
					{
						System.out.print("취소할 좌석 이름을 입력하세요: ");
						busSystem.set_busSeat();
						
						if(busSystem.cancelSeat(busSystem.busSeat)==1)
						{
							busSystem.displaySeat("버스 예약 시스템");
						}
					}
					else if(busSystem.busMenunum==3)
					{
						busSystem.displaySeat("버스 예약 시스템");
					}
					else if(busSystem.busMenunum==4)
					{
						System.out.println("버스 예약 시스템을 종료하고 메인 메뉴로 돌아갑니다.");
						break;
					}
					else
					{
						System.out.println("잘못된 메뉴 선택입니다. 다시 입력하세요(1~4).");
					}
				}
				
				
				
			}
			else if(menuNum==0)
			{
				System.out.println("K-Startup 통합 예약 시스템을 종료합니다.");
				break;
			}
			else 
			{
				System.out.println("잘못된 메뉴 선택입니다. 다시 입력해주세요 (0~2)");
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReservationApp reservationApp=new ReservationApp();
		reservationApp.print_menu();
	}

}
