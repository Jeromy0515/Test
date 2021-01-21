import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class FieldTest {
	
	String field[] = {"txt1", "txt2","txt3"};
	
	public FieldTest() {
		JFrame frame = new JFrame();
		for(String str: field) {
			JTextField jtf = new JTextField(20);
			jtf.setName(str);
			frame.add(jtf);
		}
		frame.setLayout(new FlowLayout());
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	
	}
	
	public static void main(String[] args) {
		new FieldTest();
	}
}
