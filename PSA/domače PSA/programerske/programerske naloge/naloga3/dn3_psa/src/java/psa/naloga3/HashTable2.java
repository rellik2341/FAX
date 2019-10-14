package psa.naloga3;

/*
 * Razred mora imeplementirati podatkovno strukturo Razprsilne tabele.
 * Za funkcijo uporabite: h(x) = x * 53 mod 100
 * V primeru kolizij uporabite LINEARNO NASLAVLJANJE.
 */
public class HashTable2 {

	int p = 53;
	int m = 100;
	int[] data = new int[m];

	private int h(int x) {
		return Math.abs((x * p) % m);
	}

	

	/*
	 * Metoda sprejme število in ga vstavi v tabelo. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean insert(int key) {
		int index = h(key);
		for (int i = 0; i < data.length; i++) {
			if (data[index] == 0) {
				data[index] = key;
				return true;
			}
		}
		return false;
	}

	/*
	 * Metoda sprejme število in ga poišče v tabeli. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean search(int key) {
		int index = h(key);
		for (int i = 0; i < data.length; i++) {
			if (data[index] == key) {
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
		for (int i = 0; i < data.length; i++) {
			if (data[index] == key) {
				data[index] = 0;
				return true;
			}
		}
		return false;
	}
}
