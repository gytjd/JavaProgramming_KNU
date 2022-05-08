//2020117898 황효성

package 과제3;

public class Card {
	
	String suit;
	String number;
	
	public Card(String suit,String numString) { // 생성자 구현(suit, numString)으로 구현
		// TODO Auto-generated constructor stub
		this.suit=suit;
		this.number=numString;
	}
	
	@Override
	public String toString() { // toString() overriding 구현: 모양(suit)과 번호(numString)를 아래와 같이 구성
		// TODO Auto-generated method stub
		return String.format("(%s%5s)",suit, number);
	}

}
