package Image;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Frame extends JFrame{

            public Frame(){
                int width = Toolkit.getDefaultToolkit().getScreenSize().width;
                int height = Toolkit.getDefaultToolkit().getScreenSize().height;

                this.setSize(width, height);
                int frameWidth = this.getSize().width;
                int frameHeight = this.getSize().height;
                this.setLocation((width-frameWidth)/2, (height-frameHeight)/2);

                JLabel label = new JLabel();
                add(label);

                JFileChooser option = new JFileChooser();
                option.setCurrentDirectory(new File("."));

                JMenuBar menuBar = new JMenuBar();
                setJMenuBar(menuBar);

                JMenu menu = new JMenu("File");
                menuBar.add(menu);

                JMenuItem open = new JMenuItem("Open");
                menu.add(open);
                open.addActionListener(event -> {
                    int result = option.showOpenDialog(null);

                    if(result == JFileChooser.APPROVE_OPTION){
                        String name = option.getSelectedFile().getPath();
                        label.setIcon(new ImageIcon(name));
                    }
                        }
                );

                setTitle("Image Viewer");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);

            }
}
