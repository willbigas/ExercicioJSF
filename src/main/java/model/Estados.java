package model;

public enum Estados {

    PARANA("Paraná"),
    SANTA_CATARINA("Santa Catarina"),
    RIO_GRANDE_DO_SUL("Rio Grande do Sul");

    private String descricao;

    Estados(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
