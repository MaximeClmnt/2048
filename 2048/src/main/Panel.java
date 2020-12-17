package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel extends JPanel{
	
	public void paintComponent(Graphics g){
		g.setColor(new Color(251,248,239));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		int e = this.getHeight()/5;
		int p=(Math.min(this.getHeight()-e, this.getWidth()))-40;
		int c= (p-(p/7))/4;
		g.setColor( new Color(119,110,101));
		g.setFont(new Font("Trebuchet MS", Font.BOLD, p/4));
		g.drawString("2048", (this.getWidth()-p)/2, this.getHeight()/6);
		g.drawImage(new ImageIcon("Images/plateau.gif").getImage(), (this.getWidth()-p)/2, 
				(this.getHeight()-p)/2+(e/2), p, p, this);
		g.setColor(new Color(0,0,0));
		for(int i = 0; i<4;i++){
			for(int j = 0 ; j<4;j++){
				g.drawImage(new ImageIcon("Images/"+Frame.tab[j][i]+".gif").getImage()
				, ((this.getWidth()-p)/2)+(p/27)+(i*(c+(p/38)))-(p/400)
				, ((this.getHeight()-p)/2)+(p/35)+(j*(c+(p/36)))-(p/400)+(e/2)
				, c+(p/100), c+p/100, this);
			}
		}
		
	}

}
