package conexao;

import org.apache.commons.dbcp2.BasicDataSource;



public class ConexaoMarise {
    
    private BasicDataSource datasource;

    // Exemplo de configuração utilizando H2
    // Obs. O código comentado é um exemplo de como se conectar ao mysql
    public ConexaoMarise() {
        this.datasource = new BasicDataSource();

//        this.datasource.setDriverClassName("org.h2.Driver");
        this.datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");

//        this.datasource.setUrl("jdbc:h2:file:./meu_banco");
        this.datasource.setUrl("jdbc:mysql://172.17.0.2/16:3306/virtualbrain");

//        this.datasource.setUsername("sa");
        this.datasource.setUsername("root");

//        this.datasource.setPassword("");
        this.datasource.setPassword("urubu100");
    }

    public BasicDataSource getDatasource() {
        return datasource;
    }
    
}
