import java.util.Arrays;
import java.util.List;

public enum Produtos {

    PLAYSTATION ("Playstation"),
    FOGÃO ("Fogão"),
    GELADEIRA ("Geladeira"),
    IMPRESSORA ("Impressora"),
    NOTEBOOK ("Notebook"),
    CANECA ("Caneca"),
    MESA ("Mesa");

    protected String descricao;

    Produtos(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}