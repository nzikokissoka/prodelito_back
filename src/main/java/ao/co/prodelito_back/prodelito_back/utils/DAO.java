package ao.co.prodelito_back.prodelito_back.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import ao.co.prodelito_back.prodelito_back.model.SistemaModuloCaminho;

public class DAO {

    //variaveis de conexão à bd
	String databaseURL = "jdbc:sqlserver://localhost:1433;instance=MSSQLSERVER;databaseName=dbprodel;encrypt=false;";
    String user        = "sa";
    String password    = "admin2k4";

    //--- para CONFIGURALITO -----------------------------------------------
    public Integer func001_update_menu(SistemaModuloCaminho smc) {

        Integer resultado = null;

        //verifica nulidade de smc
        if(smc != null){

            String query_update_menu = "UPDATE tb_menus "+
                                       "SET abreviada = ? , caminho_ficheiro_xhtml = ?, descricao = ?, icone = ?";
            
            try {
                
                Connection connection               = DriverManager.getConnection(databaseURL, user, password);
                PreparedStatement preparedStatement = connection.prepareStatement(query_update_menu);

                preparedStatement.setString(1, smc.getAbreviada());
                preparedStatement.setString(2, smc.getCaminhoFicheiroXhtml());
                preparedStatement.setString(3, smc.getDescricao());
                preparedStatement.setString(4, smc.getIcone());

                int resultSet = preparedStatement.executeUpdate();
        		
                resultado = resultSet;

                preparedStatement.close();
                connection.close();

            } catch (Exception e) {
                System.out.println("--- ERRO NA DAO func001_update_menu = "+e.getMessage());
            }

        }
        
        return resultado;

    }



    public Integer func002_delete_smc(SistemaModuloCaminho smc) {

        Integer resultado = null;

        //verifica nulidade de smc
        if(smc != null){

            String query_delete_menu = "DELETE FROM tb_sistemas_modulos_caminhos WHERE codigo LIKE ?";           
            
            try {
                
                Connection connection               = DriverManager.getConnection(databaseURL, user, password);
                PreparedStatement preparedStatement = connection.prepareStatement(query_delete_menu);

                preparedStatement.setString(1, smc.getCodigo()+"%");                

                int resultSet = preparedStatement.executeUpdate();
        		
                resultado = resultSet;

                preparedStatement.close();
                connection.close();

            } catch (Exception e) {
                System.out.println("--- ERRO NA DAO func001_update_menu = "+e.getMessage());
            }

        }
        
        return resultado;

    }
    //--- FIM para CONFIGURALITO -------------------------------------------


    //--- para BOLSAHORAS --------------------------------------------------
    //--- FIM para BOLSAHORAS ----------------------------------------------
    
}
