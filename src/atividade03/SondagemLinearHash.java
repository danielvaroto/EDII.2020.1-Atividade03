package atividade03;

public class SondagemLinearHash extends HashBase {

    @Override
    protected int hash(int value, int i) {
        return (value + i) % this.m;
    }
}
