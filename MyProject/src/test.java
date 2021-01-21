class  Class <T>{
	
}

class Gen extends Class{
}

class Class2 <T extends Class>{
	
}

class Exam{
	
}

public class test {
	
	public static void main(String[] args) {
		Class2<Gen> ge;
	}
}
