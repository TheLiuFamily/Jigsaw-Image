/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testimage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author LG
 */
public class TestImage  extends JFrame {

    /**
     * @param args the command line arguments
     */
    private static final long serialVersionUID = 1001L;
    
    public static void main(String[] args) {
        // TODO code application logic here
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TestImage frame = new TestImage();
                    frame.setVisible(true);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public TestImage() {
        super();
        getContentPane().setLayout(new BorderLayout());
        setTitle("拼图游戏");
        setBounds(300, 300, 358, 414);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);
        final GamePanel gamePanel = new GamePanel();
        getContentPane().add(gamePanel, BorderLayout.CENTER);
        final JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                gamePanel.random();
            }
        });
        button.setText("开始");
        panel.add(button);
    }
}
