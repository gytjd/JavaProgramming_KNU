//2020117898 황효성

public class Employee {
	
	int age;
	String position;
	String firstname;
	String lastname;
	String fullname;
	int salary;
	
	
	public Employee() {
		
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
		this.fullname=firstname+lastname;
	}
	public void setSalary(int salary) // 월급 입력 함수 
	{
		this.salary=salary;
	}
	
	
	public String getName() // 이름 리턴 함수 
	{
		return fullname;
	}
	public int getSalary() // 월급 리턴 함수 
	{
		return salary;
	}
	public String getPosition() // 직위 리턴 함수 
	{
		return position;
	}
	public int getAge() // 나이 리턴 함수 
	{
		return age;
	}
	
	
	public void printEmployeeInfo(int n) // 한 명의 직원 정보 출력 함수 (메뉴 1)
	{
		System.out.printf("[%d]%17s\t%3d%30s\t%4d\n",n+1,getName(),getAge(),getPosition(),getSalary());
		// 이름 , 나이 , 직위 , 월급 순 
	}
	
	public void printEmployeePositionInfo(int n) // 직위만 출력하기 위한 함수 (메뉴 2)
	{
		System.out.printf("[%d]%17s\t%3d%30s\n",n+1,getName(),getAge(),getPosition());

	}
	
	public void printEmployeeSalaryInfo(int n) // 월급만 출력하기 위한 함수(메뉴 3)
	{
		System.out.printf("[%d]%17s\t%3d%20d\n",n+1,getName(),getAge(),getSalary());

	}
	
	
	
	
}
