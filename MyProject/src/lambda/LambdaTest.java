package lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LambdaTest{

	public static void main(String[] args) {
		ActionListener act = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("객체임");
			}
		};
		LambdaClass.test(e->{
			
		});
		LambdaClass.test(act);
	}

}
