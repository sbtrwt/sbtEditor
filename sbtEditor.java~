import java.awt.*;  
 import java.awt.event.*;  
 import java.io.*;  
 import java.util.*; 

 //Texteditor class starts here  
 class Texteditor extends Frame implements ActionListener ,WindowListener
 {  
	 TextArea ta=new TextArea();  
	
	 public Texteditor()  
	 {   
		 add("Center",ta); 
		 MyWindowsAdapter mw=new MyWindowsAdapter(this);  
		 addWindowListener(mw);  
		 setSize(500,200);  
		 setTitle("sbtWork");  
		 setVisible(true);  
		 setResizable(false);
				GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
			Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
			int x = (int) rect.getMaxX() - this.getWidth();
			int y = (int) rect.getMaxY() - this.getHeight();
			this.setLocation(x, y);
			this.setVisible(true);
	 }  
	 public void actionPerformed(ActionEvent ae)  
	 {  
		 String arg=(String)ae.getActionCommand();  
		
	 }//Action pereformed end  
	 public class MyWindowsAdapter extends WindowAdapter  
	 {  
		 Texteditor tt;  
		 public MyWindowsAdapter(Texteditor ttt)  
		 {  
			 tt=ttt;  
		 }  
		 public void windowClosing(WindowEvent we)  
		 {  
			tt.dispose();  
		 }  
	 }//Inner class winadapter end.... 
	 
public void windowActivated(WindowEvent e) {ta.setText("window activated");
  System.console().writer().println("1");
}
public	 void windowClosed(WindowEvent e) {ta.setText("window closed");System.console().writer().println("1");}
public	 void windowClosing(WindowEvent e) {ta.setText("window closing");System.console().writer().println("1");}
public	 void windowDeactivated(WindowEvent e) {ta.setText("window deactivated");System.console().writer().println("1");}
	public void windowDeiconified(WindowEvent e) {ta.setText("window deiconified");System.console().writer().println("1");}
	 public void windowIconified(WindowEvent e) {ta.setText("window inconified");System.console().writer().println("1");}
	 public void windowOpened(WindowEvent e) {ta.setText("window opened");System.console().writer().println("1");}
 }//End of Texteditor class  
 public class sbtEditor  
 {
 	 public static void main(String args[])  
	 {  
	 Texteditor to=new Texteditor();  
	 }  
 }  
 