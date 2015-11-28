/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class Navire{
	private int x;
	private int y;
	private int drapeau;
	private boolean detruit;
	
	public Navire(int x, int y, int drapeau){
		this.x = Math.max(0, Math.min(Piraterie.MAX_X, x));
		this.y = Math.max(0, Math.min(Piraterie.MAX_Y, y));
		this.drapeau = drapeau;
		this.detruit = false;
	}
	
	public int getX(){return x;}
	public int getY(){return y;}
	public int getDrapeau(){return drapeau;}
	public boolean estDetruit(){return detruit;}
	
	public double distance(Navire n2){
		return Math.sqrt((x-n2.getX())*(x-n2.getX())+(y-n2.getY())*(y-n2.getY()));
	}
	
	public void avance(int unitsX, int unitsY){
		x += unitsX;
		y += unitsY;
		x = Math.max(0, Math.min(Piraterie.MAX_X, x));
		y = Math.max(0, Math.min(Piraterie.MAX_Y, y));
	}
	
	public void couler(){
		detruit = true;
	}
	
	public String getNom(){
		return "Bateau";
	}
	
	public String toString(){
		return getNom() + " avec drapeau " + drapeau + " en (<" + x + ">,<" + y + ">) - > ";
	}
	
	
}

class Pirate extends Navire {
	private boolean endommage;
	
	public Pirate(int x, int y, int drapeau, boolean endommage){
		super(x,y,drapeau);
		this.endommage = endommage;
	}
	
	public String getNom(){
		return super.getNom() + " pirate";
	}
	
	public boolean estEndommage(){return endommage;}
	
	public String toString(){
		if(estDetruit()){
			return super.toString() + "detruit";
		} else {
			if(estEndommage()){
				return super.toString() + "ayant subi des dommages";
			} else {
				return super.toString() + "intact";
			}
		}
	}
}

class Marchand extends Navire {
	
	public Marchand(int x, int y, int drapeau){
		super(x,y,drapeau);
	}
	
	public String getNom(){
		return super.getNom() + " marchand";
	}
	
	public String toString(){
		if(estDetruit()){
			return super.toString() + "detruit";
		} else {
			return super.toString() + "intact";
		}
	}
	
	
}


/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/
class Piraterie {

    static public final int MAX_X = 500;
    static public final int MAX_Y = 500;
    static public final double RAYON_RENCONTRE = 10;

    static public void main(String[] args) {
        // Test de la partie 1
        System.out.println("***Test de la partie 1***");
        System.out.println();
        // un bateau pirate 0,0 avec le drapeau 1 et avec dommages
        Navire ship1 = new Pirate(0, 0, 1, true);
        // un bateau marchand en 25,0 avec le drapeau 2
        Navire ship2 = new Marchand(25, 0, 2);
        System.out.println(ship1);
        System.out.println(ship2);
        System.out.println("Distance: " + ship1.distance(ship2));
        System.out.println("Quelques déplacements horizontaux et verticaux");
        // se deplace de 75 unites a droite et 100 en haut
        ship1.avance(75, 100);
        System.out.println(ship1);
        System.out.println(ship2);
        System.out.println("Un déplacement en bas:");
        ship1.avance(0, -5);
        System.out.println(ship1);
        ship1.coule();
        ship2.coule();
        System.out.println("Après destruction:");
        System.out.println(ship1);
        System.out.println(ship2);

        // Test de la partie 2
        System.out.println();
        System.out.println("***Test de la partie 2***");
        System.out.println();

        // deux vaisseaux sont enemis s'ils ont des drapeaux differents

        System.out.println("Bateau pirate et marchand ennemis (trop loin):");
        // bateau pirate intact
        ship1 = new Pirate(0, 0, 1, false);
        ship2 = new Marchand(0, 25, 2);
        System.out.println(ship1);
        System.out.println(ship2);
        ship1.rencontre(ship2);
        System.out.println("Après la rencontre:");
        System.out.println(ship1);
        System.out.println(ship2);
        System.out.println();

        System.out.println("Bateau pirate et marchand ennemis (proches):");
        // bateau pirate intact
        ship1 = new Pirate(0, 0, 1, false);
        ship2 = new Marchand(2, 0, 2);
        System.out.println(ship1);
        System.out.println(ship2);
        ship1.rencontre(ship2);
        System.out.println("Après la rencontre:");
        System.out.println(ship1);
        System.out.println(ship2);
        System.out.println();

        System.out.println("Bateau pirate et marchand amis (proches):");
        // bateau pirate intact
        ship1 = new Pirate(0, 0, 1, false);
        ship2 = new Marchand(2, 0, 1);
        System.out.println(ship1);
        System.out.println(ship2);
        ship1.rencontre(ship2);
        System.out.println("Après la rencontre:");
        System.out.println(ship1);
        System.out.println(ship2);
        System.out.println();

        System.out.println("Deux bateaux pirates ennemis intacts (proches):");
        // bateaux pirates intacts
        ship1 = new Pirate(0, 0, 1, false);
        ship2 = new Pirate(2, 0, 2, false);
        System.out.println(ship1);
        System.out.println(ship2);
        ship1.rencontre(ship2);
        System.out.println("Après la rencontre:");
        System.out.println(ship1);
        System.out.println(ship2);
        System.out.println();

        System.out.println("Un bateau pirate intact et un avec dommages, ennemis:");
        // bateau pirate intact
        Navire ship3 = new Pirate(0, 2, 3, false);
        System.out.println(ship1);
        System.out.println(ship3);
        ship3.rencontre(ship1);
        System.out.println("Après la rencontre:");
        System.out.println(ship1);
        System.out.println(ship3);
        System.out.println();

        System.out.println("Deux bateaux pirates ennemis avec dommages:");
        System.out.println(ship2);
        System.out.println(ship3);
        ship3.rencontre(ship2);
        System.out.println("Après la rencontre:");
        System.out.println(ship2);
        System.out.println(ship3);
        System.out.println();
    }
}
