package psa.naloga3;

public class NodeSkipList {
	
	int key;
	int height;
	NodeSkipList[] next;

	public NodeSkipList(int skey, int sheight) {
		key = skey;
		height = sheight;
	}

	public NodeSkipList() {
	}


}