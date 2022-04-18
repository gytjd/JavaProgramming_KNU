package 중간고사;

public class YutPlayer implements YutInterface{
	
	String name;
	int score;
	int total_score;
	int Yut[]=new int[4];
	int ratio[]=new int[6];
	int ccount;
	
	public YutPlayer(String name) {
		this.name=name; // 생성자에 사람 이름을 입력 받음
	}
	@Override
	public int castYut() {
		
		int i;
		int count=0;
		for(i=0;i<4;i++)
		{
			this.Yut[i]=(int) (Math.random()*2);

		}
		
		for(i=0;i<4;i++)
		{
			if(Yut[i]==1)
			{
				count++;
			}
		}
		
		ccount++;
		
		if(count==0)
		{
			this.score=4;
			this.total_score+=4;
			this.ratio[score]++;
			return 4;
		}
		else if(count==4)
		{
			this.score=5;
			this.total_score+=5;
			this.ratio[score]++;
			return 5;
		}
		else
		{
			this.score=count;
			this.total_score+=count;
			this.ratio[score]++;
			return count;
		}
	}
	
	public String scorename(int a)
	{
		if(a==1)
		{
			return "도";
		}
		else if(a==2)
		{
			return "개";
		}
		else if(a==3)
		{
			return "걸";
		}
		else if(a==4)
		{
			return"윷";
		}
		else if(a==5)
		{
			return "모";
		}
		else
		{
			return "";
		}
	}
	@Override
	public int getTotalScore() { // 현재까지 누적된 점수 리턴
		
		return this.total_score;
	}
	
	@Override
	public int compareTo(Object obj) { // 두사람의누적점수를비교하여승패를계산
		YutPlayer player=(YutPlayer)obj;
		
		if(player.getTotalScore()<this.getTotalScore())
		{
			return 1;
		}
		else if(player.getTotalScore()>this.getTotalScore())
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
	@Override
	public String toString() { // 객체 출력을 위한 오버라이딩
		
		if(this.name=="흥부")
		{
			return String.format("%s [%d %d %d %d] %s (%d점/총 %2d점)--->\n",this.name,this.Yut[0],this.Yut[1],this.Yut[2],this.Yut[3],
					this.scorename(this.score),this.score,this.getTotalScore());
		}
		else {
			return String.format("                                 <---%s [%d %d %d %d] %s (%d점/총 %2d점)\n",this.name,this.Yut[0],this.Yut[1],this.Yut[2],this.Yut[3],
					this.scorename(this.score),this.score,this.getTotalScore());
		}
	}
	
	@Override
	public void displayResult() { // 경기가 종료된 다음,각 점수(도,개,걸,윷,모)의 발생 비율을%로 계산
		System.out.println("--------------------------------------------------");
		System.out.println("       도      개       걸       윷       모   단위(%)");
		System.out.println("--------------------------------------------------");
		System.out.printf("%s   %2.1f    %2.1f    %2.1f     %2.1f    %2.1f\n",this.name,((double)this.ratio[1]/ccount)*100,((double)this.ratio[2]/ccount)*100,((double)this.ratio[3]/ccount)*100,((double)this.ratio[4]/ccount)*100,((double)this.ratio[5]/ccount)*100);
	}

}
