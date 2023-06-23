package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import model.characters.*;
import model.collectibles.Supply;
import model.collectibles.Vaccine;
import model.world.CharacterCell;
import model.world.CollectibleCell;
import model.world.TrapCell;
import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;

public class GUI extends JFrame implements ActionListener{
private JRadioButton r1,r2,r3,r4,r5,r6,r7,r8;
private Hero selectedHero=null;
private JButton startgame;
private ButtonGroup g1;
private ImageIcon i0,pp;
private ImageIcon i1,i2,i3,i4,i5,i6,i7,i8;
private ImageIcon a,b,c,d,ee,f,g,h;
private ImageIcon ib,q,yo;
private JLabel l1,l2,l3,l4,l5,l6,l7,l8;
private JLabel kk;
private JLabel c0,c1,c2,c3,c4,c5;
private JLabel cy;
private ImagePanel p1,p3,p4;
private JPanel p2;
private JButton [][] buttons;
private JButton attack1,cure1,usespecial1,endturn1;
private JLabel Choose;
private JLabel msg,ih,ih2;
private JLabel[] al = new JLabel[6];
private Zombie usedTarget;
private JButton m1,m2,m3,m4,heal1;
private ImageIcon im1,im2,im3,im4;
private JProgressBar health;
private JComboBox heal;

public GUI(){
	yo = new ImageIcon("WhatsApp Image 2023-05-23 at 11.54.40 PM.jpeg");
	Image eee1 = yo.getImage();
	Image eee2 = eee1.getScaledInstance(400,900,Image.SCALE_SMOOTH);
	
	p4 = new ImagePanel(eee2);
	p4.setBounds(1400,50,300,900);
	p4.setBackground(Color.LIGHT_GRAY);
	p4.setVisible(false);
	p4.setLayout(new GridLayout(6, 1));
	
	for(int i=0; i<6; i++){
		al[i]= new JLabel();
		al[i].setForeground(Color.BLACK);
		al[i].setFont(new Font(Font.SERIF, Font.ITALIC|Font.BOLD,18));
		p4.add(al[i]);
	}
	
	this.add(p4);
	
	
	ib = new ImageIcon("a13d1-clickwallpapers-the-last-of-us-img1.jpg");
	Image hhh1 = ib.getImage();
	Image hhh2 = hhh1.getScaledInstance(1460,1040,Image.SCALE_SMOOTH);
	q= new ImageIcon(hhh2);	
	p1=new ImagePanel(q.getImage());
	p1.setBounds(145,5,1460,1040);
	
	Choose = new JLabel("Pick a hero of your choice  ");
	Choose.setBounds(500,-110,900,300);
	Choose.setFont(new Font(Font.SERIF, Font.ITALIC|Font.BOLD,40));
	Choose.setForeground(new Color(255, 255, 255));
	p1.add(Choose);

	l1 = new JLabel("Joel");
	l1.setBounds(110,260,300,40);
	l1.setFont(new Font(Font.SERIF, Font.ITALIC|Font.BOLD,28));
	l1.setForeground(new Color(255,255,255));
	p1.add(l1);
	
	l2 = new JLabel("Ellie");
	l2.setBounds(395,260,300,40);
	l2.setFont(new Font(Font.SERIF, Font.ITALIC|Font.BOLD,28));
	l2.setForeground(new Color(255,255,255));
	p1.add(l2);
	
	l3 = new JLabel("Tess");
	l3.setBounds(995,260,300,40);
	l3.setFont(new Font(Font.SERIF, Font.ITALIC|Font.BOLD,28));
	l3.setForeground(new Color(255,255,255));
	p1.add(l3);
	
	l4 = new JLabel("Riley");
	l4.setBounds(1280,260,300,40);
	l4.setFont(new Font(Font.SERIF, Font.ITALIC|Font.BOLD,28));
	l4.setForeground(new Color(255,255,255));
	p1.add(l4);
	
	l5 = new JLabel("Tommy");
	l5.setBounds(95,530,300,40);
	l5.setFont(new Font(Font.SERIF, Font.ITALIC|Font.BOLD,28));
	l5.setForeground(new Color(255,255,255));
	p1.add(l5);
	
	l6 = new JLabel("Bill");
	l6.setBounds(400,530,300,40);
	l6.setFont(new Font(Font.SERIF, Font.ITALIC|Font.BOLD,28));
	l6.setForeground(new Color(255,255,255));
	p1.add(l6);
	
	l7 = new JLabel("David");
	l7.setBounds(995,530,300,40);
	l7.setFont(new Font(Font.SERIF, Font.ITALIC|Font.BOLD,28));
	l7.setForeground(new Color(255,255,255));
	p1.add(l7);
	
	l8 = new JLabel("Henry");
	l8.setBounds(1280,530,300,40);
	l8.setFont(new Font(Font.SERIF, Font.ITALIC|Font.BOLD,28));
	l8.setForeground(new Color(255,255,255));
	p1.add(l8);
	
	g1 = new ButtonGroup();
	g1.add(r1);
	g1.add(r2);
	g1.add(r3);
	g1.add(r4);
	g1.add(r5);
	g1.add(r6);
	g1.add(r7);
	g1.add(r8);
	
	startgame = new JButton("Start Game");
	startgame.setFont(new Font(Font.SERIF, Font.ITALIC|Font.BOLD,32));
	startgame.setBackground(new Color(255,255,255));
	startgame.addActionListener(this);
	startgame.setBounds(1020,900,300,70);
	p1.add(startgame);
	
	
	i1 = new ImageIcon("sofya-radimirovna-joelartstantionl.jpg");
	Image aa1 = i1.getImage();
	Image aa2 = aa1.getScaledInstance(350,300,Image.SCALE_SMOOTH);
	a = new ImageIcon(aa2);
	i2 = new ImageIcon("Ellie Williams.jpg");
	Image bb1 = i2.getImage();
	Image bb2 = bb1.getScaledInstance(350,300,Image.SCALE_SMOOTH);
	b = new ImageIcon(bb2);
	i3 = new ImageIcon("Tess.jpg");
	Image cc1 = i3.getImage();
	Image cc2 = cc1.getScaledInstance(350,300,Image.SCALE_SMOOTH);
	c = new ImageIcon(cc2);
	i4 = new ImageIcon("Riley.jpg");
	Image dd1 = i4.getImage();
	Image dd2 = dd1.getScaledInstance(350,300,Image.SCALE_SMOOTH);
	d = new ImageIcon(dd2);
	i5 = new ImageIcon("Tommy Miller.jpg");
	Image ee1 = i5.getImage();
	Image ee2 = ee1.getScaledInstance(350,300,Image.SCALE_SMOOTH);
	ee = new ImageIcon(ee2);
	i6 = new ImageIcon("Bill.jpg");
	Image ff1 = i6.getImage();
	Image ff2 = ff1.getScaledInstance(350,300,Image.SCALE_SMOOTH);
	f = new ImageIcon(ff2);
	i7 = new ImageIcon("David.jpg");
	Image gg1 = i7.getImage();
	Image gg2 = gg1.getScaledInstance(350,300,Image.SCALE_SMOOTH);
	g = new ImageIcon(gg2);
	i8 = new ImageIcon("Henry.jpg");
	Image hh1 = i8.getImage();
	Image hh2 = hh1.getScaledInstance(350,300,Image.SCALE_SMOOTH);
	h = new ImageIcon(hh2);
	r1 = new JRadioButton(i1);
	r1.setBackground(Color.BLACK);
	r1.setBounds(15,60,250,200);
	r1.addActionListener(this);
	p1.add(r1);
	
	r2 = new JRadioButton(i2);
	r2.setBackground(Color.BLACK);
	r2.setBounds(295,60,250,200);
	r2.addActionListener(this);
	p1.add(r2);
	
	r3 = new JRadioButton(i3);
	r3.setBackground(Color.BLACK);
	r3.setBounds(900,60,250,200);
	r3.addActionListener(this);
	p1.add(r3);
	
	r4 = new JRadioButton(i4);
	r4.setBackground(Color.BLACK);
	r4.setBounds(1180,60,250,200);
	r4.addActionListener(this);
	p1.add(r4);
	
	r5 = new JRadioButton(i5);
	r5.setBackground(Color.BLACK);
	r5.setBounds(15,320,250,200);
	r5.addActionListener(this);
	p1.add(r5);
	
	r6 = new JRadioButton(i6);
	r6.setBackground(Color.BLACK);
	r6.setBounds(295,320,250,200);
	r6.addActionListener(this);
	p1.add(r6);
	
	r7 = new JRadioButton(i7);
	r7.setBackground(Color.BLACK);
	r7.setBounds(900,320,250,200);
	r7.addActionListener(this);
	p1.add(r7);
	
	r8 = new JRadioButton(i8);
	r8.setBackground(Color.BLACK);
	r8.setBounds(1180,320,250,200);
	r8.addActionListener(this);
	p1.add(r8);
	
	kk = new JLabel();
	kk.setBounds(75,645,350,300);
	p1.add(kk);
	
	cy= new JLabel();
	cy.setBounds(170,520,250,200);
	cy.setFont(new Font(Font.SERIF, Font.BOLD,32));
	cy.setForeground(new Color(255, 255, 255));
	p1.add(cy);
	
	c0= new JLabel();
	c0.setBounds(1050,540,250,200);
	c0.setFont(new Font("Arial", Font.BOLD,25));
	c0.setForeground(new Color(255, 255, 255));
	p1.add(c0);
	
	c1= new JLabel();
	c1.setBounds(1050,580,250,200);
	c1.setFont(new Font("Arial", Font.PLAIN,20));
	c1.setForeground(new Color(255, 255, 255));
	p1.add(c1);
	
	c2= new JLabel();
	c2.setBounds(1050,620,250,200);
	c2.setFont(new Font("Arial", Font.PLAIN,20));
	c2.setForeground(new Color(255, 255, 255));
	p1.add(c2);
	
	c3= new JLabel();
	c3.setBounds(1050,660,250,200);
	c3.setFont(new Font("Arial", Font.PLAIN,20));
	c3.setForeground(new Color(255, 255, 255));
	p1.add(c3);
	
	c4= new JLabel();
	c4.setBounds(1050,700,250,200);
	c4.setFont(new Font("Arial", Font.PLAIN,20));
	c4.setForeground(new Color(255, 255, 255));
	p1.add(c4);
	
	c5= new JLabel();
	c5.setBounds(1050,740,250,200);
	c5.setForeground(new Color(255, 255, 255));
	c5.setFont(new Font("Arial", Font.PLAIN,20));
	p1.add(c5);
	
	p1.setBackground(Color.lightGray);
	//p1.setOpaque(false);
	p1.setLayout(null);
	p1.setVisible(true);
	this.add(p1);
	
	msg = new JLabel();
	msg.setFont(new Font(Font.SERIF,Font.BOLD,26));
	msg.setForeground(new Color(255,255,255));
	msg.setBounds(1020,840,400,70);
	p1.add(msg);
	
	p2=new JPanel();
	p2.setVisible(false);
	p2.setBounds(475,50,900,900);
	p2.setBackground(Color.BLACK);
	p2.setLayout(new GridLayout(15,15));
	this.add(p2);
	
	buttons = new JButton[15][15];
	for (int i = 0; i < buttons.length; i++) {
		for(int j = 0; j < buttons.length; j++){
			buttons[i][j]= new JButton();
			buttons[i][j].addActionListener(this);
			p2.add(buttons[i][j]);
		}
	}
	
	p3=new ImagePanel(eee2);
	p3.setVisible(false);
	p3.setBounds(50,50,400,900);
	p3.setBackground(Color.LIGHT_GRAY);
	p3.setLayout(null);
	this.add(p3);
	
	health = new JProgressBar();
	health.setBounds(20,840,360,40);
	health.setFont(new Font(Font.SERIF, Font.ITALIC|Font.BOLD,28));
	health.setForeground(new Color(195,0,0));
	health.setVisible(false);
	p3.add(health);
	
	attack1= new JButton("Attack");
	attack1.setFont(new Font(Font.SERIF, Font.ITALIC|Font.BOLD,20));
	attack1.setBackground(new Color(32,42,69));
	attack1.setForeground(Color.white);
	attack1.addActionListener(this);
	attack1.setBounds(20,5,175,50);
	p3.add(attack1);
	
	cure1= new JButton("Cure");
	cure1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
	cure1.setBackground(new Color(32,42,69));
	cure1.setForeground(Color.white);
	cure1.addActionListener(this);
	cure1.setBounds(205,5,175,50);
	p3.add(cure1);
	
	usespecial1= new JButton("Use Special");
	usespecial1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
	usespecial1.setBackground(new Color(32,42,69));
	usespecial1.setForeground(Color.white);
	usespecial1.addActionListener(this);
	usespecial1.setBounds(20,65,175,50);
	p3.add(usespecial1);
	
	endturn1= new JButton("End Turn");
	endturn1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
	endturn1.setForeground(Color.white);
	endturn1.setBackground(new Color(32,42,69));
	endturn1.addActionListener(this);
	endturn1.setBounds(205,65,175,50);
	p3.add(endturn1);
	
	try{
		Game.loadHeroes("Heroes.csv");
	}
	catch(IOException event){
		
	}
	
	im1= new ImageIcon("left.jpg");
	im2= new ImageIcon("up.jpg");
	im3= new ImageIcon("right.jpg");
	im4= new ImageIcon("down.jpg");
	
	m1 = new JButton(im2);
	m1.setBounds(150,170,90,90);
	m1.addActionListener(this);
	p3.add(m1);
	
	m2 = new JButton(im1);
	m2.setBounds(50,270,90,90);
	m2.addActionListener(this);
	p3.add(m2);
	
	m3 = new JButton(im3);
	m3.setBounds(250,270,90,90);
	m3.addActionListener(this);
	p3.add(m3);
	
	m4 = new JButton(im4);
	m4.setBounds(150,270,90,90);
	m4.addActionListener(this);
	p3.add(m4);
	
	ih2 = new JLabel();
	ih2.setBounds(75, 380, 250, 200);
	p3.add(ih2);
	
	ih = new JLabel();
	ih.setForeground(Color.BLACK);
	ih.setBounds(30, 420, 390, 600);
	ih.setFont(new Font(Font.SERIF, Font.ITALIC|Font.BOLD,20));
	p3.add(ih);
	
	heal = new JComboBox();
	heal.setBounds(20,125,175,30);
	heal.setVisible(false);
	heal.addActionListener(this);
	p3.add(heal);
	
	heal1 = new JButton("Heal");
	heal1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
	heal1.setBounds(205,125,175,30);
	heal1.setVisible(false);
	heal1.addActionListener(this);
	p3.add(heal1);
	
	this.setLayout(null);
	this.setTitle("The Last Of Us");
	this.setBackground(Color.black);
	this.setSize(1770,1050);
	this.setVisible(true);
	this.getContentPane().setBackground(Color.black);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
}

class ImagePanel extends JPanel {

	  private Image img;

	  public ImagePanel(String img) {
	    this(new ImageIcon(img).getImage());
	  }

	  public ImagePanel(Image img) {
	    this.img = img;
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	  }

	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	  }
}

public void actionPerformed(ActionEvent e) {
	if(e.getSource()== r1){
		kk.setIcon(a);
		selectedHero  = Game.availableHeroes.get(0);
		cy.setText("You chose");
		c0.setText("Hero Description: ");
		c1.setText("Name: Joel Miller");
		c2.setText("Type: Fighter");
		c3.setText("Max Hp: 140");
		c4.setText("Actions Available: 5");
		c5.setText("Attack Damage: 30");
	}
	if(e.getSource()== r2){
		kk.setIcon(b);
		selectedHero  = Game.availableHeroes.get(1);
		c0.setText("Hero Description: ");
		cy.setText("You chose");
		c1.setText("Name: Ellie Williams");
		c2.setText("Type: Medic");
		c3.setText("Max Hp: 110");
		c4.setText("Actions Available: 6");
		c5.setText("Attack Damage: 15");
	}
	if(e.getSource()== r3){
		kk.setIcon(c);
		selectedHero  = Game.availableHeroes.get(2);
		c0.setText("Hero Description: ");
		cy.setText("You chose");
		c1.setText("Name: Tess");
		c2.setText("Type: Explorer");
		c3.setText("Max Hp: 90");
		c4.setText("Actions Available: 6");
		c5.setText("Attack Damage: 20");
	}
	if(e.getSource()== r4){
		kk.setIcon(d);
		selectedHero  = Game.availableHeroes.get(3);
		c0.setText("Hero Description: ");
		cy.setText("You chose");
		c1.setText("Name: Riley Abel");
		c2.setText("Type: Explorer");
		c3.setText("Maxhp: 90");
		c4.setText("Actions Available:  5");
		c5.setText("Attack damage:  25");
	}
	if(e.getSource()== r5){
		kk.setIcon(ee);
		selectedHero  = Game.availableHeroes.get(4);
		c0.setText("Hero Description: ");
		cy.setText("You chose");
		c1.setText("Name: Tommy Miller");
		c2.setText("Type: Explorer");
		c3.setText("Max Hp: 95");
		c4.setText("Actions Available: 5 ");
		c5.setText("Attack Damage: 25");
	}
	if(e.getSource()== r6){
		kk.setIcon(f);
		selectedHero  = Game.availableHeroes.get(5);
		c0.setText("Hero Description: ");
		cy.setText("You chose");
		c1.setText("Name: Bill");
		c2.setText("Type: Medic");
		c3.setText("Max Hp: 100");
		c4.setText("Actions Available: 7");
		c5.setText("Attack Damage: 10");
	}
	if(e.getSource()== r7){
		kk.setIcon(g);
		selectedHero  = Game.availableHeroes.get(6);
		c0.setText("Hero Description: ");
		cy.setText("You chose");
		c1.setText("Name: David");
		c2.setText("Type: Fighter");
		c3.setText("Max Hp: 150");
		c4.setText("Actions Available: 4");
		c5.setText("Attack Damage: 35");
	}
	if(e.getSource()== r8){
		kk.setIcon(h);
		selectedHero  = Game.availableHeroes.get(7);
		c0.setText("Hero Description: ");
		cy.setText("You chose");
		c1.setText("Name: Henry Burell");
		c2.setText("Type: Medic");
		c3.setText("Max Hp: 105");
		c4.setText("Actions Available: 6");
		c5.setText("Attack Damage: 15");
	}
    if(e.getSource() == startgame){
		if(selectedHero==null){
			msg.setText("Please select a hero to start");
		}
		else{
		p1.setVisible(false);
		p3.setVisible(true);
		p2.setVisible(true);
		p4.setVisible(true);
		this.getContentPane().setBackground(Color.BLACK);
		Game.startGame(selectedHero);
		updateMap();
     	}
	}
    for(int i=0;i<15;i++){
		for(int j=0; j<15;j++){
			if(e.getSource() == buttons[14-i][j]){
				if(Game.map[i][j] instanceof CharacterCell && ((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero){
					selectedHero = (Hero)((CharacterCell) Game.map[i][j]).getCharacter();
					showInfoHero(selectedHero);
					leftPanel(i,j);
					health.setVisible(true);
					health.setMinimum(0);
					health.setMaximum(selectedHero.getMaxHp());
					health.setValue(selectedHero.getCurrentHp());
				}
				else if(Game.map[i][j] instanceof CharacterCell && ((CharacterCell) Game.map[i][j]).getCharacter() instanceof Zombie){
					usedTarget=(Zombie)((CharacterCell) Game.map[i][j]).getCharacter(); 
					showInfoZombie(usedTarget);
					leftPanel(i,j);
					health.setVisible(false);
					}
				}	
			}	
		}
    if(e.getSource() == attack1){
    	try{
    	selectedHero.setTarget(usedTarget);
    	selectedHero.attack();
    	updateMap();
    	}
    	catch(NotEnoughActionsException | InvalidTargetException e1){
    		JOptionPane.showMessageDialog(this, e1.getMessage());
    	}
    }
    if(e.getSource() == cure1){
    	try{
    	selectedHero.setTarget(usedTarget);
    	selectedHero.cure();
    	updateMap();
    	}
    	catch(NotEnoughActionsException | InvalidTargetException | NoAvailableResourcesException e1){
    		JOptionPane.showMessageDialog(this, e1.getMessage());
    	}
    }
	if(e.getSource() == heal1){
         for(int i=0; i<Game.heroes.size();i++){
	         if(Game.heroes.get(i).getName().equals(heal.getSelectedItem())){
                 Hero h= Game.heroes.get(i);
                 selectedHero.setTarget(h);
                 try{
             	 selectedHero.useSpecial();
            	 updateMap();
                 }
                 catch(InvalidTargetException | NoAvailableResourcesException e1){
             		JOptionPane.showMessageDialog(this, e1.getMessage());
             	}
        	}
        }
	}
    
    if(e.getSource() == usespecial1){
    	try{
    	if(selectedHero instanceof Medic){
    		getAdj(selectedHero);
    		heal.setVisible(true);
    		heal1.setVisible(true);
    	}
    	 selectedHero.useSpecial();
    	 updateMap();
    	}
    	catch(InvalidTargetException | NoAvailableResourcesException e1){
    		JOptionPane.showMessageDialog(this, e1.getMessage());
    	}
    }
    
    if(e.getSource() == endturn1){
    	try{
    	Game.endTurn();
    	updateMap();
    	}
    	catch(NotEnoughActionsException | InvalidTargetException e1){
    		JOptionPane.showMessageDialog(this, e1.getMessage());
    	}
    }
    if(e.getSource() == m1){
    	try{
    		if(selectedHero.getActionsAvailable()!=0){
    		int x= (int) selectedHero.getLocation().getX();
    		int y= (int) selectedHero.getLocation().getY();
    		if(x!=14 && Game.map[x+1][y] instanceof TrapCell){
    			JOptionPane.showMessageDialog(this,"You have entered a Trap Cell");
    		}
    		}
        	selectedHero.move(Direction.UP);
        	updateMap();
        	}
        	catch(NotEnoughActionsException | MovementException e1){
        		JOptionPane.showMessageDialog(this, e1.getMessage());
        	}
    }
    if(e.getSource() == m2){
    	try{
    		if(selectedHero.getActionsAvailable()!=0){
    		int x= (int) selectedHero.getLocation().getX();
    		int y= (int) selectedHero.getLocation().getY();
    		if(y!=0 && Game.map[x][y-1] instanceof TrapCell){
    			JOptionPane.showMessageDialog(this,"You have entered a Trap Cell");
    		}
    		}
        	selectedHero.move(Direction.LEFT);
        	updateMap();
        	}
        	catch(NotEnoughActionsException | MovementException e1){
        		JOptionPane.showMessageDialog(this, e1.getMessage());
        	}
    }
    if(e.getSource() == m3){
    	try{
    		if(selectedHero.getActionsAvailable()!=0){
    		int x= (int) selectedHero.getLocation().getX();
    		int y= (int) selectedHero.getLocation().getY();
    		if(y!=14 && Game.map[x][y+1] instanceof TrapCell){
    			JOptionPane.showMessageDialog(this,"You have entered a Trap Cell");
    		}
    		}
        	selectedHero.move(Direction.RIGHT);
        	updateMap();
        	}
        	catch(NotEnoughActionsException | MovementException e1){
        		JOptionPane.showMessageDialog(this, e1.getMessage());
        	}
    }
    if(e.getSource() == m4){
    	try{
    		if(selectedHero.getActionsAvailable()!=0){
    		int x= (int) selectedHero.getLocation().getX();
    		int y= (int) selectedHero.getLocation().getY();
    		if(x!=0 && Game.map[x-1][y] instanceof TrapCell){
    			JOptionPane.showMessageDialog(this,"You have entered a Trap Cell");
    		}
    		}
        	selectedHero.move(Direction.DOWN);
        	updateMap();
        	}
        	catch(NotEnoughActionsException | MovementException e1){
        		JOptionPane.showMessageDialog(this, e1.getMessage());
        	}
    }	
}

public void showInfoHero(Hero h){
	String type="";
	if(h instanceof Fighter){
		type = "Fighter";
	}
	else if(h instanceof Medic){
		type  = "Medic";
	}
	else{
		type = "Explorer";
	}
	String s ="<html> <p> Type: " + type + "</p>" + "<p>Name: " + h.getName() + "</p>" + "<p>Max Health: " + h.getMaxHp() + "</p>" + "<p>Health: " + h.getCurrentHp() +
			"</p>" + "<p>AttackDamage: " + h.getAttackDmg() + "</p>" + "<p>Maximum Actions: " + h.getMaxActions() + "</p>" + "<p>Actions Available: " + h.getActionsAvailable() + "</p>" +
			"<p>Vaccines: " + h.getVaccineInventory().size() + "</p>" + "<p>Supplies: " + h.getSupplyInventory().size() + "</p></html>";
	ih.setText(s);
}

public String showInfoHero2(Hero h){
	String type="";
	if(h instanceof Fighter){
		type = "Fighter";
	}
	else if(h instanceof Medic){
		type  = "Medic";
	}
	else{
		type = "Explorer";
	}
	String s ="<html> <p> Type: " + type + "</p>" + "<p>Name: " + h.getName() + "</p>" + "<p>Health: " + h.getCurrentHp() +
			"</p>" + "<p>AttackDamage: " + h.getAttackDmg() + "</p>" + "<p>Maximum Actions: " + h.getMaxActions() + "</p>" + "<p>Actions Available: " + h.getActionsAvailable()  + "</p></html>";
	return s;
}
public void showInfoZombie(Zombie z){
	String s ="<html> <p> Type: Zombie" + "</p>" + "<p>Name: " + z.getName() + "</p>" + "<p>Max Health: " + z.getMaxHp()
			 + "</p>" + "<p>Health: " + z.getCurrentHp() + "</p>" + "<p>AttackDamage: " + z.getAttackDmg()+ "</p></html>";
	ih.setText(s);
}

public void updateMap(){
	heal.setVisible(false);
	heal.removeAllItems();
	heal1.setVisible(false);
	for(int i=0;i<15;i++){
		for(int j=0; j<15;j++){
			if(Game.map[i][j].isVisible()==true){
			if(Game.map[i][j]  instanceof CharacterCell){
				if(((CharacterCell) Game.map[i][j]).getCharacter()==null){
					buttons[14-i][j].setIcon(new ImageIcon("dark.jpg"));
				}
				else if(((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero){
					buttons[14-i][j].setIcon(anhyHero(i,j));
				}
				else{
					buttons[14-i][j].setIcon(new ImageIcon("zombie.jpg"));
				}
			}
			if(Game.map[i][j]  instanceof CollectibleCell){
				if( ((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Vaccine){
					buttons[14-i][j].setIcon(new ImageIcon("vaccine.jpg"));
			}
				if( ((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Supply){
					buttons[14-i][j].setIcon(new ImageIcon("supply.jpg"));
			}
			}	
		}
			else{
				buttons[14-i][j].setIcon(new ImageIcon("light.jpg"));
			}
	}
	}	
	int z = 0;
	for(int k=0; k<Game.heroes.size();k++){
		Hero h = Game.heroes.get(k);
		showInfoHero2(h);
		al[z].setText(showInfoHero2(h));
		z++;
	}
	if(Game.checkWin()){
		JOptionPane.showMessageDialog(this, "You Win!");
		this.dispose();
	}
	else if(Game.checkGameOver()){
		JOptionPane.showMessageDialog(this, "You lose, Try again");
		this.dispose();
	}
}

public ImageIcon anhyHero(int i,int j){
	if(((CharacterCell) Game.map[i][j]).getCharacter().getName().equals("Joel Miller")){
		i0= new ImageIcon("sofya-radimirovna-joelartstantionl.jpg");
	}
	if(((CharacterCell) Game.map[i][j]).getCharacter().getName().equals("Ellie Williams")){
		i0= new ImageIcon("Ellie Williams.jpg");
	}
	if(((CharacterCell) Game.map[i][j]).getCharacter().getName().equals("Tess")){
		i0= new ImageIcon("Tess.jpg");
	}
	if(((CharacterCell) Game.map[i][j]).getCharacter().getName().equals("Riley Abel")){
		i0= new ImageIcon("Riley.jpg");
	}
	if(((CharacterCell) Game.map[i][j]).getCharacter().getName().equals("Tommy Miller")){
		i0= new ImageIcon("Tommy Miller.jpg");
	}
	if(((CharacterCell) Game.map[i][j]).getCharacter().getName().equals("Bill")){
		i0= new ImageIcon("Bill.jpg");
	}
	if(((CharacterCell) Game.map[i][j]).getCharacter().getName().equals("David")){
		i0= new ImageIcon("David.jpg");
	}
	if(((CharacterCell) Game.map[i][j]).getCharacter().getName().equals("Henry Burell")){
		i0= new ImageIcon("Henry.jpg");
	}
	Image bbb1 = i0.getImage();
	Image bbb2 = bbb1.getScaledInstance(60,60,Image.SCALE_SMOOTH);
	pp = new ImageIcon(bbb2);
	return pp;
}
public void leftPanel(int i,int j){
	if(((CharacterCell) Game.map[i][j]).getCharacter().getName().equals("Joel Miller")){
		i0= new ImageIcon("sofya-radimirovna-joelartstantionl.jpg");
	}
	if(((CharacterCell) Game.map[i][j]).getCharacter().getName().equals("Ellie Williams")){
		i0= new ImageIcon("Ellie Williams.jpg");
	}
	if(((CharacterCell) Game.map[i][j]).getCharacter().getName().equals("Tess")){
		i0= new ImageIcon("Tess.jpg");
	}
	if(((CharacterCell) Game.map[i][j]).getCharacter().getName().equals("Riley Abel")){
		i0= new ImageIcon("Riley.jpg");
	}
	if(((CharacterCell) Game.map[i][j]).getCharacter().getName().equals("Tommy Miller")){
		i0= new ImageIcon("Tommy Miller.jpg");
	}
	if(((CharacterCell) Game.map[i][j]).getCharacter().getName().equals("Bill")){
		i0= new ImageIcon("Bill.jpg");
	}
	if(((CharacterCell) Game.map[i][j]).getCharacter().getName().equals("David")){
		i0= new ImageIcon("David.jpg");
	}
	if(((CharacterCell) Game.map[i][j]).getCharacter().getName().equals("Henry Burell")){
		i0= new ImageIcon("Henry.jpg");
	}
	if(((CharacterCell) Game.map[i][j]).getCharacter() instanceof Zombie){
		i0= new ImageIcon("zombie.jpg");
	}
	Image bbb1 = i0.getImage();
	Image bbb2 = bbb1.getScaledInstance(250,200,Image.SCALE_SMOOTH);
	pp = new ImageIcon(bbb2);
	ih2.setIcon(pp);
}

public void getAdj(Hero h){
	int x= (int)h.getLocation().getX();
	int y= (int)h.getLocation().getY();
	int a=x-1;
	int b=x+2;
	int c=y-1;
	int d=y+2;
	if(x==0){
	 a=0;
	 b=2;
	}
	if(x==14){
	 a=13;
	 b=15;
	}
	if(y==0){
	 c=0;
	 d=2;
	}
	if(y==14){
	 c=13;
	 d=15;
	}
	for(int i=a;i<b;i++){	
		for(int j=c;j<d;j++){
			if(Game.map[i][j] instanceof CharacterCell && ((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero){
				heal.addItem((String)((CharacterCell) Game.map[i][j]).getCharacter().getName());	
			}
		}
	}
}


public static void main(String[] args) {
	GUI g = new GUI();
}

}
