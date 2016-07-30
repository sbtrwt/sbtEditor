import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class customKeyListener implements KeyListener {
	Texteditor teKeyEvent;
	public customKeyListener(Texteditor teFound){
		teKeyEvent = teFound;
	}
   @Override
	public void keyPressed(KeyEvent e){
	    if ((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                   teKeyEvent.saveFile(Texteditor.fileName);
                }
	}
   @Override
	public void keyReleased(KeyEvent e) {}
   @Override
	public void keyTyped(KeyEvent e){}

}