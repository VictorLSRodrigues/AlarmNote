package util;

import control.ScheduleControl;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.JFrame;

public class NoteTray {
    
    private TrayIcon trayIcon;
    private PopupMenu popup;
    private MenuItem openItem;
    private MenuItem exitItem;
    private SystemTray tray;
    private Image image;
    private JFrame jFrame;
    private ScheduleControl scheduleCtr;
    
    public NoteTray(JFrame jFrame){
        this.popup = new PopupMenu();
        this.openItem = new MenuItem("Abrir");
        this.exitItem = new MenuItem("Sair");
        this.image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/tray.png"));
        this.trayIcon = new TrayIcon(image, "AlarmNote", popup);
        this.trayIcon.setImageAutoSize(true);
        this.jFrame = jFrame;
        this.scheduleCtr = new ScheduleControl();
    }
    
    public void createNoteTray(){
        
        try {
        this.tray = SystemTray.getSystemTray();
        this.popup.add(openItem);
        this.popup.add(exitItem);
        
        this.openItem.addActionListener(getActionMaximize());
        this.trayIcon.addActionListener(getActionMaximize());
        
        this.exitItem.addActionListener(getActionClose());
        
        this.tray.add(trayIcon);
        
        this.scheduleCtr.initAlarms(trayIcon);
        
        } catch (AWTException ex) {
            System.out.println("Erro ao carregar NoteTray");
        }
    }
    
    private ActionListener getActionMaximize(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               jFrame.setVisible(true);
            }
            
        };
    }
    
    private ActionListener getActionClose(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
            
        };
    }
    
    public void minimize(){
        trayIcon.displayMessage("Eiiiii", "Ainda continuo aqui o/", TrayIcon.MessageType.INFO);

    }
    
}
