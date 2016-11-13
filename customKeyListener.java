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
		if ((e.getKeyCode() == KeyEvent.VK_ENTER)) {
		 
		  if(teKeyEvent.getCmd().equals("open")){ //open file 
		  	  	if( teKeyEvent.getParameter().isEmpty()){
					teKeyEvent.loadContent();
					teKeyEvent.clearCmd();
					}
				else{
					teKeyEvent.fileName =teKeyEvent.setDefaultFName( teKeyEvent.getParameter());
					teKeyEvent.loadContent();
					teKeyEvent.clearCmd();
				}
			}
		  		
		   if(teKeyEvent.getCmd().equals("clear")){ //clear file 
		  	  teKeyEvent.clearContent();
		  	  teKeyEvent.clearCmd();
		  }
		   if(teKeyEvent.getCmd().equals("save")){ //save file 
		   	   if( teKeyEvent.getParameter().isEmpty()){
				 teKeyEvent.saveFile(teKeyEvent.fileName);
				 teKeyEvent.clearCmd();
		  	   }
		  	   else{
					teKeyEvent.fileName =teKeyEvent.setDefaultFName( teKeyEvent.getParameter());
					teKeyEvent.saveFile(teKeyEvent.fileName);
					teKeyEvent.clearCmd();
				}
		  }
		    if(teKeyEvent.getCmd().equals("hide")){ //hide 
		  	 teKeyEvent.hideOn();
		  	 teKeyEvent.clearCmd();
		  }
		  if(teKeyEvent.getCmd().equals("now")){ //hide 
		  	 teKeyEvent.openNow();
		  	 teKeyEvent.loadContent();
		  	 teKeyEvent.clearCmd();
		  }
		   if(teKeyEvent.getCmd().equals("exit")){ //exit 
		  	 teKeyEvent.exit();
		  }
		}
	}
   @Override
	public void keyReleased(KeyEvent e) {}
   @Override
	public void keyTyped(KeyEvent e){}

}