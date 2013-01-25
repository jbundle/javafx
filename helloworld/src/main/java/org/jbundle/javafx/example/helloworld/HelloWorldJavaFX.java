package org.jbundle.javafx.example.helloworld;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/*
 * HelloWorldSwing.java requires no other files.
 * Thanks Oracle for some of this code!
 */

public class HelloWorldJavaFX extends JApplet {
    private static final long serialVersionUID = 1L;
    
    public void init() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                
                final JFXPanel fxPanel = new JFXPanel();
                getContentPane().add(fxPanel, BorderLayout.CENTER);
                setVisible(true);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        initFX(fxPanel);
                    }
               });
                
            }
        });
        
    }
    private void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    public static Scene createScene() {
        Group root = new Group();
        Scene scene = new Scene(root, Color.ALICEBLUE);
        Text text = new Text();
        text.setX(40);
        text.setY(100);
        text.setFont(new Font(25));
        text.setText("Hello JavaFX!");
        root.getChildren().add(text);
        return (scene);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                JFrame frame = new JFrame("JavaFX Hello World");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JApplet applet = new HelloWorldJavaFX();
                applet.init();

                frame.setContentPane(applet.getContentPane());

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setSize(new Dimension(400, 400));
                frame.setVisible(true);

                applet.start();
            }
        });
    }

}