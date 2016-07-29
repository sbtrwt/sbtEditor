import java.awt.*;  
 import java.awt.event.*;  
 import java.io.*;  
 import java.util.*; 
 
 //Texteditor class starts here  
 class Texteditor extends Frame 
 {  
	 TextArea taMainContent=new TextArea();  
	boolean IsEdit;
	 public Texteditor()  
	 {   
	 	 customKeyListener cstmKeyListen = new customKeyListener(this);
		 this.addKeyListener(cstmKeyListen);
		 taMainContent.addKeyListener(cstmKeyListen);
		 add("Center",taMainContent); 
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
			setAlwaysOnTop( true );
		IsEdit = false;
		try{
		taMainContent.setText(EditFile.load("sbt.txt"));
		}catch(IOException e){}
	 }  
	
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
			System.console().writer().println("window closing");
		 }
		 public void windowActivated(WindowEvent e) {
		 	 System.console().writer().println("window activated");
		 }
		public void windowClosed(WindowEvent e) {System.console().writer().println("window closed");}
		
		public void windowDeactivated(WindowEvent e) { System.console().writer().println("window deactivated");}
		public void windowDeiconified(WindowEvent e) {System.console().writer().println("window deiconified");}
		public void windowIconified(WindowEvent e) { System.console().writer().println("window inconified");}
		public void windowOpened(WindowEvent e) { System.console().writer().println("window opened");}
	 }//Inner class winadapter end.... 
	 public void saveFile(String strPath){
	 	 try{
	 	 EditFile.Save(strPath,taMainContent.getText().toString());
	 	 }catch(IOException e){}
	 }
	
 }//End of Texteditor class  
 public class sbtEditor  
 {
 	 public static void main(String args[])  
	 {  try{
	 	 Texteditor to=new Texteditor();  
	 
	 	 }
	 	 catch(Exception e){}
	 }  
 }  
 