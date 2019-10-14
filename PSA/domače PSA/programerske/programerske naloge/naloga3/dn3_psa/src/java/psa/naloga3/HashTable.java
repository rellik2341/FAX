package psa.naloga3;

/*
 * Razred mora imeplementirati podatkovno strukturo Razprsilne tabele (HashTable).
 * Za funkcijo uporabite: h(x) = x * 701 mod 2000
 * V primeru kolizij uporabite VERIZENJE in sicer kot Slovar uporabite podatkovno 
 * strukturo Razprsilne tabele, ki ga morate implementirati (razred HashTable2). 
 * Pazite, ker je lahko ključ tudi negativno število
 */
public class HashTable {

	int p = 701;
	int m = 2000;
	HashTable2 data[] = new HashTable2[m];

	private int h(int x) {
		return Math.abs((x * p) % m);	
	}


	public boolean insert(int key) {
		int index = h(key);
		if (data[index] == null)
			data[index] = new HashTable2();
	return data[index].insert(key);
	}
	

	/*
	 * Metoda sprejme število in ga poišče v tabeli. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean search(int key) {
		int index = h(key);
		
		for(int i=0;i<data[0].data.length;i++)
		{
			if(data[index].data[i]==key)
			{
				return true;
			}
			
		}
		return false;			
	}

	/*
	 * Metoda sprejme število in ga izbriše iz tabele. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean delete(int key) {
		int index = h(key);
		
		for(int j=0;j<data[0].data.length;j++)
		{
			if(data[index].data[j]==key)
			{
				data[index].data[j]=0;
				return true;
			}
			
		}
	
		return false;
	}
}
