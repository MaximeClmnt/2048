package save;

import javax.swing.JOptionPane;

public class Main {
	static Boolean d,b,g,h=false;
	static int[][] tab = new int[4][4];
	static int n =0;

	public static void main(String[] args) {
		
		int r=1;
		Object[] Choix = {"Non","Oui"};
		
		while(r==1&&n!=-1){
			n=0;
			Partie();
			if(n!=-1){
				r = JOptionPane.showOptionDialog(null,
						ToString(tab)+"      	                    Recommencer?",
					    "Perdu",
					    JOptionPane.DEFAULT_OPTION,
					    JOptionPane.DEFAULT_OPTION,
					    null,
					    Choix,
					    Choix[0]);
				
			}
			
		}
		
		
		
		
	}
	
	public static void Partie(){
		Object[] Choix = {"Gauche", "Haut", "Bas", "Droite"};
		Rtab(tab);
			tab = NouveauNombre(tab);
				while(n!=-1){
				
				TestMvt(tab);
				
				n = JOptionPane.showOptionDialog(null,
						"\n"+ToString(tab)+"\n"+TestMvtToString(),
				    "2048",
				    JOptionPane.DEFAULT_OPTION,
				    JOptionPane.DEFAULT_OPTION,
				    null,
				    Choix,
				    Choix[0]);
				
				if (n==3&&d){
					tab= MvtDrt(tab);
					tab = NouveauNombre(tab);
				}
				if (n==2&&b){
					tab= MvtBas(tab);
					tab = NouveauNombre(tab);
				}
				if (n==1&&h){
					tab= MvtHaut(tab);
					tab = NouveauNombre(tab);
				}
				if (n==0&&g){
					tab= MvtGch(tab);
					tab = NouveauNombre(tab);
				}
		
		
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
	
	public static String TestMvtToString(){
		String str =" ";
		if(g)
			str=(str +"         O         ");
		else
			str=(str +"         X         ");
		if(h)
			str=(str +"         O         ");
		else
			str=(str +"         X         ");
		if(b)
			str=(str +"         O         ");
		else
			str=(str +"         X         ");
		if(d)
			str=(str +"         O         ");
		else
			str=(str +"         X         ");
		
		return str;
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
	
	public static int[][] InitTab(int tab[][]){
		for(int i = 0; i<4 ; i++){
			for(int j = 0; j<4 ; j++){
				tab[i][j]=0;
			}
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
	
	public static void LireTab(int tab[][]){
		for(int i = 0; i<4 ; i++){
			for(int j = 0; j<4 ; j++){
				System.out.print(tab[i][j]+"  ");
			}
			System.out.println("");
		}
		
	}
	
	public static String ToString(int tab[][]){
		String str = "";
		for(int i=0 ; i<4 ; i++){

			str=str+"              ";
			for(int j=0 ; j<4 ; j++){
				if (tab[i][j]<10)
					str =str + "         "+tab[i][j];
				else if (tab[i][j]<100)
					str =str + "       "+tab[i][j];
				else if (tab[i][j]<1000)
					str =str + "     "+tab[i][j];
			}
			str=str+"\n\n";
		}
		
		return str;
	}
}


