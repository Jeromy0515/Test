import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Macro extends Robot implements Runnable{
	
	Macro() throws AWTException {
		mouseMove(500, 400);
	}
	
	
	@Override
	public void run() {
		
	}
	
	public static void main(String[] args) {
		try {
			new Macro();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	private void click() {
		mousePress(InputEvent.BUTTON1_DOWN_MASK);//눌렀다
		mouseRelease(InputEvent.BUTTON1_DOWN_MASK);//때기
	}
	
	private void doubleClick() {
		mousePress(InputEvent.BUTTON1_DOWN_MASK);
		mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		mousePress(InputEvent.BUTTON1_DOWN_MASK);
		mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

	}
}
