package atividade03;

public class SondagemDuplaHash extends HashBase {

    @Override
    protected int hash(int value, int i) {
        var h1 = value % this.m;
        var h2 = 1 + (value % (this.m - 1));

        return (h1 + i * h2) % this.m;
    }
}
