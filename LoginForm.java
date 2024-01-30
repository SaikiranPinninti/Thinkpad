import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class LoginForm extends JFrame implements ActionListener {
   String id;
   String password;
   JButton b1;
   JPanel newPanel;
   JLabel userLabel;
   JLabel passLabel;
   JTextField textField1;
   JTextField textField2;

   LoginForm() {
      this.setBounds(100, 100, 800, 600);
      this.userLabel = new JLabel("Id");
      this.textField1 = new JTextField(15);
      this.passLabel = new JLabel("Password");
      this.textField2 = new JTextField(15);
      this.b1 = new JButton("SUBMIT");
      this.newPanel = new JPanel();
      this.newPanel.add(this.userLabel);
      this.newPanel.add(this.textField1);
      this.newPanel.add(this.passLabel);
      this.newPanel.add(this.textField2);
      this.newPanel.add(this.b1);
      this.add(this.newPanel);
      this.b1.addActionListener(this);
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == this.b1) {
         this.id = this.textField1.getText();
         this.password = this.textField2.getText();
         if (this.id.equals("saikiran") && this.password.equals("2002")) {
            Notepad n = new Notepad();
            n.setVisible(true);
            this.setVisible(false);
         } else {
            this.textField1.setText("");
            this.textField2.setText("");
         }
      }

   }
}
