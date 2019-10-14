package psa.naloga3;

public class SkipList {

    private NodeSkipList head, tail;	
    int h=0;
 public SkipList(long maxNodes) {	
	h=(int) Math.ceil(Math.log10(maxNodes) / Math.log10(2));
	head = new NodeSkipList();
	head.key = Integer.MIN_VALUE;
	head.next = new NodeSkipList[(int) Math.ceil(Math.log10(maxNodes) / Math.log10(2))];

	tail = new NodeSkipList();
	tail.key = Integer.MAX_VALUE;
	tail.next = new NodeSkipList[(int) Math.ceil(Math.log10(maxNodes) / Math.log10(2))];

	for (int i = 0 ;  i < h; i++) {	
		head.next[i] = tail;
	}
  }

 public int getHeight() {
		int height=1;
		while(height < h && Math.random() < 0.5) {
			height++;
		}
		return height;
		}

	/*
	 * Metoda sprejme stevilo in ga vstavi v preskocni seznam. Ce element ze
	 * obstaja v podatkovni strukturi, vrne false. Metoda vrne true, ce je bil
	 * element uspesno vstavljen in false sicer.
	 */
 public boolean insert(int searchKey) {
	 NodeSkipList[] pointers = new NodeSkipList[h];
	 NodeSkipList tmp = head; 
	 for (int i = h-1; i >= 0; i--) {
	 	 while(tmp.next[i].key < searchKey){
	 		tmp = tmp.next[i];
	 	}
	 	pointers[i] = tmp;   
	 }
	 tmp=tmp.next[0];
	 if(tmp.key == searchKey)
	 {
		 return false;
	 }else{
		 int visina=getHeight();
		 NodeSkipList elt=new NodeSkipList();
		 elt.next=new NodeSkipList[h];
			 elt.key=searchKey;

		 for (int i = 0; i <visina ; i++) {
			 elt.next[i]=pointers[i].next[i];
			 pointers[i].next[i]=elt;

		 }
		 return true;
	 }
}

	/*
	 * Metoda sprejme stevilo in poisce element v preskocnem seznamu. Metoda
	 * vrne true, ce je bil element uspesno najden v podatkovni strukturi, in
	 * false sicer
	 */
	public boolean search(int searchKey) {
		NodeSkipList tmp = head; 
		for (int i = h-1; i >= 0; i--) {
			while(tmp.next[i].key < searchKey)
			{
				tmp=tmp.next[i];
			}
		}
		if(tmp.next[0].key == searchKey)
			{
				return true;
			}else{	   
				return false;
			}
	}

	/*
	 * Metoda sprejme stevilo in izbrise element iz preskocnega seznama. Metoda
	 * vrne true, ce je bil element uspesno izbrisan iz podatkovne strukture, in
	 * false sicer
	 */
	public boolean delete(int key) {
		 NodeSkipList[] pointers = new NodeSkipList[h];
		 NodeSkipList tmp = head; 
		 for (int i = h-1; i >= 0; i--) {
			 NodeSkipList next=tmp.next[i];
		 	 while(next.key < key){
		 		tmp = next;
		 		next=tmp.next[i];
		 	}
		 	pointers[i] = tmp;   
		 }
		 tmp=tmp.next[0];
		 if(tmp.key == key){
			 for (int i = 0; i <h; i++) {
				 if(pointers[i].next[i]==tmp)
				  {
					 pointers[i].next[i]=tmp.next[i];
				  }
			 }
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	}
}