import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame {
   About() {
      this.setBounds(100, 100, 500, 400);
      this.setTitle("About ThinkPad Application");
      this.setDefaultCloseOperation(2);
      this.setLayout((LayoutManager) null);
      ImageIcon icon = new ImageIcon(this.getClass().getResource("my_logo.png"));
      this.setIconImage(icon.getImage());
      JLabel iconLabel = new JLabel(new ImageIcon(this.getClass().getResource("my_logo.png")));
      iconLabel.setBounds(50, 30, 293, 255);
      this.add(iconLabel);
      JLabel textLabel = new JLabel(
            "<html>Welcome to ThinkPad<br>ThinkPad is a simple text editor created by Me Where you can change Font<br>All Rights Reserved@2023</html>");
      textLabel.setBounds(100, 170, 400, 300);
      this.add(textLabel);
   }

   public static void main(String[] args) {
      (new About()).setVisible(true);
   }
}
