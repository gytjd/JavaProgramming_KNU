//2020117898 황효성 
//개발자 관리 클래스

package 과제;

public class Engineer extends Employee{
	
	private int annualSalary;
	private int overWorkingPay;
	private int overWorkingDay;
	
	public void printEmployee() { // Engineer 멤버 출력 함수
		System.out.printf("%17s\t%3d%21s\t      %3d\t  %3d\t\t %4d\n",getName(),getAge(),getPosition(),getOverworkingPay(),getSalary(),getAnnualSalary());
	}
	
	public void printEngineersalary() {
		System.out.printf("%17s        %5d      \t %5d\n",getName(),getSalary(),getAnnualSalary());
	}
	
	public void printEngineerposition() {
		System.out.printf("%17s   %17s\n",getName(),getPosition());
	}
	
	public void setOverworkingDay(int day) { // 매달 초과 근무 일수 저장
		this.overWorkingDay=day;
	}
	
	public int getOverworkingPay() { // 초과 근무 비용 계산 (하루 3만원)
		this.overWorkingPay=this.overWorkingDay*3;
		return overWorkingPay;
	}
	
	public int getAnnualSalary() { // 연봉 계산 함수: (월급+초과근무수당)x12
		this.annualSalary=(getOverworkingPay()+getSalary())*12;
		return annualSalary;
	}
}
