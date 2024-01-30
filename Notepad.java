import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.awt.print.PrinterException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Notepad extends JFrame implements ActionListener {
   JMenuBar menubar = new JMenuBar();
   JMenu file = new JMenu("File");
   JMenu edit = new JMenu("Edit");
   JMenu help = new JMenu("Help");
   JMenuItem newFile = new JMenuItem("New");
   JMenuItem openFile = new JMenuItem("Open");
   JMenuItem saveFile = new JMenuItem("Save");
   JMenuItem print = new JMenuItem("Print");
   JMenuItem exit = new JMenuItem("Exit");
   JMenuItem cut = new JMenuItem("Cut");
   JMenuItem copy = new JMenuItem("Copy");
   JMenuItem paste = new JMenuItem("Paste");
   JMenuItem selectAll = new JMenuItem("Select All");
   JMenuItem about = new JMenuItem("About");
   JTextArea textArea = new JTextArea();
   GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
   String[] fontnames;
   JComboBox<String> c;
   JComboBox<String> fontSizeBox;
   JButton colorSelect;
   JButton bgColor;
   JButton bold;
   JButton italic;
   JButton underline;

   Notepad() {
      this.fontnames = this.e.getAvailableFontFamilyNames();
      this.c = new JComboBox(this.fontnames);
      this.fontSizeBox = new JComboBox();
      this.colorSelect = new JButton("Text Color");
      this.bgColor = new JButton("Background Color");
      this.bold = new JButton("Bold");
      this.italic = new JButton("Italic");
      this.underline = new JButton("Underline");
      this.setTitle("ThinkPad Application");
      this.setBounds(100, 100, 800, 600);
      this.setDefaultCloseOperation(3);
      ImageIcon icon = new ImageIcon(this.getClass().getResource("/my_logo.png"));
      this.setIconImage(icon.getImage());
      int s = 10;

      for (int i = 0; i < 50; ++i) {
         this.fontSizeBox.addItem(Integer.toString(s));
         ++s;
      }

      this.file.add(this.newFile);
      this.file.add(this.openFile);
      this.file.add(this.saveFile);
      this.file.add(this.print);
      this.file.add(this.exit);
      this.edit.add(this.cut);
      this.edit.add(this.copy);
      this.edit.add(this.paste);
      this.edit.add(this.selectAll);
      this.help.add(this.about);
      this.setJMenuBar(this.menubar);
      this.menubar.add(this.file);
      this.menubar.add(this.edit);
      this.menubar.add(this.help);
      this.menubar.add(this.bold);
      this.menubar.add(this.italic);
      this.menubar.add(this.underline);
      this.menubar.add(this.c);
      this.c.setMaximumSize(this.c.getPreferredSize());
      this.menubar.add(this.fontSizeBox);
      this.fontSizeBox.setMaximumSize(this.fontSizeBox.getPreferredSize());
      this.menubar.add(this.colorSelect);
      this.menubar.add(this.bgColor);
      JScrollPane scrollPane = new JScrollPane(this.textArea);
      this.add(scrollPane);
      scrollPane.setHorizontalScrollBarPolicy(31);
      scrollPane.setVerticalScrollBarPolicy(20);
      this.textArea.setFont(new Font("SansSerif", 0, 15));
      this.textArea.setLineWrap(true);
      this.textArea.setWrapStyleWord(true);
      this.newFile.addActionListener(this);
      this.openFile.addActionListener(this);
      this.saveFile.addActionListener(this);
      this.print.addActionListener(this);
      this.exit.addActionListener(this);
      this.cut.addActionListener(this);
      this.copy.addActionListener(this);
      this.paste.addActionListener(this);
      this.selectAll.addActionListener(this);
      this.about.addActionListener(this);
      this.c.addActionListener(this);
      this.fontSizeBox.addActionListener(this);
      this.bgColor.addActionListener(this);
      this.colorSelect.addActionListener(this);
      this.bold.addActionListener(this);
      this.italic.addActionListener(this);
      this.underline.addActionListener(this);
      this.newFile.setAccelerator(KeyStroke.getKeyStroke(78, 128));
      this.openFile.setAccelerator(KeyStroke.getKeyStroke(79, 128));
      this.saveFile.setAccelerator(KeyStroke.getKeyStroke(83, 128));
      this.print.setAccelerator(KeyStroke.getKeyStroke(80, 128));
      this.exit.setAccelerator(KeyStroke.getKeyStroke(87, 128));
      this.cut.setAccelerator(KeyStroke.getKeyStroke(88, 128));
      this.copy.setAccelerator(KeyStroke.getKeyStroke(67, 128));
      this.paste.setAccelerator(KeyStroke.getKeyStroke(86, 128));
      this.selectAll.setAccelerator(KeyStroke.getKeyStroke(65, 128));
      this.about.setAccelerator(KeyStroke.getKeyStroke(74, 128));
   }

   public static void main(String[] args) {
      (new LoginForm()).setVisible(true);
   }

   public void encrypt(String filename) {
      try {
         FileWriter fw = new FileWriter(filename);
         String s = this.textArea.getText();

         for (int i = 0; i < s.length(); ++i) {
            fw.write((char) (s.charAt(i) + 4));
         }

         fw.close();
      } catch (IOException var5) {
         var5.printStackTrace();
      }

   }

   public void decrypt(String filename) {
      try {
         FileReader fr = new FileReader(filename);

         int i;
         try {
            while ((i = fr.read()) != -1) {
               this.textArea.append(Character.toString((char) (i - 4)));
            }
         } catch (IOException var6) {
            var6.printStackTrace();
         }

         try {
            fr.close();
         } catch (IOException var5) {
            var5.printStackTrace();
         }
      } catch (FileNotFoundException var7) {
         var7.printStackTrace();
      }

   }

   public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equalsIgnoreCase("New")) {
         this.textArea.setText((String) null);
      } else {
         JFileChooser fileChooser;
         FileNameExtensionFilter textFilter;
         int action;
         String fileName;
         if (e.getActionCommand().equalsIgnoreCase("Open")) {
            this.textArea.setText("");
            fileChooser = new JFileChooser();
            textFilter = new FileNameExtensionFilter("Only text file (.txt)", new String[] { "txt" });
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(textFilter);
            action = fileChooser.showOpenDialog((Component) null);
            if (action != 0) {
               return;
            }

            fileName = fileChooser.getSelectedFile().toString();
            this.decrypt(fileName);
         } else if (e.getActionCommand().equalsIgnoreCase("Save")) {
            fileChooser = new JFileChooser();
            textFilter = new FileNameExtensionFilter("Only text file (.txt)", new String[] { "txt" });
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(textFilter);
            action = fileChooser.showSaveDialog((Component) null);
            if (action != 0) {
               return;
            }

            fileName = fileChooser.getSelectedFile().getAbsolutePath().toString();
            if (!fileName.contains(".txt")) {
               fileName = fileName + ".txt";
            }

            this.encrypt(fileName);
         } else if (e.getActionCommand().equalsIgnoreCase("Print")) {
            try {
               this.textArea.print();
            } catch (PrinterException var6) {
               var6.printStackTrace();
            }
         } else if (e.getActionCommand().equalsIgnoreCase("Exit")) {
            System.exit(0);
         } else if (e.getActionCommand().equalsIgnoreCase("Cut")) {
            this.textArea.cut();
         } else if (e.getActionCommand().equalsIgnoreCase("Copy")) {
            this.textArea.copy();
         } else if (e.getActionCommand().equalsIgnoreCase("Paste")) {
            this.textArea.paste();
         } else if (e.getActionCommand().equalsIgnoreCase("Select All")) {
            this.textArea.selectAll();
         } else if (e.getActionCommand().equalsIgnoreCase("About")) {
            (new About()).setVisible(true);
         }
      }

      Color c;
      if (e.getSource() == this.bgColor) {
         c = JColorChooser.showDialog((Component) null, "ColorChooserDemo", (Color) null);
         this.textArea.setBackground(c);
      }

      if (e.getSource() == this.colorSelect) {
         c = JColorChooser.showDialog((Component) null, "ColorChooserDemo", (Color) null);
         this.textArea.setForeground(c);
         this.textArea.setCaretColor(c);
      }

      int sz;
      String f;
      if (e.getSource() == this.fontSizeBox || e.getSource() == this.c) {
         sz = Integer.parseInt((String) this.fontSizeBox.getItemAt(this.fontSizeBox.getSelectedIndex()));
         f = String.valueOf(this.c.getItemAt(this.c.getSelectedIndex()));
         this.textArea.setFont(new Font(f, 0, sz));
      }

      if (e.getSource() == this.bold) {
         sz = Integer.parseInt((String) this.fontSizeBox.getItemAt(this.fontSizeBox.getSelectedIndex()));
         f = String.valueOf(this.c.getItemAt(this.c.getSelectedIndex()));
         this.textArea.setFont(new Font(f, 1, sz));
      }

      if (e.getSource() == this.italic) {
         sz = Integer.parseInt((String) this.fontSizeBox.getItemAt(this.fontSizeBox.getSelectedIndex()));
         f = String.valueOf(this.c.getItemAt(this.c.getSelectedIndex()));
         this.textArea.setFont(new Font(f, 2, sz));
      }

      // if (e.getSource() == this.underline) {
      // Font f = this.textArea.getFont();
      // Map attr = f.getAttributes();
      // attr.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
      // this.textArea.setFont(f.deriveFont(attr));
      // }

   }
}
