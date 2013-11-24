/**
 * 
 * @author Youri Tjang
 *
 */
public class App {

	/**
	 * App die onze datastructuur test.
	 */
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.fillDeck();
		//deck.shuffle();
		
                /*
                 try {
                    Thread.sleep(2000);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                */
                
		Card card = new Card("harten aas");
		int testIndex = 30;
		deck.insertAt(card, testIndex);
                
                
                //voer een sequential search uit en toon index
		System.out.print("\nSequential search ...");
                int foundIndex = deck.sequentialSearch(card);
                System.out.println(foundIndex);
		System.out.println((foundIndex == testIndex)?"Win ["+foundIndex+"]":"Fail");
		
                
                //voer een binary search uit, sorteer en toon index
		System.out.print("\nBinary search...");
                //deck.sort();
                //foundIndex = deck.binarySearch(card);
		//System.out.println(foundIndex);

                
                //deck.delete(30);
                
		
	}
}
