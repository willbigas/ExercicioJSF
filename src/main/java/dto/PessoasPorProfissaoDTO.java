package dto;

public class PessoasPorProfissaoDTO {

    private String profissao;
    private Long quantidadePessoas;

    public PessoasPorProfissaoDTO(String profissao, Long quantidadePessoas) {
        this.profissao = profissao;
        this.quantidadePessoas = quantidadePessoas;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Long getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(Long quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }
}
