package lambda;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class LambdaClass {
	public static ActionListener test(ActionListener actionListener) {
		return actionListener;
	}
}
