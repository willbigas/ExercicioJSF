package beans;

import dao.PessoaDao;
import dto.PessoasPorProfissaoDTO;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@ManagedBean
public class DashboardBean implements Serializable {

    private PessoaDao pessoaDao;
    private List<PessoasPorProfissaoDTO> pessoasPorProfissaoDTOS;
    private PieChartModel pessoasPorProfissaoModel;

    private final List<String> cores = Arrays.asList(
      "#5D55FF","#51E8D1","#B8FF66","#E8B851","#FF6459"
    );

    @PostConstruct
    public void init() {
        pessoaDao = new PessoaDao();
        pessoasPorProfissaoDTOS = new ArrayList<>();
        pessoasPorProfissaoDTOS = pessoaDao.buscaPessoasPorProfissao();
        inicializaGraficoPessoasPorProfissao();
    }

    private void inicializaGraficoPessoasPorProfissao() {
        pessoasPorProfissaoModel = new PieChartModel();
        List<Number> valores = new ArrayList<>();
        List<String> rotulos = new ArrayList<>();

        for (PessoasPorProfissaoDTO dto : pessoasPorProfissaoDTOS) {
            rotulos.add(dto.getProfissao());
            valores.add(dto.getQuantidadePessoas());
        }

        PieChartDataSet dataSet = new PieChartDataSet();
        dataSet.setData(valores);
        dataSet.setBackgroundColor(cores);

        ChartData dados = new ChartData();

        dados.addChartDataSet(dataSet);
        dados.setLabels(rotulos);
        pessoasPorProfissaoModel.setData(dados);

    }

    public List<PessoasPorProfissaoDTO> getPessoasPorProfissaoDTOS() {
        return pessoasPorProfissaoDTOS;
    }

    public void setPessoasPorProfissaoDTOS(List<PessoasPorProfissaoDTO> pessoasPorProfissaoDTOS) {
        this.pessoasPorProfissaoDTOS = pessoasPorProfissaoDTOS;
    }

    public PieChartModel getPessoasPorProfissaoModel() {
        return pessoasPorProfissaoModel;
    }

    public void setPessoasPorProfissaoModel(PieChartModel pessoasPorProfissaoModel) {
        this.pessoasPorProfissaoModel = pessoasPorProfissaoModel;
    }
}
