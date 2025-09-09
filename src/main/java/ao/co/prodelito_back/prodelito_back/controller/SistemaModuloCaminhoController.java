package ao.co.prodelito_back.prodelito_back.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ao.co.prodelito_back.prodelito_back.model.Menu;
import ao.co.prodelito_back.prodelito_back.model.SistemaModuloCaminho;
import ao.co.prodelito_back.prodelito_back.repository.GrupoPrivilegioRepository;
import ao.co.prodelito_back.prodelito_back.repository.MenuRepository;
import ao.co.prodelito_back.prodelito_back.repository.SistemaModuloCaminhoRepository;
import ao.co.prodelito_back.prodelito_back.utils.DAO;


@RestController
//@CrossOrigin(origins = "*")
public class SistemaModuloCaminhoController {

    //injecção de dependencias
    @Autowired private SistemaModuloCaminhoRepository sistemaModuloCaminhoRepository;
    @Autowired private GrupoPrivilegioRepository grupoPrivilegioRepository;
    @Autowired private MenuRepository menuRepository;

    //funções auxiliares
    public String func101_gera_novo_codigo(String codigo) {

        //variaveis
        String resultado = null;
        String max_codigo = null;

        //verifica nulidade de codigo
        if(codigo.equals(null)){

            //pega codigo maximo
            max_codigo = sistemaModuloCaminhoRepository.func203FindOne_MaxCodigo_PorLenCodigo(3);

            //verifica max_codigo
            if(max_codigo.equals(null)){
                resultado = StringUtils.leftPad("1", 3, "0");
            } else {
                Integer novo_max_codigo = (Integer.parseInt(max_codigo)+1);
                resultado = func102_gera_string_novo_max_codigo(novo_max_codigo);
            }

        } else {

            //pega o tamanho do codigo
            int lenCodigo = codigo.length();
            
            //verifica nulidade de lenCodigo
            if(lenCodigo != 0){ // lenCodigo so deve ser 3, 6, 9, 12, 15, 18 e 21

                switch (lenCodigo) {
                    
                    // modulos nível 1 - 1
                    case 6:
                        
                        //separa a parte len 3
                        String codigoPaiLen3 = codigo.substring(0, 3);

                        //pega num_lenCodigo6_codigoPai3
                        Integer num_lenCodigo6_codigoPai3 = sistemaModuloCaminhoRepository.func104CountAll_PorLenCodigo_e_CodigoPai(6, codigoPaiLen3);

                        //verifica num_lenCodigo6_codigoPai3
                        if(num_lenCodigo6_codigoPai3.equals(null)){
                            resultado = codigoPaiLen3 + "001";
                        } else {
                            Integer novo_max_codigo = Integer.parseInt(codigo.substring(3, 6)+1);
                            resultado = codigoPaiLen3 + func102_gera_string_novo_max_codigo(novo_max_codigo);
                        }                       
                        
                        break;
                    
                    
                    // modulos nível 2 - 1.1
                    case 9:
                        
                        //separa a parte len 6
                        String codigoPaiLen6 = codigo.substring(0, 6);

                        //pega num_lenCodigo6_codigoPai6
                        Integer num_lenCodigo9_codigoPai6 = sistemaModuloCaminhoRepository.func104CountAll_PorLenCodigo_e_CodigoPai(9, codigoPaiLen6);

                        //verifica num_lenCodigo6_codigoPai3
                        if(num_lenCodigo9_codigoPai6.equals(null)){
                            resultado = codigoPaiLen6 + "001";
                        } else {
                            Integer novo_max_codigo = Integer.parseInt(codigo.substring(6, 9)+1);
                            resultado = codigoPaiLen6 + func102_gera_string_novo_max_codigo(novo_max_codigo);
                        }

                        break;

                    
                    // modulos nível 3 - 1.1.1
                    case 12:
                        
                        //separa a parte len 9
                        String codigoPaiLen9 = codigo.substring(0, 9);

                        //pega num_lenCodigo12_codigoPai9
                        Integer num_lenCodigo12_codigoPai9 = sistemaModuloCaminhoRepository.func104CountAll_PorLenCodigo_e_CodigoPai(12, codigoPaiLen9);

                        //verifica num_lenCodigo12_codigoPai9
                        if(num_lenCodigo12_codigoPai9.equals(null)){
                            resultado = codigoPaiLen9 + "001";
                        } else {
                            Integer novo_max_codigo = Integer.parseInt(codigo.substring(9, 12)+1);
                            resultado = codigoPaiLen9 + func102_gera_string_novo_max_codigo(novo_max_codigo);
                        }
                        
                        break;

                    
                    
                    // modulos nível 4 - 1.1.1.1
                    case 15:

                        //separa a parte len 15
                        String codigoPaiLen12 = codigo.substring(0, 12);

                        //pega num_lenCodigo15_codigoPai12
                        Integer num_lenCodigo15_codigoPai12 = sistemaModuloCaminhoRepository.func104CountAll_PorLenCodigo_e_CodigoPai(15, codigoPaiLen12);
                        
                        //verifica num_lenCodigo12_codigoPai9
                        if(num_lenCodigo15_codigoPai12.equals(null)){
                            resultado = codigoPaiLen12 + "001";
                        } else {
                            Integer novo_max_codigo = Integer.parseInt(codigo.substring(12, 15)+1);
                            resultado = codigoPaiLen12 + func102_gera_string_novo_max_codigo(novo_max_codigo);
                        }

                        break;

                    
                    
                    // modulos nível 5 - 1.1.1.1.1
                    case 18:
                        
                        //separa a parte len 15
                        String codigoPaiLen15 = codigo.substring(0, 15);

                        //pega num_lenCodigo18_codigoPai15
                        Integer num_lenCodigo18_codigoPai12 = sistemaModuloCaminhoRepository.func104CountAll_PorLenCodigo_e_CodigoPai(18, codigoPaiLen15);

                        //verifica num_lenCodigo18_codigoPai12
                        if(num_lenCodigo18_codigoPai12.equals(null)){
                            resultado = codigoPaiLen15 + "001";
                        } else {
                            Integer novo_max_codigo = Integer.parseInt(codigo.substring(15, 18)+1);
                            resultado = codigoPaiLen15 + func102_gera_string_novo_max_codigo(novo_max_codigo);
                        }
                        
                        break;

                    
                    

                    // modulos nível 6 - 1.1.1.1.1.1
                    case 21:

                        //separa a parte len 18
                        String codigoPaiLen18 = codigo.substring(0, 18);

                        //pega num_lenCodigo21_codigoPai18
                        Integer num_lenCodigo21_codigoPai18 = sistemaModuloCaminhoRepository.func104CountAll_PorLenCodigo_e_CodigoPai(21, codigoPaiLen18);
                        
                        //verifica num_lenCodigo21_codigoPai18
                        if(num_lenCodigo21_codigoPai18.equals(null)){
                            resultado = codigoPaiLen18 + "001";
                        } else {
                            Integer novo_max_codigo = Integer.parseInt(codigo.substring(18, 21)+1);
                            resultado = codigoPaiLen18 + func102_gera_string_novo_max_codigo(novo_max_codigo);
                        }

                        break;
                
                }

            }

        }

        return resultado;

    }


    public String func102_gera_string_novo_max_codigo(Integer novo_max_codigo) {
        return StringUtils.leftPad(Integer.toString(novo_max_codigo), 3, "0");
    }


    public String func103_gera_novo_codigo_por_codigoPai(String codigo) {
        System.err.println("codigo = "+codigo);
        //variaveis
        String resultado = null;
        String max_codigo = null;

        //verifica nulidade de codigo
        if(codigo == null){

            //pega codigo maximo
            max_codigo = sistemaModuloCaminhoRepository.func203FindOne_MaxCodigo_PorLenCodigo(3);

            //verifica max_codigo
            if(max_codigo == null){
                resultado = StringUtils.leftPad("1", 3, "0");
            } else {
                Integer novo_max_codigo = (Integer.parseInt(max_codigo)+1);
                resultado = func102_gera_string_novo_max_codigo(novo_max_codigo);
            }

        } else {

            //pega o tamanho do codigo
            int lenCodigo = codigo.length();
            
            //verifica nulidade de lenCodigo
            if(lenCodigo != 0){ // lenCodigo so deve ser 3, 6, 9, 12, 15, 18 e 21
            
                switch (lenCodigo) {

                    // modulos nível 1 - 1
                    //para codigo len 6
                    case 3:
                        
                        //separa a parte len 3
                        String codigoPaiLen3 = codigo;

                        //pega num_lenCodigo6_codigoPai3
                        Integer num_lenCodigo6_codigoPai3 = sistemaModuloCaminhoRepository.func108CountAll_PorCodigoPai(codigoPaiLen3);

                        //verifica num_lenCodigo6_codigoPai3
                        if(num_lenCodigo6_codigoPai3 == 0){
                            resultado = codigoPaiLen3 + "001"; 
                        } else {
                            String max_codigo_db = sistemaModuloCaminhoRepository.func205FindOne_MaxCodigo_PorLenCodigo_E_CodigoPai(6, codigoPaiLen3);
                            Integer novo_max_codigo = Integer.parseInt(max_codigo_db.substring(3, 6))+1;
                            resultado = codigoPaiLen3 + func102_gera_string_novo_max_codigo(novo_max_codigo);
                        }                       
                        
                        break;

                    
                    // modulos nível 2 - 1.1
                    //para codigo len 9
                    case 6:

                        //separa a parte codigo pai de len 6
                        String codigoPaiLen6 = codigo;

                        //pega num_lenCodigo9_codigoPai6
                        Integer num_lenCodigo9_codigoPai6 = sistemaModuloCaminhoRepository.func108CountAll_PorCodigoPai(codigoPaiLen6);

                        //verifica num_lenCodigo9_codigoPai6
                        if(num_lenCodigo9_codigoPai6 == 0){
                            resultado = codigoPaiLen6 + "001";
                        } else {
                            
                            String max_codigo_db = sistemaModuloCaminhoRepository.func205FindOne_MaxCodigo_PorLenCodigo_E_CodigoPai(9, codigoPaiLen6);
                            Integer novo_max_codigo = Integer.parseInt(max_codigo_db.substring(6, 9))+1;
                            resultado = codigoPaiLen6 + func102_gera_string_novo_max_codigo(novo_max_codigo);
                        }

                        break;

                    
                    
                    // modulos nível 3 - 1.1.1
                    //para codigo len 12
                    case 9:

                        //separa a parte codigo pai de len 9
                        String codigoPaiLen9 = codigo;

                        //pega num_lenCodigo12_codigoPai9
                        Integer num_lenCodigo12_codigoPai9 = sistemaModuloCaminhoRepository.func108CountAll_PorCodigoPai(codigoPaiLen9);

                        //verifica num_lenCodigo12_codigoPai9
                        if(num_lenCodigo12_codigoPai9 == 0){
                            resultado = codigoPaiLen9 + "001";
                        } else {
                            
                            String max_codigo_db = sistemaModuloCaminhoRepository.func205FindOne_MaxCodigo_PorLenCodigo_E_CodigoPai(12, codigoPaiLen9);
                            Integer novo_max_codigo = Integer.parseInt(max_codigo_db.substring(9, 12))+1;
                            resultado = codigoPaiLen9 + func102_gera_string_novo_max_codigo(novo_max_codigo);
                            
                        }

                        break;



                    // modulos nível 4 - 1.1.1.1
                    //para codigo len 15
                    case 12:

                        //separa a parte codigo pai de len 12
                        String codigoPaiLen12 = codigo;

                        //pega num_lenCodigo15_codigoPai12
                        Integer num_lenCodigo15_codigoPai12 = sistemaModuloCaminhoRepository.func108CountAll_PorCodigoPai(codigoPaiLen12);

                        //verifica num_lenCodigo15_codigoPai12
                        if(num_lenCodigo15_codigoPai12 == 0){
                            resultado = codigoPaiLen12 + "001";
                        } else {
                            
                            String max_codigo_db = sistemaModuloCaminhoRepository.func205FindOne_MaxCodigo_PorLenCodigo_E_CodigoPai(15, codigoPaiLen12);
                            Integer novo_max_codigo = Integer.parseInt(max_codigo_db.substring(12, 15))+1;
                            resultado = codigoPaiLen12 + func102_gera_string_novo_max_codigo(novo_max_codigo);

                        }

                        break;


                    
                    // modulos nível 5 - 1.1.1.1.1
                    //para codigo len 18
                    case 15:

                        //separa a parte codigo pai de len 15
                        String codigoPaiLen15 = codigo;

                        //pega num_lenCodigo18_codigoPai15
                        Integer num_lenCodigo18_codigoPai15 = sistemaModuloCaminhoRepository.func108CountAll_PorCodigoPai(codigoPaiLen15);

                        //verifica num_lenCodigo18_codigoPai15
                        if(num_lenCodigo18_codigoPai15 == 0){
                            resultado = codigoPaiLen15 + "001";
                        } else {
                            
                            String max_codigo_db = sistemaModuloCaminhoRepository.func205FindOne_MaxCodigo_PorLenCodigo_E_CodigoPai(18, codigoPaiLen15);
                            Integer novo_max_codigo = Integer.parseInt(max_codigo_db.substring(15, 18))+1;
                            resultado = codigoPaiLen15 + func102_gera_string_novo_max_codigo(novo_max_codigo);

                        }

                        break;



                    // modulos nível 6 - 1.1.1.1.1.1
                    //para codigo len 21
                    case 18:

                        //separa a parte codigo pai de len 18
                        String codigoPaiLen18 = codigo;

                        //pega num_lenCodigo21_codigoPai18
                        Integer num_lenCodigo21_codigoPai18 = sistemaModuloCaminhoRepository.func108CountAll_PorCodigoPai(codigoPaiLen18);

                        //verifica num_lenCodigo21_codigoPai18
                        if(num_lenCodigo21_codigoPai18 == 0){
                            resultado = codigoPaiLen18 + "001";
                        } else {
                            
                            String max_codigo_db = sistemaModuloCaminhoRepository.func205FindOne_MaxCodigo_PorLenCodigo_E_CodigoPai(21, codigoPaiLen18);
                            Integer novo_max_codigo = Integer.parseInt(max_codigo_db.substring(18, 21))+1;
                            resultado = codigoPaiLen18 + func102_gera_string_novo_max_codigo(novo_max_codigo);

                        }

                        break;


                }

            }

        }

        return resultado;

    }


    public String func104_pegar_parte_titulo(SistemaModuloCaminho sistemaModuloCaminho) {

        //variavel
        String resultado = null;

        //verificar nulidade de sistemaModuloCaminho
        if(sistemaModuloCaminho != null){

            int codigo = sistemaModuloCaminho.getCodigo().length();

            //verificar tamanho de codigo proveniente de sistemaModuloCaminho
            if(codigo == 6){

                String codigo3 = sistemaModuloCaminho.getCodigo().substring(0, 3);
                String descricao3 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo3).getDescricao().trim();
                resultado = descricao3;

            } else if(codigo == 9){

                String codigo3 = sistemaModuloCaminho.getCodigo().substring(0, 3);
                String codigo6 = sistemaModuloCaminho.getCodigo().substring(0, 6);
                String descricao3 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo3).getDescricao().trim();                
                String descricao6 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo6).getDescricao().trim();

                resultado = descricao3+" > "+descricao6;

            } else if(codigo == 12){

                String codigo3 = sistemaModuloCaminho.getCodigo().substring(0, 3);
                String codigo6 = sistemaModuloCaminho.getCodigo().substring(0, 6);
                String codigo9 = sistemaModuloCaminho.getCodigo().substring(0, 9);
                String descricao3 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo3).getDescricao().trim();                
                String descricao6 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo6).getDescricao().trim();                
                String descricao9 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo9).getDescricao().trim();

                resultado = descricao3+" > "+descricao6+" > "+descricao9;

            } else if(codigo == 15){

                String codigo3 = sistemaModuloCaminho.getCodigo().substring(0, 3);
                String codigo6 = sistemaModuloCaminho.getCodigo().substring(0, 6);
                String codigo9 = sistemaModuloCaminho.getCodigo().substring(0, 9);
                String codigo12 = sistemaModuloCaminho.getCodigo().substring(0, 12);
                String descricao3 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo3).getDescricao().trim();                
                String descricao6 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo6).getDescricao().trim();                
                String descricao9 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo9).getDescricao().trim();
                String descricao12 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo12).getDescricao().trim();

                resultado = descricao3+" > "+descricao6+" > "+descricao9+" > "+descricao12;

            } else if(codigo == 18){

                String codigo3 = sistemaModuloCaminho.getCodigo().substring(0, 3);
                String codigo6 = sistemaModuloCaminho.getCodigo().substring(0, 6);
                String codigo9 = sistemaModuloCaminho.getCodigo().substring(0, 9);
                String codigo12 = sistemaModuloCaminho.getCodigo().substring(0, 12);
                String codigo15 = sistemaModuloCaminho.getCodigo().substring(0, 15);
                String descricao3 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo3).getDescricao().trim();                
                String descricao6 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo6).getDescricao().trim();                
                String descricao9 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo9).getDescricao().trim();
                String descricao12 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo12).getDescricao().trim();
                String descricao15 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo15).getDescricao().trim();

                resultado = descricao3+" > "+descricao6+" > "+descricao9+" > "+descricao12+" > "+descricao15;

            } else if(codigo == 21){

                String codigo3 = sistemaModuloCaminho.getCodigo().substring(0, 3);
                String codigo6 = sistemaModuloCaminho.getCodigo().substring(0, 6);
                String codigo9 = sistemaModuloCaminho.getCodigo().substring(0, 9);
                String codigo12 = sistemaModuloCaminho.getCodigo().substring(0, 12);
                String codigo15 = sistemaModuloCaminho.getCodigo().substring(0, 15);
                String codigo18 = sistemaModuloCaminho.getCodigo().substring(0, 18);
                String descricao3 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo3).getDescricao().trim();                
                String descricao6 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo6).getDescricao().trim();                
                String descricao9 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo9).getDescricao().trim();
                String descricao12 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo12).getDescricao().trim();
                String descricao15 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo15).getDescricao().trim();
                String descricao18 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo18).getDescricao().trim();

                resultado = descricao3+" > "+descricao6+" > "+descricao9+" > "+descricao12+" > "+descricao15+" > "+descricao18;

            }

        }

        return resultado;

    }


    public String func104_pegar_parte_titulo2(String codigo) {

        //variaveis
        String resultado = null;
        int lenCodigo    = codigo.trim().length();

        //verificar tamanho de codigo proveniente de sistemaModuloCaminho        
        if(lenCodigo == 6){

            String codigo3 = codigo.substring(0, 3);
            String descricao3 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo3).getDescricao().trim();
            resultado = descricao3;

        } else if(lenCodigo == 9){

            String codigo3 = codigo.substring(0, 3); System.out.println("codigo3 = "+codigo3);
            String codigo6 = codigo.substring(0, 6); System.out.println("codigo6 = "+codigo6);
            String descricao3 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo3).getDescricao().trim();                
            String descricao6 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo6).getDescricao().trim();

            resultado = descricao3+" > "+descricao6;

        } else if(lenCodigo == 12){

            String codigo3 = codigo.substring(0, 3);
            String codigo6 = codigo.substring(0, 6);
            String codigo9 = codigo.substring(0, 9);
            String descricao3 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo3).getDescricao().trim();                
            String descricao6 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo6).getDescricao().trim();                
            String descricao9 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo9).getDescricao().trim();

            resultado = descricao3+" > "+descricao6+" > "+descricao9;

        } else if(lenCodigo == 15){

            String codigo3 = codigo.substring(0, 3);
            String codigo6 = codigo.substring(0, 6);
            String codigo9 = codigo.substring(0, 9);
            String codigo12 = codigo.substring(0, 12);
            String descricao3 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo3).getDescricao().trim();                
            String descricao6 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo6).getDescricao().trim();                
            String descricao9 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo9).getDescricao().trim();
            String descricao12 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo12).getDescricao().trim();

            resultado = descricao3+" > "+descricao6+" > "+descricao9+" > "+descricao12;

        } else if(lenCodigo == 18){

            String codigo3 = codigo.substring(0, 3);
            String codigo6 = codigo.substring(0, 6);
            String codigo9 = codigo.substring(0, 9);
            String codigo12 = codigo.substring(0, 12);
            String codigo15 = codigo.substring(0, 15);
            String descricao3 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo3).getDescricao().trim();                
            String descricao6 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo6).getDescricao().trim();                
            String descricao9 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo9).getDescricao().trim();
            String descricao12 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo12).getDescricao().trim();
            String descricao15 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo15).getDescricao().trim();

            resultado = descricao3+" > "+descricao6+" > "+descricao9+" > "+descricao12+" > "+descricao15;

        } else if(lenCodigo == 21){

            String codigo3 = codigo.substring(0, 3);
            String codigo6 = codigo.substring(0, 6);
            String codigo9 = codigo.substring(0, 9);
            String codigo12 = codigo.substring(0, 12);
            String codigo15 = codigo.substring(0, 15);
            String codigo18 = codigo.substring(0, 18);
            String descricao3 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo3).getDescricao().trim();                
            String descricao6 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo6).getDescricao().trim();                
            String descricao9 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo9).getDescricao().trim();
            String descricao12 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo12).getDescricao().trim();
            String descricao15 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo15).getDescricao().trim();
            String descricao18 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo18).getDescricao().trim();

            resultado = descricao3+" > "+descricao6+" > "+descricao9+" > "+descricao12+" > "+descricao15+" > "+descricao18;

        }

        return resultado;

    }


    public String func105_pegar_parte_titulo(String codigoPai) {

        //variaveis
        String resultado = null;
        int lenCodigoPai = codigoPai.trim().length();

        //verificar tamanho de codigo proveniente de sistemaModuloCaminho 
        if(lenCodigoPai == 3){// lenCodigo = 6

            String sistema = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigoPai).getDescricao().trim();
            resultado = sistema;

        } else if(lenCodigoPai == 6){// lenCodigo = 9
            System.out.println("codigoPai = "+codigoPai);
            String codSistema = codigoPai.substring(0, 3); System.out.println("codSistema = "+codSistema);
            String sistema = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codSistema).getDescricao().trim();
            String modNivel1 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigoPai).getDescricao().trim();
            resultado = sistema+" > "+modNivel1;

        } else if(lenCodigoPai == 9){// lenCodigo = 12

            String codSistema = codigoPai.substring(0, 3);
            String codNivel1 = codigoPai.substring(0, 6);
            String sistema = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codSistema).getDescricao().trim();
            String modNivel1 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codNivel1).getDescricao().trim();
            String modNivel2 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigoPai).getDescricao().trim();

            resultado = sistema+" > "+modNivel1+" > "+modNivel2;

        } else if(lenCodigoPai == 12){// lenCodigo = 15

            String codSistema = codigoPai.substring(0, 3);
            String codNivel1 = codigoPai.substring(0, 6);
            String codNivel2 = codigoPai.substring(0, 9);
            String sistema = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codSistema).getDescricao().trim();
            String modNivel1 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codNivel1).getDescricao().trim();
            String modNivel2 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codNivel2).getDescricao().trim();
            String modNivel3 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigoPai).getDescricao().trim();

            resultado = sistema+" > "+modNivel1+" > "+modNivel2+" > "+modNivel3;
;

        } else if(lenCodigoPai == 15){// lenCodigo = 18

            String codSistema = codigoPai.substring(0, 3);
            String codNivel1 = codigoPai.substring(0, 6);
            String codNivel2 = codigoPai.substring(0, 9);
            String codNivel3 = codigoPai.substring(0, 12);
            String sistema = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codSistema).getDescricao().trim();
            String modNivel1 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codNivel1).getDescricao().trim();
            String modNivel2 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codNivel2).getDescricao().trim();
            String modNivel3 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codNivel3).getDescricao().trim();
            String modNivel4 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigoPai).getDescricao().trim();

            resultado = sistema+" > "+modNivel1+" > "+modNivel2+" > "+modNivel3+" > "+modNivel4;

        } else if(lenCodigoPai == 18){ // lenCodigo = 21

            String codSistema = codigoPai.substring(0, 3);
            String codNivel1 = codigoPai.substring(0, 6);
            String codNivel2 = codigoPai.substring(0, 9);
            String codNivel3 = codigoPai.substring(0, 12);
            String codNivel4 = codigoPai.substring(0, 15);
            String sistema = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codSistema).getDescricao().trim();
            String modNivel1 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codNivel1).getDescricao().trim();
            String modNivel2 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codNivel2).getDescricao().trim();
            String modNivel3 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codNivel3).getDescricao().trim();
            String modNivel4 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codNivel4).getDescricao().trim();
            String modNivel5 = sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigoPai).getDescricao().trim();

            resultado = sistema+" > "+modNivel1+" > "+modNivel2+" > "+modNivel3+" > "+modNivel4+" > "+modNivel5;

        } 

        return resultado;

    }

    
    
    
    
    
    //funções rest

    //contagem     
    //conta quantos registros com mesma descrição
    @GetMapping("/sistemaModuloCaminho/conta_todos_registos")
    public Integer conta_registros(){
        return sistemaModuloCaminhoRepository.func101CountAll();
    }

    @GetMapping("/sistemaModuloCaminho/conta_todos_registos_por_codigo/{codigo}")
    public Integer conta_registos_por_codigo(@PathVariable String codigo){
        return sistemaModuloCaminhoRepository.func105CountAll_PorCodigo(codigo);
    }

    @GetMapping("/sistemaModuloCaminho/conta_todos_registos_por_descricao/{descricao}")
    public Integer conta_registos_por_descricao(@PathVariable String descricao){
        return sistemaModuloCaminhoRepository.func106CountAll_PorDescricao(descricao);
    }

    @GetMapping("/sistemaModuloCaminho/pega_parte_titulo/{sistemaModuloCaminho}")
    public String pega_parte_titulo(@PathVariable SistemaModuloCaminho sistemaModuloCaminho){
        return func104_pegar_parte_titulo(sistemaModuloCaminho);
    }


    @GetMapping("/sistemaModuloCaminho/conta_uso_smc_em_menu/{id}")
    public Integer conta_registos_smc_em_menus(@PathVariable Integer id){
        return menuRepository.func103CountAll_PorSistemaModuloCaminhoId(id);
    }

    @GetMapping("/sistemaModuloCaminho/conta_uso_smc_em_grupo_privilegio/{id}")
    public Integer conta_registos_smc_em_grupo_privilegio(@PathVariable Integer id){
        return grupoPrivilegioRepository.func103CountAll_PorSistemaModuloCaminhoId(id);
    }

    @GetMapping("/sistemaModuloCaminho/pega_registo_sistema_modulo_caminho/{id}")
    public SistemaModuloCaminho pega_sistema_modulo_caminho(@PathVariable Integer id){
        return sistemaModuloCaminhoRepository.func201FindOne_PorId(id);
    }

    @GetMapping("/sistemaModuloCaminho/pega_objecto_registo_sistema_modulo_caminho/{codigo}")
    public SistemaModuloCaminho pega_objecto_sistema_modulo_caminho(@PathVariable String codigo){
        return sistemaModuloCaminhoRepository.func202FindOne_PorCodigo(codigo);
    }

    /*@GetMapping("/sistemaModuloCaminho/pega_parte_titulo_string/{codigoPai}")
    public String pega_parte_titulo_string(@PathVariable String codigoPai){
        return func105_pegar_parte_titulo(codigoPai);
    }*/




    //listagens
    @GetMapping("/sistemaModuloCaminho")
    public Iterable<SistemaModuloCaminho> listarTodos(){
        return sistemaModuloCaminhoRepository.func301FindAll();
    }

    @GetMapping("/sistemaModuloCaminho/por_null_codigopai_e_lenCodigopai")
    public Iterable<SistemaModuloCaminho> listarTodos_PorNull_codigoPai_lenCodigoPai(){
        return sistemaModuloCaminhoRepository.func301FindAll();
    }

    /*@GetMapping("/sistemaModuloCaminho/ordenar_por_id_desc")
    public Iterable<SistemaModuloCaminho> listarTodos_Ordenar_por_id_desc(){
        return sistemaModuloCaminhoRepository.func304FindAll_PorIdDesc();
    }*/

    @GetMapping("/sistemaModuloCaminho/ordenar_por_id_desc/{lenCodigo}/{codigoPai}")
    public Iterable<SistemaModuloCaminho> listarTodos_Ordenar_por_id_desc(
        @PathVariable Integer lenCodigo,
        @PathVariable String codigoPai){
        return sistemaModuloCaminhoRepository.func305FindAll_PorLenCodigo_E_CodigoPai(lenCodigo, codigoPai);
    }
    
    @GetMapping("/sistemaModuloCaminho/ordenar_por_id_desc6/{codigoPai3}")
    public Iterable<SistemaModuloCaminho> listarTodos_Ordenar_por_id_desc6(@PathVariable String codigoPai3){
        return sistemaModuloCaminhoRepository.func303FindAll_PorCodigoPai(codigoPai3);
    }


    @GetMapping("/sistemaModuloCaminho/listar_por_grupo_codigo/{grupoId}/{codigo}")
    public Iterable<SistemaModuloCaminho> listarTodos_por_grupo_codigo(@PathVariable Integer grupoId, 
        @PathVariable String codigo){
        return sistemaModuloCaminhoRepository.func308FindAll_PorGrupo_codigo(grupoId, codigo);
    }

    
    
    
    //insercões
    @PostMapping("/sistemaModuloCaminho/nivel3")
    public SistemaModuloCaminho inserirNivel3(@RequestBody SistemaModuloCaminho sistemaModuloCaminho3){

        //variaveis
        String codigo    = null;
        String codigoPai = null;

        //verifica nulidade de sistemaModuloCaminho
        if (sistemaModuloCaminho3 != null) {
            
            codigo    = func103_gera_novo_codigo_por_codigoPai(null);
            codigoPai = "ROOT";
            SistemaModuloCaminho sistemaModuloCaminho_insert = new SistemaModuloCaminho(null, 
                sistemaModuloCaminho3.getAbreviada().trim().toUpperCase(), 
                codigo, 
                codigoPai, 
                sistemaModuloCaminho3.getCaminhoFicheiroXhtml() == null || sistemaModuloCaminho3.getCaminhoFicheiroXhtml() == "" ? null : sistemaModuloCaminho3.getCaminhoFicheiroXhtml().trim(), 
                sistemaModuloCaminho3.getDescricao().trim(), 
                sistemaModuloCaminho3.getIcone().trim(), 
                sistemaModuloCaminho3.getComponente() == null || sistemaModuloCaminho3.getComponente() == "" ? null : sistemaModuloCaminho3.getComponente().trim(),
                sistemaModuloCaminho3.getBloqueioLink());
                
                System.out.println("SMC = "+sistemaModuloCaminho_insert.toString());
                return sistemaModuloCaminhoRepository.save(sistemaModuloCaminho_insert);                

        }

        return null;

    }


    @PostMapping("/sistemaModuloCaminho/nivel6")
    public SistemaModuloCaminho inserirNivel6(@RequestBody SistemaModuloCaminho sistemaModuloCaminho6){

        //variaveis      
        String codigoPai = sistemaModuloCaminho6.getCodigoPai();
        String codigo    = func103_gera_novo_codigo_por_codigoPai(codigoPai);
        
        SistemaModuloCaminho sistemaModuloCaminho_insert6 = new SistemaModuloCaminho(null, 
                sistemaModuloCaminho6.getAbreviada(), 
                codigo, 
                codigoPai, 
                sistemaModuloCaminho6.getCaminhoFicheiroXhtml() == null || sistemaModuloCaminho6.getCaminhoFicheiroXhtml() == "" ? null : sistemaModuloCaminho6.getCaminhoFicheiroXhtml().trim(), 
                sistemaModuloCaminho6.getDescricao().trim().toUpperCase(), 
                sistemaModuloCaminho6.getIcone().trim(), 
                sistemaModuloCaminho6.getComponente() == null || sistemaModuloCaminho6.getComponente() == "" ? null : sistemaModuloCaminho6.getComponente().trim(),
                sistemaModuloCaminho6.getBloqueioLink() == null || sistemaModuloCaminho6.getBloqueioLink() == "" ? null : sistemaModuloCaminho6.getBloqueioLink().trim());
                
                //System.out.println("SMC6 = "+sistemaModuloCaminho_insert6.toString()); return null;
                return sistemaModuloCaminhoRepository.save(sistemaModuloCaminho_insert6);                
        
    }


    @PostMapping("/sistemaModuloCaminho/nivel9")
    public SistemaModuloCaminho inserirNivel9(@RequestBody SistemaModuloCaminho sistemaModuloCaminho9){

        //variaveis      
        String codigoPai = sistemaModuloCaminho9.getCodigoPai();
        String codigo    = func103_gera_novo_codigo_por_codigoPai(codigoPai);
        
        SistemaModuloCaminho sistemaModuloCaminho_insert9 = new SistemaModuloCaminho(null, 
                sistemaModuloCaminho9.getAbreviada(), 
                codigo, 
                codigoPai, 
                sistemaModuloCaminho9.getCaminhoFicheiroXhtml() == null || sistemaModuloCaminho9.getCaminhoFicheiroXhtml() == "" ? null : sistemaModuloCaminho9.getCaminhoFicheiroXhtml().trim(), 
                sistemaModuloCaminho9.getDescricao().trim(), 
                sistemaModuloCaminho9.getIcone().trim(), 
                sistemaModuloCaminho9.getComponente() == null || sistemaModuloCaminho9.getComponente() == "" ? null : sistemaModuloCaminho9.getComponente().trim(),
                sistemaModuloCaminho9.getBloqueioLink() == null || sistemaModuloCaminho9.getBloqueioLink() == "" ? null : sistemaModuloCaminho9.getBloqueioLink().trim());
                
                //System.out.println("SMC9 = "+sistemaModuloCaminho_insert9.toString()); return null;
                return sistemaModuloCaminhoRepository.save(sistemaModuloCaminho_insert9);             

        
    }


    @PostMapping("/sistemaModuloCaminho/nivel12")
    public SistemaModuloCaminho inserirNivel12(@RequestBody SistemaModuloCaminho sistemaModuloCaminho12){

        //variaveis      
        String codigoPai = sistemaModuloCaminho12.getCodigoPai();
        String codigo    = func103_gera_novo_codigo_por_codigoPai(codigoPai);
        
        SistemaModuloCaminho sistemaModuloCaminho_insert12 = new SistemaModuloCaminho(null, 
                sistemaModuloCaminho12.getAbreviada(), 
                codigo, 
                codigoPai, 
                sistemaModuloCaminho12.getCaminhoFicheiroXhtml() == null || sistemaModuloCaminho12.getCaminhoFicheiroXhtml() == "" ? null : sistemaModuloCaminho12.getCaminhoFicheiroXhtml().trim(), 
                sistemaModuloCaminho12.getDescricao().trim(), 
                sistemaModuloCaminho12.getIcone().trim(), 
                sistemaModuloCaminho12.getComponente() == null || sistemaModuloCaminho12.getComponente() == "" ? null : sistemaModuloCaminho12.getComponente().trim(),
                sistemaModuloCaminho12.getBloqueioLink() == null || sistemaModuloCaminho12.getBloqueioLink() == "" ? null : sistemaModuloCaminho12.getBloqueioLink().trim());
                
                //System.out.println("SMC15 = "+sistemaModuloCaminho_insert15.toString()); return null;
                return sistemaModuloCaminhoRepository.save(sistemaModuloCaminho_insert12);   

        
    }


    @PostMapping("/sistemaModuloCaminho/nivel15")
    public SistemaModuloCaminho inserirNivel15(@RequestBody SistemaModuloCaminho sistemaModuloCaminho15){

        //variaveis      
        String codigoPai = sistemaModuloCaminho15.getCodigoPai();
        String codigo    = func103_gera_novo_codigo_por_codigoPai(codigoPai);
        
        SistemaModuloCaminho sistemaModuloCaminho_insert15 = new SistemaModuloCaminho(null, 
                sistemaModuloCaminho15.getAbreviada(), 
                codigo, 
                codigoPai, 
                sistemaModuloCaminho15.getCaminhoFicheiroXhtml() == null || sistemaModuloCaminho15.getCaminhoFicheiroXhtml() == "" ? null : sistemaModuloCaminho15.getCaminhoFicheiroXhtml().trim(), 
                sistemaModuloCaminho15.getDescricao().trim(), 
                sistemaModuloCaminho15.getIcone().trim(), 
                sistemaModuloCaminho15.getComponente() == null || sistemaModuloCaminho15.getComponente() == "" ? null : sistemaModuloCaminho15.getComponente().trim(),
                sistemaModuloCaminho15.getBloqueioLink() == null || sistemaModuloCaminho15.getBloqueioLink() == "" ? null : sistemaModuloCaminho15.getBloqueioLink().trim());
                
                //System.out.println("SMC15 = "+sistemaModuloCaminho_insert15.toString()); return null;
                return sistemaModuloCaminhoRepository.save(sistemaModuloCaminho_insert15);   

        
    }



    @PostMapping("/sistemaModuloCaminho/nivel18")
    public SistemaModuloCaminho inserirNivel18(@RequestBody SistemaModuloCaminho sistemaModuloCaminho18){

        //variaveis      
        String codigoPai = sistemaModuloCaminho18.getCodigoPai();
        String codigo    = func103_gera_novo_codigo_por_codigoPai(codigoPai);
        
        SistemaModuloCaminho sistemaModuloCaminho_insert18 = new SistemaModuloCaminho(null, 
                sistemaModuloCaminho18.getAbreviada(), 
                codigo, 
                codigoPai, 
                sistemaModuloCaminho18.getCaminhoFicheiroXhtml() == null || sistemaModuloCaminho18.getCaminhoFicheiroXhtml() == "" ? null : sistemaModuloCaminho18.getCaminhoFicheiroXhtml().trim(), 
                sistemaModuloCaminho18.getDescricao().trim(), 
                sistemaModuloCaminho18.getIcone().trim(), 
                sistemaModuloCaminho18.getComponente() == null || sistemaModuloCaminho18.getComponente() == "" ? null : sistemaModuloCaminho18.getComponente().trim(),
                sistemaModuloCaminho18.getBloqueioLink() == null || sistemaModuloCaminho18.getBloqueioLink() == "" ? null : sistemaModuloCaminho18.getBloqueioLink().trim());
                
                //System.out.println("SMC15 = "+sistemaModuloCaminho_insert15.toString()); return null;
                return sistemaModuloCaminhoRepository.save(sistemaModuloCaminho_insert18);   

        
    }



    @PostMapping("/sistemaModuloCaminho/nivel21")
    public SistemaModuloCaminho inserirNivel21(@RequestBody SistemaModuloCaminho sistemaModuloCaminho21){

        //variaveis      
        String codigoPai = sistemaModuloCaminho21.getCodigoPai();
        String codigo    = func103_gera_novo_codigo_por_codigoPai(codigoPai);
        
        SistemaModuloCaminho sistemaModuloCaminho_insert21 = new SistemaModuloCaminho(null, 
                sistemaModuloCaminho21.getAbreviada(), 
                codigo, 
                codigoPai, 
                sistemaModuloCaminho21.getCaminhoFicheiroXhtml() == null || sistemaModuloCaminho21.getCaminhoFicheiroXhtml() == "" ? null : sistemaModuloCaminho21.getCaminhoFicheiroXhtml().trim(), 
                sistemaModuloCaminho21.getDescricao().trim(), 
                sistemaModuloCaminho21.getIcone().trim(), 
                sistemaModuloCaminho21.getComponente() == null || sistemaModuloCaminho21.getComponente() == "" ? null : sistemaModuloCaminho21.getComponente().trim(),
                sistemaModuloCaminho21.getBloqueioLink() == null || sistemaModuloCaminho21.getBloqueioLink() == "" ? null : sistemaModuloCaminho21.getBloqueioLink().trim());
                
                //System.out.println("SMC21 = "+sistemaModuloCaminho_insert21.toString()); return null;
                return sistemaModuloCaminhoRepository.save(sistemaModuloCaminho_insert21);   

        
    }




    //alterações
    @PutMapping("/sistemaModuloCaminho/alteracao")
    public SistemaModuloCaminho alteracao(@RequestBody SistemaModuloCaminho sistemaModuloCaminho){

        SistemaModuloCaminho sistemaModuloCaminho_alter = new SistemaModuloCaminho(sistemaModuloCaminho.getId(), 
                sistemaModuloCaminho.getAbreviada()            == null ? null : sistemaModuloCaminho.getAbreviada().trim(), 
                sistemaModuloCaminho.getCodigo()               == null ? null : sistemaModuloCaminho.getCodigo().trim(), 
                sistemaModuloCaminho.getCodigoPai()            == null ? null : sistemaModuloCaminho.getCodigoPai().trim(), 
                sistemaModuloCaminho.getCaminhoFicheiroXhtml() == null ? null : sistemaModuloCaminho.getCaminhoFicheiroXhtml().trim(), 
                sistemaModuloCaminho.getDescricao().trim(), 
                sistemaModuloCaminho.getIcone().trim(), 
                sistemaModuloCaminho.getComponente()           == null ? null : sistemaModuloCaminho.getComponente().trim(),
                sistemaModuloCaminho.getBloqueioLink()         == null ? null : sistemaModuloCaminho.getBloqueioLink().trim());

        int conta_uso_smc_em_menu = menuRepository.func103CountAll_PorSistemaModuloCaminhoId(sistemaModuloCaminho_alter.getId());

        //verfica nulidade de conta_uso_smc_em_menu
        if(conta_uso_smc_em_menu != 0){

            //actualiza os dados de SMC em menus
            new DAO().func001_update_menu(sistemaModuloCaminho_alter);

        }
                
        //System.out.println("SMC = "+sistemaModuloCaminho_alter.toString()); return null;
        return sistemaModuloCaminhoRepository.save(sistemaModuloCaminho_alter);

    }







    // eliminações
    @DeleteMapping("/sistemaModuloCaminho/eliminacao/{id}")
    public void eliminar(@PathVariable Integer id){
        sistemaModuloCaminhoRepository.deleteById(id);
    }


    /*@DeleteMapping("/sistemaModuloCaminho/eliminacao_por_codigo/{id}")
    public void eliminar2(@PathVariable Integer id){
        SistemaModuloCaminho smc = sistemaModuloCaminhoRepository.func201FindOne_PorId(id);
        new DAO().func002_delete_smc(smc);
    }*/

    @DeleteMapping("/sistemaModuloCaminho/eliminacao_por_codigo/{id}")
    public ResponseEntity<Map<String, Object>> eliminar2(@PathVariable Integer id) {
        System.out.println(" ------ id = "+id);
        Map<String, Object> resposta = new HashMap<>();

        try {

            SistemaModuloCaminho smc = sistemaModuloCaminhoRepository.func201FindOne_PorId(id);

            //verifica smc
            if(smc == null){

                resposta.put("sucesso", false);
                resposta.put("mensagem", "Registro de Sistema-Modulo-Caminho não encontrado.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);

            } else {

                new DAO().func002_delete_smc(smc);
                resposta.put("sucesso", true);
                resposta.put("mensagem", "Sistema-Modulo-Caminho Excluído com sucesso.");
                return ResponseEntity.ok(resposta);
                //System.out.println("Entrou no delete"); return null; 

            }
            
        } catch (Exception e) {
            resposta.put("sucesso", false);
            resposta.put("mensagem", "Erro ao excluir Sistema-Modulo-Caminho: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resposta);
        }

    }

    


    
}
