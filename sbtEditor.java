import java.awt.*;  
 import java.awt.event.*;  
 import java.io.*;  
 import java.util.*; 
 import java.awt.image.BufferedImage;
 import javax.imageio.ImageIO;
 
 //Texteditor class starts here  
 class Texteditor extends Frame 
 {
 	public final String fileName = "sbt.work";
	final TrayIcon trayIcon;
	PopupMenu popup;
	TextField tfCmd = new TextField();
	TextArea taMainContent=new TextArea();  
	boolean IsEdit;
	GridBagConstraints c = new GridBagConstraints();
	 public Texteditor()  //constructor Texteditor
	 {   
	 	 setUndecorated(true);//title bar removed
	
	 	// setIconImage(Toolkit.getDefaultToolkit().getImage("image/sbtwork.png"));
	 	 setIconImage(getImage("image/sbtwork.png"));
	 	// setDefaultCloseOperation(EXIT_ON_CLOSE);
		 MyWindowsAdapter mw=new MyWindowsAdapter(this);  
		 addWindowListener(mw); 
		 setLayout(new GridBagLayout());
		 setSize(500,200);  
		 setTitle("sbtWork");  
		 setVisible(true);  
		 setResizable(false);
		//code for fix postion (right-bottom), always on top
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
			taMainContent.setText(EditFile.load(fileName));//Loading previous content
		}catch(IOException e){}
		//code for adding key listener
	 	 customKeyListener cstmKeyListen = new customKeyListener(this);
		 this.addKeyListener(cstmKeyListen);
		 taMainContent.addKeyListener(cstmKeyListen);
		 tfCmd.addKeyListener(cstmKeyListen);
		//code for layout 
		 c.fill = GridBagConstraints.HORIZONTAL;
		 c.ipady = 15;
		 c.weightx = 1;
		 c.weighty = 0.4;
		 c.gridx = 0;
		 c.gridy = 0;
		 add( tfCmd,c);
		 
		 c.fill = GridBagConstraints.HORIZONTAL;
		 c.ipady = 0;      //make this component tall
		 c.weighty = 0.6;
		 //c.gridwidth = 1;
		 c.gridx = 0;
		 c.gridy = 1;
		 add(taMainContent,c); 
		 //setUndecorated(true);
		
		 
		
			
		//adding mouse listener for system tray
			MouseListener mouseListener = new MouseListener() {
						
				public void mouseClicked(MouseEvent e) {
					setVisible(true);
					System.out.println("Tray Icon - Mouse clicked!");                 
				}
		
				public void mouseEntered(MouseEvent e) {
					System.out.println("Tray Icon - Mouse entered!");                 
				}
		
				public void mouseExited(MouseEvent e) {
					System.out.println("Tray Icon - Mouse exited!");                 
				}
		
				public void mousePressed(MouseEvent e) {
					System.out.println("Tray Icon - Mouse pressed!");                 
				}
		
				public void mouseReleased(MouseEvent e) {
					System.out.println("Tray Icon - Mouse released!");                 
				}
			};
		
			//adding action listener for tray-> menu-> exit
			ActionListener exitListener = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Exiting...");
					System.exit(0);
				}
			};
			//creating popup menu for tray 		
			popup = new PopupMenu();
			MenuItem defaultItem = new MenuItem("Exit");
			defaultItem.addActionListener(exitListener);
			popup.add(defaultItem);
			//creating new instance of tray
			trayIcon = new TrayIcon(getImage("image/sbtwork.gif"), "Tray Demo", popup);
			//Action listener of tray
			ActionListener actionListener = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					trayIcon.displayMessage("Action Event", 
						"sbtWork is in tray list......",
						TrayIcon.MessageType.INFO);
				}
			};
					
			trayIcon.setImageAutoSize(true);
			trayIcon.addActionListener(actionListener);
			trayIcon.addMouseListener(mouseListener);
		
			ShowTrayIcon();
		
	 }  
	
	 public class MyWindowsAdapter extends WindowAdapter  //window event adapter class
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
		
		public void windowDeactivated(WindowEvent e) {
			tt.setVisible(false);  
			System.console().writer().println("window deactivated");
			//tt.ShowTrayIcon();
			System.console().writer().println("after tray icon");
		}
		public void windowDeiconified(WindowEvent e) {System.console().writer().println("window deiconified");}
		public void windowIconified(WindowEvent e) { System.console().writer().println("window inconified");}
		public void windowOpened(WindowEvent e) {tt.setVisible(true);   System.console().writer().println("window opened");}
	 }//Inner class winadapter end.... 
	 public void saveFile(String strPath){
	 	 try{
	 	 EditFile.Save(strPath,taMainContent.getText().toString());
	 	 }catch(IOException e){}
	 }
	
	public void ShowTrayIcon(){
		if (SystemTray.isSupported()) {
			SystemTray tray = SystemTray.getSystemTray();
			try {
				tray.add(trayIcon);
				System.console().writer().println("inside tray icon");
			} catch (AWTException e) {
				System.err.println("TrayIcon could not be added.");
			}		
		}else{System.err.println("TrayIcon could not be added.");}
	}
	public BufferedImage getImage(String imgPath){
		 	 //String imagePath = "image/sbtwork.png";
		 	 InputStream imgStream;
		 	 BufferedImage imgFound = null;
		 	 try{
		 	 	 imgStream = this.getClass().getResourceAsStream(imgPath );
		 	 	 imgFound = ImageIO.read(imgStream);
			 }catch(IOException e){ System.err.println("Image not found");}
		return imgFound;
	}
 }//End of Texteditor class  
 public class sbtEditor  
 {
 	 public static void main(String args[])  
	 { 
	 	 try{
	 	 Texteditor to = new Texteditor();  
	 
	 	 }
	 	 catch(Exception e){}
	 }  
 }  
 