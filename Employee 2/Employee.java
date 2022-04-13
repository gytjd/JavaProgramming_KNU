//2020117898 황효성
package 과제;

public class Employee {
	
	private int age;
	private String position;
	private String firstname;
	private String lastname;
	private String fullname;
	private int salary;
	
	// private로 선언해서 사용 
	
	
	public Employee() {
		age=0;
		firstname="";
		lastname="";
		salary=0;
	}

	public void setAge(int age) //나이 입력 함
	{
		this.age=age;
	}	
	public void setPosition(String position) //직위 입력 함수 
	{
		this.position=position;
	}
	
	public void setName(String firstname,String lastname) //이름 입력 함수 
	{
		this.firstname=firstname;
		this.lastname=lastname;
		this.fullname=firstname+" "+lastname;
	}
	public void setSalary(int salary) // 월급 입력 함수 
	{
		this.salary=salary;
	}
	
	public void printEmployee() // 한 명의 직원 정보 출력 함수
	{
		System.out.printf("%17s\t%3d%30s\n",getName(),getAge(),getPosition());
		// 이름 , 나이 , 직위 , 월급 순 
	}
	
	
	public String getName() // 이름 반환 함수 
	{
		return fullname;
	}
	public int getSalary() // 월급 반환 함수 
	{
		return salary;
	}
	public String getPosition() // 직위 반환 함수 
	{
		return position;
	}
	public int getAge() // 나이 반환 함수 
	{
		return age;
	}
	
	
}
