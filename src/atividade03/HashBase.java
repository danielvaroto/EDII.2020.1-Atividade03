package atividade03;

public abstract class HashBase {

    protected Integer[] hashItems;
    protected int totalCollisions, m;

    protected abstract int hash(int value, int i);

    public void create(int m) {
        this.hashItems = new Integer[m];
        this.m = m;
        this.totalCollisions = 0;
    }

    public void insert(int data) {
        var currentCollisions = 0;

        var inserted = false;

        do {
            var hashedKey = this.hash(data, currentCollisions);

            if (this.hashItems[hashedKey] == null) {
                this.hashItems[hashedKey] = data;
                inserted = true;
            } else {
                currentCollisions++;
                this.totalCollisions++;
            }

        } while (inserted == false);
    }

    public Integer lookup(int data) throws Exception {
        for (var currentCollisions = 0; currentCollisions < this.m; currentCollisions++) {
            var hashedKey = this.hash(data, currentCollisions);
            
            if (this.hashItems[hashedKey] == data)
                return this.hashItems[hashedKey];
        }
        
        throw new Exception("Não foi possível encontrar o dado especificado.");
    }

    public int destroy() {
        this.hashItems = null;

        return this.totalCollisions;
    }
}
