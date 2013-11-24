/**
 * 
 * @author Youri Tjang
 *
 */
public class Card {
	
        Card card;
        
        private String cardName;
        
        public Card(String cardName){
            //System.out.print("");
            this.cardName = cardName;
            System.out.print(this.cardName+"\n");
        }
        
        public String getName(){
            return this.cardName;
        }
	/**
	 * Pretty-print deze Card als string
	 */
	public String toString(){
		return "";
	}

}
