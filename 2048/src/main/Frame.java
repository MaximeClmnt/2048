package main;


import java.awt.Dimension;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Frame extends JFrame{
	static Boolean d,b,g,h=false;
	static int[][] tab = new int[4][4];
	static Panel panel = new Panel();
	static KeyListener kListener = new keyListener();
	
	public Frame(){

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(500, 500);
		this.setTitle("2048");
		this.setMinimumSize(new Dimension(250,250));
		this.setContentPane(panel);
		this.addKeyListener(kListener);
		this.setResizable(false);
		this.repaint();
		Trame();
	}
	
	public void Trame(){
		Rtab(tab);
		tab = NouveauNombre(tab);
		tab = NouveauNombre(tab);
		while (true){
				
				TestMvt(tab);
				keyListener.n=10;
				while(keyListener.n==10)
				{
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				if (keyListener.n==3&&d){
					tab= MvtDrt(tab);
					tab = NouveauNombre(tab);
				}
				if (keyListener.n==2&&b){
					tab= MvtBas(tab);
					tab = NouveauNombre(tab);
				}
				if (keyListener.n==1&&h){
					tab= MvtHaut(tab);
					tab = NouveauNombre(tab);
				}
				if (keyListener.n==0&&g){
					tab= MvtGch(tab);
					tab = NouveauNombre(tab);
				}
				this.repaint();
			
		}
		
	}
	
	public static int[][] Rtab(int tab[][]){
		for(int i=0; i<4;i++){
			for(int j=0; j<4;j++){
				tab[i][j]=0;
			}
		}
		
		return tab;
	}
	
	public static void TestMvt(int tab[][]){
		d=b=g=h=false;
		for(int i=0; i<4 ; i++){
			for (int j = 0 ; j<3 ; j++){
				//Test Droit
				if(	tab[i][j]!=0	&&	(	(tab[i][j+1]==0)	||	(tab[i][j+1]==tab[i][j])	)	)
					d=true;
				//Test Bas
				if(	tab[j][i]!=0	&&	(	(tab[j+1][i]==0)	||	(tab[j+1][i]==tab[j][i])	)	)
					b=true;
				//Test Gauche
				if(	tab[i][j+1]!=0	&&	(	(tab[i][j]==0)	||	(tab[i][j]==tab[i][j+1])	)	)
					g=true;
				//Test Haut
				if(	tab[j+1][i]!=0	&&	(	(tab[j][i]==0)	||	(tab[j][i]==tab[j+1][i])	)	)
					h=true;
			}
		}
	}
	
	public static int[][] NouveauNombre(int tab[][]){
		int x,y;
		Boolean t = false;
		for(int i=0 ; i<4 ; i++){
			for(int j=0 ; j<4 ; j++){
				if (tab[i][j]==0)
					t=true;
				
			}
		}
		
		if(t){
			do{
				x=(int) (4*Math.random());
				y=(int) (4*Math.random());
			}while(tab[x][y]!=0);
			tab[x][y]=2;
		}
		return tab;
	}

	public static int[][] MvtDrt(int tab[][]){
		for(int i = 0; i<4 ; i++){
			//Deplacer
			if (tab[i][3]==0){
				tab[i][3]=tab[i][2];
				tab[i][2]=0;
			}
			if (tab[i][2]==0){
				tab[i][2]=tab[i][1];
				tab[i][1]=0;
			}
			if (tab[i][3]==0){
				tab[i][3]=tab[i][2];
				tab[i][2]=0;
			}
			if (tab[i][1]==0){
				tab[i][1]=tab[i][0];
				tab[i][0]=0;
			}
			if (tab[i][2]==0){
				tab[i][2]=tab[i][1];
				tab[i][1]=0;
			}
			if (tab[i][3]==0){
				tab[i][3]=tab[i][2];
				tab[i][2]=0;
			}
			
			//fusionner
			if (tab[i][3]==tab[i][2]){
				tab[i][3]=tab[i][3]*2;
				tab[i][2]=0;
			}
			if (tab[i][2]==tab[i][1]){
				tab[i][2]=tab[i][2]*2;
				tab[i][1]=0;
			}if (tab[i][1]==tab[i][0]){
				tab[i][1]=tab[i][1]*2;
				tab[i][0]=0;
			}
			
			//Déplacer
			if (tab[i][3]==0){
				tab[i][3]=tab[i][2];
				tab[i][2]=0;
			}
			if (tab[i][2]==0){
				tab[i][2]=tab[i][1];
				tab[i][1]=0;
			}
			if (tab[i][3]==0){
				tab[i][3]=tab[i][2];
				tab[i][2]=0;
			}
			if (tab[i][1]==0){
				tab[i][1]=tab[i][0];
				tab[i][0]=0;
			}
			if (tab[i][2]==0){
				tab[i][2]=tab[i][1];
				tab[i][1]=0;
			}
			if (tab[i][3]==0){
				tab[i][3]=tab[i][2];
				tab[i][2]=0;
			}
				
			}
		
		return tab;
	}
	
	public static int[][] MvtBas(int tab[][]){
		for(int j = 0; j<4 ; j++){
			//Deplacer
			if (tab[3][j]==0){
				tab[3][j]=tab[2][j];
				tab[2][j]=0;
			}
			if (tab[2][j]==0){
				tab[2][j]=tab[1][j];
				tab[1][j]=0;
			}
			if (tab[3][j]==0){
				tab[3][j]=tab[2][j];
				tab[2][j]=0;
			}
			if (tab[1][j]==0){
				tab[1][j]=tab[0][j];
				tab[0][j]=0;
			}
			if (tab[2][j]==0){
				tab[2][j]=tab[1][j];
				tab[1][j]=0;
			}
			if (tab[3][j]==0){
				tab[3][j]=tab[2][j];
				tab[2][j]=0;
			}
			
			//fusionner
			if (tab[3][j]==tab[2][j]){
				tab[3][j]=tab[3][j]*2;
				tab[2][j]=0;
			}
			if (tab[2][j]==tab[1][j]){
				tab[2][j]=tab[2][j]*2;
				tab[1][j]=0;
			}if (tab[1][j]==tab[0][j]){
				tab[1][j]=tab[1][j]*2;
				tab[0][j]=0;
			}

			//Deplacer
			if (tab[3][j]==0){
				tab[3][j]=tab[2][j];
				tab[2][j]=0;
			}
			if (tab[2][j]==0){
				tab[2][j]=tab[1][j];
				tab[1][j]=0;
			}
			if (tab[3][j]==0){
				tab[3][j]=tab[2][j];
				tab[2][j]=0;
			}
			if (tab[1][j]==0){
				tab[1][j]=tab[0][j];
				tab[0][j]=0;
			}
			if (tab[2][j]==0){
				tab[2][j]=tab[1][j];
				tab[1][j]=0;
			}
			if (tab[3][j]==0){
				tab[3][j]=tab[2][j];
				tab[2][j]=0;
			}
				
			}
		
		return tab;
	}
	
	public static int[][] MvtGch(int tab[][]){for(int i = 0; i<4 ; i++){
		//Deplacer
		if (tab[i][0]==0){
			tab[i][0]=tab[i][1];
			tab[i][1]=0;
		}
		if (tab[i][1]==0){
			tab[i][1]=tab[i][2];
			tab[i][2]=0;
		}
		if (tab[i][0]==0){
			tab[i][0]=tab[i][1];
			tab[i][1]=0;
		}
		if (tab[i][2]==0){
			tab[i][2]=tab[i][3];
			tab[i][3]=0;
		}
		if (tab[i][1]==0){
			tab[i][1]=tab[i][2];
			tab[i][2]=0;
		}
		if (tab[i][0]==0){
			tab[i][0]=tab[i][1];
			tab[i][1]=0;
		}
		
		//fusionner
		if (tab[i][0]==tab[i][1]){
			tab[i][0]=tab[i][0]*2;
			tab[i][1]=0;
		}
		if (tab[i][1]==tab[i][2]){
			tab[i][1]=tab[i][1]*2;
			tab[i][2]=0;
		}if (tab[i][2]==tab[i][3]){
			tab[i][2]=tab[i][2]*2;
			tab[i][3]=0;
		}
		
		//Deplacer
		if (tab[i][0]==0){
			tab[i][0]=tab[i][1];
			tab[i][1]=0;
		}
		if (tab[i][1]==0){
			tab[i][1]=tab[i][2];
			tab[i][2]=0;
		}
		if (tab[i][0]==0){
			tab[i][0]=tab[i][1];
			tab[i][1]=0;
		}
		if (tab[i][2]==0){
			tab[i][2]=tab[i][3];
			tab[i][3]=0;
		}
		if (tab[i][1]==0){
			tab[i][1]=tab[i][2];
			tab[i][2]=0;
		}
		if (tab[i][0]==0){
			tab[i][0]=tab[i][1];
			tab[i][1]=0;
		}
	
	}
	return tab;
		
		
		
		
	}
	
	public static int[][] MvtHaut(int tab[][]){
		for(int j = 0; j<4 ; j++){
			//Deplacer
			if (tab[0][j]==0){
				tab[0][j]=tab[1][j];
				tab[1][j]=0;
			}
			if (tab[1][j]==0){
				tab[1][j]=tab[2][j];
				tab[2][j]=0;
			}
			if (tab[0][j]==0){
				tab[0][j]=tab[1][j];
				tab[1][j]=0;
			}
			if (tab[2][j]==0){
				tab[2][j]=tab[3][j];
				tab[3][j]=0;
			}
			if (tab[1][j]==0){
				tab[1][j]=tab[2][j];
				tab[2][j]=0;
			}
			if (tab[0][j]==0){
				tab[0][j]=tab[1][j];
				tab[1][j]=0;
			}
			
			//fusionner
			if (tab[0][j]==tab[1][j]){
				tab[0][j]=tab[0][j]*2;
				tab[1][j]=0;
			}
			if (tab[1][j]==tab[2][j]){
				tab[1][j]=tab[1][j]*2;
				tab[2][j]=0;
			}
			if (tab[2][j]==tab[3][j]){
				tab[2][j]=tab[2][j]*2;
				tab[3][j]=0;
			}

			//Deplacer
			if (tab[0][j]==0){
				tab[0][j]=tab[1][j];
				tab[1][j]=0;
			}
			if (tab[1][j]==0){
				tab[1][j]=tab[2][j];
				tab[2][j]=0;
			}
			if (tab[0][j]==0){
				tab[0][j]=tab[1][j];
				tab[1][j]=0;
			}
			if (tab[2][j]==0){
				tab[2][j]=tab[3][j];
				tab[3][j]=0;
			}
			if (tab[1][j]==0){
				tab[1][j]=tab[2][j];
				tab[2][j]=0;
			}
			if (tab[0][j]==0){
				tab[0][j]=tab[1][j];
				tab[1][j]=0;
			}
				
			}
		
		return tab;
	}
}
