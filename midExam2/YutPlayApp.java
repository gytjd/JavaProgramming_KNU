package 중간고사;

public class YutPlayApp {
	
	public void play_yut()
	{
		YutPlayer aPlayer=new YutPlayer("흥부"); // 두 명의 YutPlayer객체를 생성하고 생성자에 "흥부", "놀부" 입력
		YutPlayer bPlayer=new YutPlayer("놀부");
		
		
		while(aPlayer.total_score<=20 && bPlayer.total_score<=20) // 두 명중 한 명의 점수가 20점 이상 될 때까지 반복
		{
			while(true)
			{
				aPlayer.castYut(); 
				System.out.printf("%s",aPlayer.toString()); // 한 번씩 윷을 던질 때마다, 그 결과값을 화면에 출력
				if(aPlayer.score!=4 && aPlayer.score!=5) // "모"나 "윷"이 나오면, 다시 한 번 던짐
				{
					break;
				}
			}
			
			while(true)
			{
				bPlayer.castYut();
				System.out.printf("%s",bPlayer.toString());
				if(bPlayer.score!=4 && bPlayer.score!=5)
				{
					break;
				}
			}
			
		}
		
		if(aPlayer.compareTo(bPlayer)==1)
		{
			System.out.println("흥부: "+aPlayer.total_score+", "+"놀부: "+bPlayer.total_score+" ==> 흥부 승리");
		}
		else if(aPlayer.compareTo(bPlayer)==-1)
		{
			System.out.println("흥부: "+aPlayer.total_score+", "+"놀부: "+bPlayer.total_score+" ==> 놀부 승리");
		}
		else 
		{
			System.out.println("흥부: "+aPlayer.total_score+", "+"놀부: "+bPlayer.total_score+" ==> 비김");
		}
		
		aPlayer.displayResult(); // 게임이 종료되면 승패 결과를 화면에 출력하고, 각 점수별 발생 비율을 %로 출력
		bPlayer.displayResult();
		
		
	}
	public static void main(String[] args) {
		
		YutPlayApp yutPlayApp=new YutPlayApp();
		yutPlayApp.play_yut();


	}

}
