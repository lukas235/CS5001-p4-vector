package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import model.Model;

public class GuiDelegate implements Observer{
 private Model model;

 private JFrame jFrame;
 private Container borderPane;
 private JMenuBar jMenuBar;
 private JToolBar jToolBar;
 private DrawPanel drawPanel;
 private JToolBar leftBar;
 private JToolBar downBar;
 private JColorChooser jColorChooser;

 public GuiDelegate(Model model) {
  this.model = model;
  jFrame = new JFrame("Vactorz");
  jMenuBar = new JMenuBar();
  jToolBar = new JToolBar();
  leftBar = new JToolBar();
  jMenuBar = new JMenuBar();
  drawPanel = new DrawPanel(model);
  jColorChooser = new JColorChooser();
  downBar = new JToolBar();

  setupComponents();
  model.addObserver(this);
 }

 private void setupComponents() {
  setupMenu();
  setupToolBar();
  setupLeftBar();
  setupDownBar();

  borderPane = jFrame.getContentPane();
  borderPane.setLayout(new BorderLayout());

  borderPane.add(jToolBar, BorderLayout.NORTH);
  borderPane.add(drawPanel, BorderLayout.CENTER);
  borderPane.add(leftBar, BorderLayout.WEST);
  borderPane.add(downBar, BorderLayout.SOUTH);
  //  borderPane.add(jColorChooser.getPreviewPanel(), BorderLayout.SOUTH);

  jFrame.setSize(800, 600);
  jFrame.setVisible(true);
  jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);

 }

 private void setupMenu() {
  JMenu file = new JMenu("File");
  JMenu edit = new JMenu("Edit");
  JMenuItem load = new JMenuItem("Load");
  JMenuItem save = new JMenuItem("Save");
  JMenuItem undo = new JMenuItem("Undo");
  JMenuItem redo = new JMenuItem("Redo");
  file.add(load);
  file.add(save);
  edit.add(undo);
  edit.add(redo);
  jMenuBar.add(file);
  jMenuBar.add(edit);

  load.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    JOptionPane.showMessageDialog(jFrame, "Ooops, Load not linked to model!");
   }
  });
  save.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    JOptionPane.showMessageDialog(jFrame, "Ooops, Save not linked to model!");
   }
  });
  undo.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    model.undo();
   }
  });
  redo.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    model.redo();
   }
  });
  jFrame.setJMenuBar(jMenuBar);
 }

 private void setupToolBar() {

  JLabel label = new JLabel("Toolbar: ");

  jToolBar.add(label);
 }

 private void setupLeftBar() {
  JLabel label = new JLabel("SideBar: ");

  leftBar.add(label);

 }

 private void setupDownBar() {
  JLabel label = new JLabel("DownBar: ");
  JButton colorButton = new JButton();

  colorButton.setSize(32, 32);
  colorButton.setBackground(Color.BLACK);
  colorButton.addActionListener(new ActionListener() {

   @Override
   public void actionPerformed(ActionEvent e) {
    drawPanel.setColor(JColorChooser.showDialog(jColorChooser, "Choose Color", drawPanel.getColor()));
    colorButton.setBackground(drawPanel.getColor());

   }
  });

  downBar.add(label);
  //  downBar.add(jColorChooser.getPreviewPanel());
  downBar.add(colorButton);

 }

 public void update(Observable o, Object arg) {

  // Tell the SwingUtilities thread to update the GUI components.
  // This is safer than executing outputField.setText(model.getText()) 
  // in the caller's thread 
  SwingUtilities.invokeLater(new Runnable() {
   public void run() {
    System.out.println("Tried1 to repaint");
    //    outputField.setText(model.getText());
    System.out.println(model.getShapeList().size());
    
//    drawPanel.repaint();
    drawPanel.paintComponent(drawPanel.getGraphics());
    
    System.out.println("Tried2 to repaint");
   }
  });
 }

}
