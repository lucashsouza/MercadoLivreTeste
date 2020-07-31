import java.util.Arrays;
import java.util.List;

public enum Produtos {

    PLAYSTATION ("playstation"),
    FOGAO ("fogão"),
    GELADEIRA ("geladeira"),
    IMPRESSORA ("impressora"),
    NOTEBOOK ("notebook"),
    CANECA ("caneca"),
    MESA ("mesa");

    protected String descricao;

    Produtos(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}