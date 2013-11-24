import java.util.Arrays;

/**
 * Een deck met Cards
 * 
 * @author Youri Tjang
 *
 */
public class Deck {
    
        private Card[] cardArray;
        private Card[] tempCardArray;
        
        private int cardIndex;
        private String suite;
        private String cardName;
          
        private Card callCard_1;
        private Card callCard_2;
	/**
	 * Constructor
	 */
	Deck(){
		cardArray = new Card[52];
	}

	/**
	 * Vult de array met 52 kaarten: 2,3 ... ,10,V,B,K,A van klaveren, schoppen,
	 * harten en ruiten.
	 */
	public void fillDeck() {
            
            for(int i = 0; i <= 3; i++) // suite
            {
                if(i==0){
                        this.suite = "klaveren";
                    }
                else if(i==1){
                        this.suite = "schoppen";
                    }
                else if(i==2){
                        this.suite = "harten";
                    }
                else if(i==3){
                        this.suite = "ruiten";
                    }
                for(int j = 2; j <= 14; j++) // suit-index
                {
                    if(j<=10){
                        cardName = Integer.toString(j);
                        }
                    else if(j==11){
                            cardName = "boer";
                        }
                    else if(j==12){
                            cardName = "vrouw";
                        }
                    else if(j==13){
                            cardName = "heer";
                        }
                    else // if(j==14)
                    {
                            cardName = "aas";
                    }
                    cardName = this.suite + " " + cardName;
                    this.cardArray[this.cardIndex]=new Card(this.cardName);
                    cardIndex++;
                }
            }
            checkArray();
	}

	/**
	 * Zoals gezegd is dit spel een beetje vreemd. Bijvoorbeeld: spelers kunnen
	 * kaarten toevoegen aan het deck. Hierdoor kan het aantal kaarten groter
	 * worden dan 52.
	 * 
	 * @param card
	 *            een Kaart
	 * @param index
	 *            Op positie
	 */
	public void insertAt(Card card, int index) {
            int j = this.cardArray.length;
            int newj = j+1;
            
            this.tempCardArray = new Card[newj];
            
            //System.out.print(this.tempCardArray.length);
            
            
            for( int i = 0 ; i < newj; i++){
                if(i<index){
                        this.tempCardArray[i] = this.cardArray[i];
                    }
                else if(i == index){
                        this.tempCardArray[i] = card;
                    }
                else {
                        this.tempCardArray[i] = this.cardArray[i-1];
                }
                
                //check
                /*
                    if(i < j){
                        callCard_1 = this.cardArray[i];
                    }
                    callCard_2 = this.tempCardArray[i];
                    
                    if(i < cardArray.length){
                        System.out.print(callCard_1.getName() + ":" + callCard_2.getName() + "\n");
                    }
                    else if(i == cardArray.length)
                    {
                      System.out.print(callCard_2.getName() + "\n");  
                    }
                    * */
            }
            
            resetArray(newj);
            checkArray();
	}

        public void resetArray(int number) {
               // all data in old array, remove temp
            this.cardArray = null;
            this.cardArray = new Card[number];
            this.cardArray = this.tempCardArray;
            this.tempCardArray = null;
        }
        
        public void checkArray() {
               // all data in old array, remove temp
            int imax = this.cardArray.length;
            System.out.print("length: "+imax+"\n");
            for( int i = 0 ; i < imax; i++){
                System.out.print(i + ":"+ this.cardArray[i].getName() + "_;");
            }
            System.out.print("\n");
        }
        
	/**
	 * Kaarten kunnen ook verwijderd worden uit het deck. delete Haalt de kaart
	 * met een bepaalde index er uit.
	 * 
	 * Merk op: na delete is de array zo groot als het aantal elementen dat er in zit.
	 * 
	 * @param index
	 */
	public void delete(int index) {
            
            int j = this.cardArray.length;
            
            this.tempCardArray = new Card[j-1];
            
            //System.out.print(this.tempCardArray.length);
            
            
            for( int i = 0 ; i < j; i++){
                if(i<index){
                        this.tempCardArray[i] = this.cardArray[i];
                    }
                else if(i > index){
                        this.tempCardArray[i-1] = this.cardArray[i];
                }
                else{
                        this.tempCardArray[i] = null;
                }
            }
            
            //reset
            resetArray(j);
            checkArray();
	}

	/**
	 * Schud alle kaarten zodat de volgorde 'willekeurig' is. Hiervoor is het
	 * toegestaan de Java Random generator te gebruiken.
	 * 
	 */
	public void shuffle() {
	}

	/**
	 * Een gegeven kaart moet worden opgezocht in de array, en de index ervan
	 * moet als return worden teruggegeven. Zie [Hubbard p.30]
	 * 
	 * @param card
	 *            de kaart die gezocht wordt
	 * @return De index van de gevonden kaart
	 */
	public int sequentialSearch(Card card) {
            int j = this.cardArray.length;
            String toFind = card.getName();
                System.out.print("\nFinding:..."+card.getName()+"\n");
            int foundIndex = 0;
            
            for( int i = 0 ; i < j; i++){
                
                String current = this.cardArray[i].getName();
                //System.out.print(current+"\n");
                
                if(toFind.equals(current)){
                     foundIndex = i;
                     break;
                }
                else
                {
                    foundIndex = 0;
                }
            }
            return foundIndex;
	}

	/**
	 * Legt de kaarten op volgorde. We nemen aan dat een deck op volgorde ligt,
	 * als de volgorde hetzelfde is als na {@link #fillDeck()}
	 */
	public void sort() {
	}

	/**
	 * Een bepaalde kaart moet worden opgezocht in de gesorteerde array op de
	 * binary search manier zoals besproken in [Hubbart p.31].
	 * 
	 * @param card
	 *            de kaart die gezocht wordt
	 * @return De index van de gevonden kaart
	 */
	public int binarySearch(Card card) {
		return 0;
	}

	
	
	/**
	 *  Pretty-print het deck.
	 */
	@Override
	public String toString() {
		String str = "";
		
		for(int i=0; i<cardArray.length;i++){
			str += cardArray[i];
		}
		return str;
		
	}
}
