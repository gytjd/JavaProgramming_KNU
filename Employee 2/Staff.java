//2020117898 황효성
//사무실 직원 관리 클래스 
package 과제;

public class Staff  extends Employee{
	
	private int annualSalary;
	
	public int getAnnualSalary() { //연봉 계산 함수 (월급 * 12)
		annualSalary=getSalary()*12;
		return annualSalary;
	}
	
	public void printEmployee() { //Staff 멤버 출력 함수 
		System.out.printf("%17s\t%3d%21s\t%6d\t\t %d\n",getName(),getAge(),getPosition(),getSalary(),getAnnualSalary());
	}
	// 이름, 나이, 직위, 월급, 연봉 순서로 화면 출력
	
	
	public void printStaffsalary() {
		System.out.printf("%17s        %5d      \t %5d\n",getName(),getSalary(),getAnnualSalary());
	}
	
	public void printStaffposition() {
		System.out.printf("%17s   %17s\n",getName(),getPosition());
	}
}
